package com.dreammaster.modcustomdrops;

import static gregtech.api.enums.Mods.Thaumcraft;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import org.jetbrains.annotations.NotNull;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.kuba6000.mobsinfo.api.IChanceModifier;
import com.kuba6000.mobsinfo.api.IMobExtraInfoProvider;
import com.kuba6000.mobsinfo.api.MobDrop;
import com.kuba6000.mobsinfo.api.MobRecipe;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import eu.usrv.yamcore.auxiliary.ItemDescriptor;
import eu.usrv.yamcore.auxiliary.LogHelper;
import eu.usrv.yamcore.auxiliary.PlayerChatHelper;
import eu.usrv.yamcore.persisteddata.PersistedDataBase;
import gregtech.api.enums.Mods;
import io.netty.buffer.ByteBuf;
import thaumcraft.common.lib.FakeThaumcraftPlayer;

@Optional.Interface(iface = "com.kuba6000.mobsinfo.api.IMobExtraInfoProvider", modid = Mods.ModIDs.MOBS_INFO)
public class CustomDropsHandler implements IMobExtraInfoProvider {

    private LogHelper _mLogger = MainRegistry.Logger;
    private String _mConfigFileName;
    private CustomDropsFactory _mCfF = new CustomDropsFactory();
    private CustomDrops _mCustomDrops;
    private PersistedDataBase _mPersistedDB;
    private List<UUID> _mDeathDebugPlayers;

    public CustomDropsHandler(File pConfigBaseDir) {
        _mConfigFileName = String.format("config/%s/CustomDrops.xml", Refstrings.COLLECTIONID);
        _mDeathDebugPlayers = new ArrayList<>();
    }

    public void InitSampleConfig() {
        CustomDrops.CustomDrop.Drop pigDiamondLimitedDrop = _mCfF.createDrop(
                "minecraft:diamond",
                "sample_Pig_DiamondDrop",
                "{Lore: [\"Oh, shiny!\"]}",
                1,
                false,
                100,
                5);
        CustomDrops.CustomDrop.Drop pigCakeUnlimitedDrop = _mCfF
                .createDrop("minecraft:cake", "sample_Pig_CakeDrop", 1, false, 100, 0);
        CustomDrops.CustomDrop.Drop pigRandomCharcoalDrop = _mCfF
                .createDrop("minecraft:coal:1", "sample_Pig_CharcoalDrop", 5, true, 100, 0);

        CustomDrops.CustomDrop pigDrop = _mCfF.createCustomDropEntry("eu.usrv.dummyEntity.ImbaSampleDragon");
        pigDrop.getDrops().add(pigDiamondLimitedDrop);
        pigDrop.getDrops().add(pigCakeUnlimitedDrop);
        pigDrop.getDrops().add(pigRandomCharcoalDrop);

        _mCustomDrops = new CustomDrops();
        _mCustomDrops.getCustomDrops().add(pigDrop);
    }

    public boolean SaveCustomDrops() {
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(CustomDrops.class);
            Marshaller jaxMarsh = tJaxbCtx.createMarshaller();
            jaxMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxMarsh.marshal(_mCustomDrops, new FileOutputStream(_mConfigFileName, false));

            _mLogger.debug("Config file written");
            return true;
        } catch (Exception e) {
            _mLogger.error("Unable to create new CustomDrops.xml. What did you do??");
            e.printStackTrace();
            return false;
        }
    }

    public void LoadConfig() {
        _mLogger.debug("CustomDrops entering state: LOAD CONFIG");
        File tConfigFile = new File(_mConfigFileName);
        if (!tConfigFile.exists()) {
            _mLogger.debug("CustomDrops Config file not found, assuming first-start. Creating default one");
            InitSampleConfig();
            SaveCustomDrops();
        }

        // Fix for broken XML file; If it can't be loaded on reboot, keep it
        // there to be fixed, but load
        // default setting instead, so an Op/Admin can do reload ingame
        if (!ReloadCustomDrops()) {
            _mLogger.warn(
                    "Configuration File seems to be damaged, loading does-nothing-evil default config. You should fix your file and reload it");
            MainRegistry.AddLoginError("[CustomDrops] Config file not loaded due errors");
            InitSampleConfig();
        }
    }

    private boolean VerifyConfig(CustomDrops pDropListToCheck) {
        boolean tSuccess = true;

        for (CustomDrops.CustomDrop X : pDropListToCheck.getCustomDrops()) {
            for (CustomDrops.CustomDrop.Drop Y : X.getDrops()) {
                if (ItemDescriptor.fromString(Y.getItemName()) == null) {
                    _mLogger.error(
                            String.format(
                                    "In ItemDropID: [%s], can't find item [%s]",
                                    Y.getIdentifier(),
                                    Y.getItemName()));
                    tSuccess = false;
                }

                if (Y.mTag != null && !Y.mTag.isEmpty()) {
                    try {
                        NBTTagCompound tNBT = (NBTTagCompound) JsonToNBT.func_150315_a(Y.mTag);
                        if (tNBT == null) {
                            tSuccess = false;
                        }
                    } catch (Exception e) {
                        _mLogger.error(String.format("In ItemDropID: [%s], NBTTag is invalid", Y.getIdentifier()));
                        tSuccess = false;
                    }
                }
            }
        }
        return tSuccess;
    }

    public boolean ReloadCustomDrops() {
        boolean tResult = false;

        _mLogger.debug("CustomDropsHandler will now try to load its configuration");
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(CustomDrops.class);
            File tConfigFile = new File(_mConfigFileName);
            Unmarshaller jaxUnmarsh = tJaxbCtx.createUnmarshaller();
            CustomDrops tNewItemCollection = (CustomDrops) jaxUnmarsh.unmarshal(tConfigFile);
            _mLogger.debug("Config file has been loaded. Entering Verify state");

            if (!VerifyConfig(tNewItemCollection)) {
                _mLogger.error("New config will NOT be activated. Please check your error-log and try again");
                tResult = false;
            } else {
                _mCustomDrops = tNewItemCollection;
                tResult = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tResult;
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent pEvent) {
        try {
            EntityLivingBase tEntity = pEvent.entityLiving;
            UUID tUUID;
            EntityPlayer tEP = null;

            if (pEvent.source.getEntity() != null) {
                if (pEvent.source.getEntity() instanceof EntityPlayer) {
                    tEP = (EntityPlayer) pEvent.source.getEntity();
                    tUUID = tEP.getUniqueID();
                    if (_mDeathDebugPlayers.contains(tUUID)) {
                        PlayerChatHelper
                                .SendInfo(tEP, String.format("Killed entity: [%s]", tEntity.getClass().getName()));
                    }
                }
            }

            if (tEP == null) // Not doing anything, only players are valid
            {
                return;
            }
            if (tEP instanceof FakePlayer) // Nope,
            // no
            // fakeplayers
            {
                return;
            }
            if (Thaumcraft.isModLoaded()) {
                if (tEP instanceof FakeThaumcraftPlayer) {
                    return;
                }
            }

            CustomDrops.CustomDrop tCustomDrop = _mCustomDrops.FindDropEntry(tEntity);
            if (tCustomDrop == null) {
                return; // no custom drop defined for this
            }
            // mob, skipping

            HandleCustomDrops(tCustomDrop, tEntity, tEP, pEvent.drops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Optional.Method(modid = Mods.ModIDs.MOBS_INFO)
    @Override
    public void provideExtraDropsInformation(@NotNull String entityString, @NotNull ArrayList<MobDrop> drops,
            @NotNull MobRecipe recipe) {
        CustomDrops.CustomDrop customDrop = _mCustomDrops.FindDropEntry(recipe.entity);
        if (customDrop == null) return;
        for (CustomDrops.CustomDrop.Drop drop : customDrop.getDrops()) {
            ItemStack stack = ItemDescriptor.fromString(drop.getItemName()).getItemStackwNBT(1, drop.mTag);
            if (stack == null) continue;
            double chance = drop.getChance() / 100d;
            if (drop.getIsRandomAmount()) {
                chance *= MobDrop.getChanceBasedOnFromTo(1, drop.getAmount());
            } else {
                stack.stackSize = drop.getAmount();
            }
            MobDrop mobDrop = MobDrop.create(stack).withChance(chance).withHardPlayerRestriction();
            mobDrop.clampChance();
            if (drop.getLimitedDropCount() > 0) {
                mobDrop.withChanceModifiers(
                        new IChanceModifier.NormalChance(mobDrop.chance / 100d),
                        new LimitedDropCountModifier(drop.getLimitedDropCount()));
            }
            drops.add(mobDrop);
        }
    }

    private void HandleCustomDrops(CustomDrops.CustomDrop tCustomDrop, EntityLivingBase tEntity, EntityPlayer tEP,
            ArrayList<EntityItem> pDropList) {
        try {
            if (_mPersistedDB == null) {
                _mPersistedDB = new PersistedDataBase(
                        DimensionManager.getCurrentSaveRootDirectory(),
                        "CustomDrops.dat",
                        Refstrings.COLLECTIONID);
            }

            for (CustomDrops.CustomDrop.Drop dr : tCustomDrop.getDrops()) {
                String tDropID = dr.getIdentifier();
                String tUserID = tEP.getUniqueID().toString();
                String tFinalDropID = String.format("%s.%s", tUserID, tDropID);
                int tFinalAmount = dr.getAmount();

                if (MainRegistry.Rnd.nextInt(100) > dr.getChance()) {
                    continue;
                }

                // Is this drop limited?
                if (dr.getLimitedDropCount() > 0) {
                    // if it is, check if player already got this item. If so,
                    // skip this drop
                    int tDropCount = _mPersistedDB.getValueAsInt(tFinalDropID, 0);
                    if (tDropCount >= dr.getLimitedDropCount()) {
                        continue;
                    } else {
                        // Player will get the drop this time, increase his
                        // counter
                        _mPersistedDB.setValue(tFinalDropID, ++tDropCount);
                    }
                }

                if (dr.getIsRandomAmount()) {
                    tFinalAmount = MainRegistry.Rnd.nextInt(dr.getAmount()) + 1;
                }

                ItemStack tDropStack = ItemDescriptor.fromString(dr.getItemName())
                        .getItemStackwNBT(tFinalAmount, dr.mTag);
                if (tDropStack == null) {
                    _mLogger.error(String.format("CustomDrop ID %s failed to drop", dr.getIdentifier()));
                } else {
                    EntityItem tDropEntity = new EntityItem(
                            tEntity.worldObj,
                            tEntity.posX,
                            tEntity.posY,
                            tEntity.posZ,
                            tDropStack);
                    pDropList.add(tDropEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleDeathInfoForPlayer(EntityPlayer pEP) {
        UUID tUUID = pEP.getUniqueID();
        if (_mDeathDebugPlayers.contains(tUUID)) {
            _mDeathDebugPlayers.remove(tUUID);
            PlayerChatHelper.SendInfo(pEP, "Death-Debug is now diabled");
        } else {
            _mDeathDebugPlayers.add(tUUID);
            PlayerChatHelper.SendInfo(pEP, "Death-Debug is now enabled");
        }
    }

    private static class LimitedDropCountModifier implements IChanceModifier {

        int limit;

        LimitedDropCountModifier() {}

        LimitedDropCountModifier(int limit) {
            this.limit = limit;
        }

        @Override
        public String getDescription() {
            return StatCollector.translateToLocalFormatted("dreamcraft.mobsinfocompat.limitedropcount", limit);
        }

        @Override
        public double apply(double chance, @NotNull World world, @NotNull List<ItemStack> drops, Entity attacker,
                EntityLiving victim) {
            return 0;
        }

        @Override
        public void writeToByteBuf(ByteBuf byteBuf) {
            byteBuf.writeInt(limit);
        }

        @Override
        public void readFromByteBuf(ByteBuf byteBuf) {
            limit = byteBuf.readInt();
        }
    }
}
