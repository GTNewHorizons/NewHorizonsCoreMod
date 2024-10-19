package com.dreammaster.auxiliary;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static gregtech.api.enums.Mods.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;

import com.dreammaster.item.food.QuantumBread;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import goodgenerator.loader.Loaders;
import gregtech.api.GregTechAPI;
import gregtech.api.util.GTModHandler;
import tectech.thing.casing.TTCasingsContainer;

public class NEIGTNewHorizonsConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(QuantumBread.Instance()));

        API.hideItem(new ItemStack(Loaders.antimatterRenderBlock));
        API.hideItem(new ItemStack(GregTechAPI.sDroneRender));
        API.hideItem(new ItemStack(GregTechAPI.sWormholeRender));
        API.hideItem(new ItemStack(GregTechAPI.sBlackholeRender));
        API.hideItem(new ItemStack(TTCasingsContainer.eyeOfHarmonyRenderBlock));
        API.hideItem(new ItemStack(TTCasingsContainer.forgeOfGodsRenderBlock));

        if (Aroma1997Core.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(Aroma1997Core.ID, "wrenched", 1));
        }

        if (BiblioCraft.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(BiblioCraft.ID, "BiblioClipboard", 1));
        }

        if (EnderZoo.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(EnderZoo.ID, "enderZooIcon", 1));
        }

        if (ExtraBees.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 19, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 20, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 21, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 22, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 23, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 24, missing));
            API.hideItem(GTModHandler.getModItem(ExtraBees.ID, "misc", 1, 25, missing));
        }

        if (ExtraTrees.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ExtraTrees.ID, "multifence", 1, 16387));
        }

        if (ForgeRelocation.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ForgeRelocation.ID, "relocation.blockmovingrow", 1));
        }

        if (GraviSuite.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(GraviSuite.ID, "BlockRelocatorPortal", 1));
        }

        if (HardcoreEnderExpansion.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "death_flower_pot", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_high", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "biome_core", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_low", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "enhanced_brewing_stand_block", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "temple_end_portal", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "laser_beam", 1));
            API.hideItem(GTModHandler.getModItem(HardcoreEnderExpansion.ID, "item_special_effects", 1));
        }

        if (Mantle.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(Mantle.ID, "mantleBook", 1));
        }

        if (Thaumcraft.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(Thaumcraft.ID, "blockWarded", 1));
            API.hideItem(GTModHandler.getModItem(Thaumcraft.ID, "blockEldritchNothing", 1));
        }

        if (ThaumicHorizons.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "vatInterior", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "evanescent", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "portalTH", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 1));
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 15));
            API.hideItem(GTModHandler.getModItem(ThaumicHorizons.ID, "dummyVat", 1));
        }

        if (ThaumicMachina.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ThaumicMachina.ID, "metaphysicalBrick", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicMachina.ID, "metaphysicalRose", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicMachina.ID, "wandCore", 1));
        }

        if (ThaumicTinkerer.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ThaumicTinkerer.ID, "gaseousLight", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicTinkerer.ID, "gaseousShadow", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicTinkerer.ID, "infusedGrainBlock", 1));
            API.hideItem(GTModHandler.getModItem(ThaumicTinkerer.ID, "nitorGas", 1));
        }
        if (TwilightForest.isModLoaded()) {
            for (int i = 5; i <= 15; i++) {
                API.hideItem(GTModHandler.getModItem(TwilightForest.ID, "tile.TFBossSpawner", 1, i));
                API.hideItem(GTModHandler.getModItem(TwilightForest.ID, "tile.TFTowerTranslucent", 1, i));
            }
            API.hideItem(GTModHandler.getModItem(TwilightForest.ID, "tile.TFTrophy", 1));
            API.hideItem(GTModHandler.getModItem(TwilightForest.ID, "tile.TFUncraftingTable", 1, 0, missing));
        }

        if (WarpTheory.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(WarpTheory.ID, "blockVanish", 1));
        }

        if (AppliedEnergistics2.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockPaint", 1));
        }

        if (Chisel.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(Chisel.ID, "amber", 1));
            API.hideItem(GTModHandler.getModItem(Chisel.ID, "bloodBrick", 1));
        }
        if (PamsHarvestCraft.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(PamsHarvestCraft.ID, "ovenon", 1));
            API.hideItem(GTModHandler.getModItem(PamsHarvestCraft.ID, "churnon", 1));
            API.hideItem(GTModHandler.getModItem(PamsHarvestCraft.ID, "quernon", 1));
        }
        if (MalisisDoors.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(MalisisDoors.ID, "null", 1));
        }

        if (OpenSecurity.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(OpenSecurity.ID, "SecurityDoor", 1));
            API.hideItem(GTModHandler.getModItem(OpenSecurity.ID, "SecurityDoorPrivate", 1));
        }
        if (SleepingBags.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(SleepingBags.ID, "sleepingBagBlock", 1));
        }
        if (BiomesOPlenty.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 9, missing));
            API.hideItem(GTModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 8, missing));
            API.hideItem(GTModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 5, missing));
            API.hideItem(GTModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 7, missing));
            API.hideItem(GTModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 6, missing));
        }
        if (MagicBees.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(MagicBees.ID, "capsule.magic", 1, wildcard, missing));
            API.hideItem(GTModHandler.getModItem(MagicBees.ID, "capsule.void", 1, wildcard, missing));
        }

        if (ForbiddenMagic.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(ForbiddenMagic.ID, "FMResource", 1, 1, missing));
        }

        if (Natura.isModLoaded()) {
            API.hideItem(GTModHandler.getModItem(Natura.ID, "barleyFood", 1, 8, missing));
        }

        if (EnderIO.isModLoaded()) {
            ItemStack creativeBank = GTModHandler.getModItem(EnderIO.ID, "blockCapBank", 1, 0, missing);
            creativeBank.setTagInfo("type", new NBTTagString("CREATIVE"));
            creativeBank.setTagInfo("storedEnergyRF", new NBTTagInt(2500000));
        }

        API.setOverrideName(new ItemStack(Blocks.ender_chest), "Personal Ender Chest");

        MainRegistry.Logger.info("Added NEI Config");
    }

    @Override
    public String getName() {
        return "GTNewHorizons-NEIConfig";
    }

    @Override
    public String getVersion() {
        return Refstrings.VERSION;
    }
}
