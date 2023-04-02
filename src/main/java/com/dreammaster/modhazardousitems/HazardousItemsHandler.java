package com.dreammaster.modhazardousitems;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fluids.IFluidContainerItem;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.modhazardousitems.HazardousItems.HazardousItem;
import com.dreammaster.modhazardousitems.cause.HazardCause;
import com.google.common.collect.EvictingQueue;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;
import eu.usrv.yamcore.auxiliary.ItemDescriptor;
import eu.usrv.yamcore.auxiliary.LogHelper;
import eu.usrv.yamcore.gameregistry.PotionHelper;
import gregtech.api.util.GT_Utility;

import static com.dreammaster.MissingModIDs.MineAndBladeBattleGear2;

/**
 * Eventhandler to apply configured Damage Values to player, if they have certain items in their inventory
 *
 * @author Namikon
 *
 */
public class HazardousItemsHandler {

    private final Random _mRnd = new Random();
    private final LogHelper _mLogger = MainRegistry.Logger;
    private HazardousItems _mHazardItemsCollection;
    private final String _mConfigFileName;
    private final HazardousObjectFactory _mHazFactory = new HazardousObjectFactory();
    private boolean IsConfigDirty = false;
    private boolean _mRunProfiler;

    private final EvictingQueue<Long> _mTimingQueue = EvictingQueue.create(20);
    private long _mLastAverage = 0;

    private long ticks = 0;
    private int touchBlockChance = 20;
    private int inventoryCheckPeriod = 3 * 20;

    public HazardousItemsHandler() {
        _mRunProfiler = true;
        _mConfigFileName = String.format("config/%s/HazardousItems.xml", Refstrings.COLLECTIONID);
    }

    public boolean HasConfigChanged() {
        return IsConfigDirty;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.worldObj.isRemote) {
            return;
        }

        if (GT_Utility.isWearingFullGasHazmat(event.player)) {
            // Ideally we should check against individual potion effect / damage effect, as this method
            // checks only for GregTech_API.sGasHazmatList. But actually almost all the hazmat protection armors
            // can protect against all kinds of sXXXHazmatList.
            return;
        }

        long tStart = System.currentTimeMillis();
        CheckInventoryForItems(event.player);
        CheckPlayerTouchesBlock(event.player);
        ticks++;
        long tEnd = System.currentTimeMillis();

        _mTimingQueue.add(tEnd - tStart);

        // Should be called once a second...
        if (tEnd + 1000 > _mLastAverage && _mRunProfiler) {
            // is 250 a good value? I mean, 250ms for ONE LOOP is still pretty insane...
            if (getAverageTiming() > 250) {
                // lol wut...
                if (touchBlockChance > 500) {
                    _mLogger.error(
                            "Execution chance is over 500. Not going to increase wait-timer anymore. if it still lags, contact me and we'll find another way");
                    _mRunProfiler = false;
                    _mLogger.error("HazardousItems-Profiler is now disabled");
                    return;
                }

                _mLogger.warn(
                        "WARNING: The HazardousItems loop has an average timing of > 250ms, which may cause lag. Increasing wait-time between inventory-scan calls");
                touchBlockChance++;
                inventoryCheckPeriod++;
                _mTimingQueue.clear(); // Reset queue to prevent re-warn on next call
            } else {
                // All good, loop seems to be fast enough
                _mLastAverage = System.currentTimeMillis();
            }
        }
    }

    private long getAverageTiming() {
        if (_mTimingQueue.isEmpty()) {
            return 0;
        }

        // Only do average calc once we have 20 elements
        if (_mTimingQueue.remainingCapacity() != 0) {
            return 0;
        }

        long sum = 0;
        for (long time : _mTimingQueue) {
            sum += time;
        }

        return sum / _mTimingQueue.size();
    }

    public void InitSampleConfig() {
        // Create new DamageEffect
        HazardousItems.ItmDamageEffect tFireEffect = _mHazFactory.createDamageEffect(0.5F, "inFire");

        // Create new Potioneffect
        HazardousItems.ItmPotionEffect tPoisonPotion = _mHazFactory.createPotionEffect(100, Potion.poison.id, 1);

        // Define a testitem to hold these effects
        HazardousItem tHazItem = _mHazFactory.createHazardousItemsHazardousItem("tfarcenim:stone", true, true, true);

        HazardousItems.HazardousFluid tHazFluid = _mHazFactory
                .createHazardousFluid("tfarcenim:water", true, true, true);

        // Add both effects to our defined testItem
        tHazItem.getDamageEffects().add(tFireEffect);
        tHazItem.getPotionEffects().add(tPoisonPotion);

        tHazFluid.getDamageEffects().add(tFireEffect);
        tHazFluid.getPotionEffects().add(tPoisonPotion);

        _mHazardItemsCollection = new HazardousItems();
        _mHazardItemsCollection.getHazardousItems().add(tHazItem);
        _mHazardItemsCollection.getHazardousFluids().add(tHazFluid);
    }

    /**
     * Save hazardous items to disk, overwriting any existing xml file
     *
     * @return
     */
    public boolean SaveHazardousItems() {
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(HazardousItems.class);
            Marshaller jaxMarsh = tJaxbCtx.createMarshaller();
            jaxMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxMarsh.marshal(_mHazardItemsCollection, new FileOutputStream(_mConfigFileName, false));

            _mLogger.debug("Config file written");
            IsConfigDirty = false;
            return true;
        } catch (Exception e) {
            _mLogger.error("Unable to create new HazardousItems.xml. What did you do??");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Initial Loading of config with automatic creation of default xml
     */
    public void LoadConfig() {
        _mLogger.debug("HazardousItems entering state: LOAD CONFIG");
        File tConfigFile = new File(_mConfigFileName);
        if (!tConfigFile.exists()) {
            _mLogger.debug("HazardousItems Config file not found, assuming first-start. Creating default one");
            InitSampleConfig();
            SaveHazardousItems();
        }

        // Fix for broken XML file; If it can't be loaded on reboot, keep it
        // there to be fixed, but load
        // default setting instead, so an Op/Admin can do reload ingame
        if (!ReloadHazardousItems()) {
            _mLogger.warn(
                    "Configuration File seems to be damaged, loading does-nothing-evil default config. You should fix your file and reload it");
            MainRegistry.AddLoginError("[HazardousItems] Config file not loaded due errors");
            InitSampleConfig();
        }
    }

    /**
     * Reload item configuration from disk. Will overwrite current List without restart, if the config file is valid
     *
     * @return
     */
    public boolean ReloadHazardousItems() {
        boolean tResult = false;

        _mLogger.debug("HazardousItemsHandler will now try to load it's configuration");
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(HazardousItems.class);
            File tConfigFile = new File(_mConfigFileName);
            Unmarshaller jaxUnmarsh = tJaxbCtx.createUnmarshaller();
            HazardousItems tNewItemCollection = (HazardousItems) jaxUnmarsh.unmarshal(tConfigFile);
            _mLogger.debug("Config file has been loaded. Entering Verify state");

            if (VerifyConfiguredDamageEffects(tNewItemCollection)
                    && VerifyConfiguredPotionEffects(tNewItemCollection)) {
                _mHazardItemsCollection = tNewItemCollection; // Configuration verified, activate now
                IsConfigDirty = false;
                tResult = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tResult;
    }

    /**
     * Verify defined DamageEffects in configfile
     *
     * @param pItemCollection
     * @return true if everything is ok
     */
    public boolean VerifyConfiguredDamageEffects(HazardousItems pItemCollection) {
        boolean tResult = true;
        for (HazardousItem hi : pItemCollection.getHazardousItems()) {
            for (HazardousItems.ItmDamageEffect ide : hi.getDamageEffects()) {
                if (!HazardDamageSources.isValid(ide.getDamageSource())) {
                    _mLogger.warn(
                            String.format(
                                    "HazardousItem [%s] has invalid DamageSource entry: [%s]",
                                    hi.getItemName(),
                                    ide.getDamageSource()));
                    tResult = false;
                }
            }
        }
        for (HazardousItems.HazardousFluid hf : pItemCollection.getHazardousFluids()) {
            for (HazardousItems.ItmDamageEffect ide : hf.getDamageEffects()) {
                if (!HazardDamageSources.isValid(ide.getDamageSource())) {
                    _mLogger.warn(
                            String.format(
                                    "HazardousFluid [%s] has invalid DamageSource entry: [%s]",
                                    hf.getFluidName(),
                                    ide.getDamageSource()));
                    tResult = false;
                }
            }
        }

        return tResult;
    }

    /**
     * Verify defined potioneffects in configfile
     *
     * @param pItemCollection
     * @return true if everything is ok
     */
    public boolean VerifyConfiguredPotionEffects(HazardousItems pItemCollection) {
        boolean tResult = true;
        for (HazardousItem hi : pItemCollection.getHazardousItems()) {
            for (HazardousItems.ItmPotionEffect ipe : hi.getPotionEffects()) {
                if (!PotionHelper.IsValidPotionID(ipe.getId())) {
                    _mLogger.warn(
                            String.format(
                                    "HazardousItem [%s] has invalid PotionID: [%s] (There is no such potion)",
                                    hi.getItemName(),
                                    ipe.getId()));
                    tResult = false;
                }
            }
        }

        for (HazardousItems.HazardousFluid hf : pItemCollection.getHazardousFluids()) {
            for (HazardousItems.ItmPotionEffect ipe : hf.getPotionEffects()) {
                if (!PotionHelper.IsValidPotionID(ipe.getId())) {
                    _mLogger.warn(
                            String.format(
                                    "HazardousFluid [%s] has invalid PotionID: [%s] (There is no such potion)",
                                    hf.getFluidName(),
                                    ipe.getId()));
                    tResult = false;
                }
            }
        }

        return tResult;
    }

    /**
     * Check if player actually swims in a fluid
     *
     * @param pPlayer
     */
    private void CheckPlayerTouchesBlock(EntityPlayer pPlayer) {
        if (_mRnd.nextInt(touchBlockChance) != 0) {
            return;
        }

        try {
            int blockX = MathHelper.floor_double(pPlayer.posX);
            int blockY = MathHelper.floor_double(pPlayer.boundingBox.minY);
            int blockZ = MathHelper.floor_double(pPlayer.posZ);
            Block pBlockContact = pPlayer.worldObj.getBlock(blockX, blockY, blockZ);
            Block pBlockUnderFeet = pPlayer.worldObj.getBlock(blockX, blockY - 1, blockZ);
            UniqueIdentifier tUidContact = GameRegistry.findUniqueIdentifierFor(pBlockContact);
            UniqueIdentifier tUidFeet = GameRegistry.findUniqueIdentifierFor(pBlockUnderFeet);

            // Skip air block and null results
            if (tUidContact != null && !tUidContact.toString().equals("minecraft:air")) {
                HazardousItems.HazardousFluid hazard = _mHazardItemsCollection
                        .FindHazardousFluidExact(tUidContact.toString());
                if (hazard != null && hazard.getCheckContact()) {
                    doEffects(HazardCause.stepOn(), hazard, pPlayer);
                }
            }

            if (tUidFeet != null && !tUidFeet.toString().equals("minecraft:air")) {
                HazardousItem hazard = _mHazardItemsCollection.FindHazardousItemExact(tUidFeet.toString());
                if (hazard != null && hazard.getCheckContact()) {
                    doEffects(HazardCause.stepOn(), hazard, pPlayer);
                }
            }
        } catch (Exception e) {
            _mLogger.error(
                    "HazardousItemsHandler.CheckPlayerTouchesBlock.error",
                    "Something bad happend while processing the onPlayerTick event");
            e.printStackTrace();
        }
    }

    private void checkInventoryArray(ItemStack[] pInventory, EntityPlayer pPlayer) {
        // Derp protection
        if (pInventory == null) return;

        for (ItemStack stack : pInventory) {
            String tCurrIS = "";
            try {
                if (stack == null) continue;

                tCurrIS = ItemDescriptor.fromStack(stack).toString();
                // Check if item is a fluid container
                if (stack.getItem() instanceof IFluidContainerItem) {
                    HazardousItems.HazardousFluid hazardFluid = _mHazardItemsCollection.FindHazardousFluid(stack);
                    if (hazardFluid != null && hazardFluid.getCheckInventory()) {
                        doEffects(HazardCause.inventoryItem(stack), hazardFluid, pPlayer);
                    }
                }
                // Tinkers' construct smeltery tank
                else if ("tconstruct.smeltery.itemblocks.LavaTankItemBlock"
                        .equals(stack.getItem().getClass().getName())) {
                            NBTTagCompound tNBT = stack.getTagCompound();
                            if (tNBT != null && tNBT.hasKey("Fluid")) {
                                NBTTagCompound tFluidCompound = tNBT.getCompoundTag("Fluid");
                                if (tFluidCompound != null && tFluidCompound.hasKey("FluidName")) {
                                    String tFluidName = tFluidCompound.getString("FluidName");
                                    if (tFluidName != null && !tFluidName.isEmpty()) {
                                        HazardousItems.HazardousFluid hazardFluid = _mHazardItemsCollection
                                                .FindHazardousFluidExact(tFluidName);
                                        if (hazardFluid != null && hazardFluid.getCheckInventory()) {
                                            doEffects(HazardCause.inventoryItem(stack), hazardFluid, pPlayer);
                                        }
                                    }
                                }
                            }
                        } else {
                            HazardousItem hazardItem = _mHazardItemsCollection.FindHazardousItem(stack);
                            if (hazardItem != null && hazardItem.getCheckInventory()) {
                                doEffects(HazardCause.inventoryItem(stack), hazardItem, pPlayer);
                            }
                        }
            } catch (Exception e) {
                _mLogger.debug(String.format("Something weird happend with item %s", tCurrIS));
            }
        }
    }

    private void CheckInventoryForItems(EntityPlayer pPlayer) {
        if (ticks % inventoryCheckPeriod != 0) {
            return;
        }

        try {
            checkInventoryArray(pPlayer.inventory.mainInventory, pPlayer);

            // M&B addition ------
            if (MineAndBladeBattleGear2.isModLoaded()) {
                Class<?> c = pPlayer.inventory.getClass();
                Field extraInv = null;
                try {
                    extraInv = c.getDeclaredField("extraItems");
                } catch (NoSuchFieldException nsfe) {
                    _mLogger.warn(
                            "battlegear.changed.1",
                            "Seems battlegear has updated/changed. Someone has to fix HazardousItems!");
                }

                if (extraInv == null) return;

                try {
                    ItemStack[] tExtraInv = (ItemStack[]) extraInv.get(pPlayer.inventory);
                    checkInventoryArray(tExtraInv, pPlayer);
                } catch (Exception ex) {
                    _mLogger.warn(
                            "battlegear.changed.2",
                            "Seems battlegear has updated/changed. Someone has to fix HazardousItems!");
                }
            }
            // ------ M&B addition

        } catch (Exception e) {
            _mLogger.error(
                    "HazardousItemsHandler.CheckInventoryForItems.error",
                    "Something bad happend while processing the onPlayerTick event");
            e.printStackTrace();
        }
    }

    private void doEffects(HazardCause cause, IDamageEffectContainer effectContainer, EntityPlayer player) {
        for (HazardousItems.ItmDamageEffect effect : effectContainer.getDamageEffects()) {
            effect.apply(cause, player);
        }
        for (HazardousItems.ItmPotionEffect effect : effectContainer.getPotionEffects()) {
            effect.apply(cause, player);
        }
    }
}
