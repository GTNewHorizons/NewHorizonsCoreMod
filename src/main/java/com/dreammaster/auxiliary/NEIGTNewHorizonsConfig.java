package com.dreammaster.auxiliary;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;

import com.dreammaster.item.food.QuantumBread;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import gregtech.api.util.GT_ModHandler;

public class NEIGTNewHorizonsConfig implements IConfigureNEI {

    private void setOverrideName(ItemStack itemStack, String unlocalizedName) {
        API.setOverrideName(itemStack, StatCollector.translateToLocal("override." + unlocalizedName));
    }

    @Override
    public void loadConfig() {
        hideFakeCircuits();
        API.hideItem(new ItemStack(QuantumBread.Instance()));
        if (Aroma1997Core.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Aroma1997Core.ID, "wrenched", 1));
        }

        if (BiblioCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BiblioCraft.ID, "BiblioClipboard", 1));
        }

        if (EnderZoo.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(EnderZoo.ID, "enderZooIcon", 1));
        }

        if (ExtraBees.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 19, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 20, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 21, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 22, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 23, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 24, missing));
            API.hideItem(GT_ModHandler.getModItem(ExtraBees.ID, "misc", 1, 25, missing));
        }

        if (ExtraTrees.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ExtraTrees.ID, "multifence", 1, 16387));
        }

        if (ForgeRelocation.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ForgeRelocation.ID, "relocation.blockmovingrow", 1));
        }

        if (GraviSuite.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(GraviSuite.ID, "BlockRelocatorPortal", 1));
            setOverrideName(
                    GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                    "SuperconductorCover");
            setOverrideName(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1, missing), "Superconductor");
            setOverrideName(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing), "CoolingCore");
            setOverrideName(
                    GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 3, missing),
                    "GravitationEngine");
            setOverrideName(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing), "Magnetron");
            setOverrideName(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing), "VajraCore");
            setOverrideName(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 6, missing), "EngineBooster");
        }

        if (HardcoreEnderExpansion.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "death_flower_pot", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_high", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "biome_core", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_low", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "enhanced_brewing_stand_block", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "temple_end_portal", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "laser_beam", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "item_special_effects", 1));
        }

        if (Mantle.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Mantle.ID, "mantleBook", 1));
        }

        if (Thaumcraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.ID, "blockWarded", 1));
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.ID, "blockEldritchNothing", 1));
        }

        if (ThaumicHorizons.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "vatInterior", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "evanescent", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "portalTH", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 15));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "dummyVat", 1));
        }

        if (ThaumicMachina.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "metaphysicalBrick", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "metaphysicalRose", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "wandCore", 1));
        }

        if (ThaumicTinkerer.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "gaseousLight", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "gaseousShadow", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "infusedGrainBlock", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "nitorGas", 1));
        }
        if (TwilightForest.isModLoaded()) {
            for (int i = 5; i <= 15; i++) {
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFBossSpawner", 1, i));
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFTowerTranslucent", 1, i));
            }
            API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFTrophy", 1));
            API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFUncraftingTable", 1, 0, missing));
        }

        if (WarpTheory.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(WarpTheory.ID, "blockVanish", 1));
        }

        if (AppliedEnergistics2.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockPaint", 1));
            setOverrideName(
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                    "UniversalStorageHousing");
            setOverrideName(
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0, missing),
                    "NeutroniumEnergyCell");
        }

        if (BartWorks.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedGTEnhancementcapsule", 1, 477));
            API.hideItem(
                    GT_ModHandler
                            .getModItem(BartWorks.ID, "gt.bwMetaGeneratedGTEnhancementcapsule", 1, 32767, missing));
            API.hideItem(
                    GT_ModHandler.getModItem(
                            BartWorks.ID,
                            "gt.bwMetaGeneratedGTEnhancementcapsuleMolten",
                            1,
                            32767,
                            missing));
            API.hideItem(GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedcapsuleMolten", 1, 32767, missing));
            API.hideItem(GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedcapsule", 1, 32767, missing));
        }

        if (Chisel.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Chisel.ID, "amber", 1));
            API.hideItem(GT_ModHandler.getModItem(Chisel.ID, "bloodBrick", 1));
        }
        if (PamsHarvestCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "ovenon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "churnon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "quernon", 1));
        }
        if (MalisisDoors.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(MalisisDoors.ID, "null", 1));
        }

        if (OpenSecurity.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.ID, "SecurityDoor", 1));
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.ID, "SecurityDoorPrivate", 1));
        }
        if (SleepingBags.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(SleepingBags.ID, "sleepingBagBlock", 1));
        }
        if (Forestry.isModLoaded()) {
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 2, missing), "Swarmer");
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 3, missing), "AlvearyFan");
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 4, missing), "AlvearyHeater");
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 5, missing), "AlvearyHygroregulator");
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 6, missing), "AlvearyStabiliser");
            setOverrideName(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1, 7, missing), "AlvearySieve");
        }
        if (BiomesOPlenty.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 9, missing));
            API.hideItem(GT_ModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 8, missing));
            API.hideItem(GT_ModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 5, missing));
            API.hideItem(GT_ModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 7, missing));
            API.hideItem(GT_ModHandler.getModItem(BiomesOPlenty.ID, "misc", 1, 6, missing));
        }
        if (BuildCraftTransport.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1, 0, missing),
                    "Wood-CoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler.getModItem(
                            BuildCraftTransport.ID,
                            "item.buildcraftPipe.pipeitemscobblestone",
                            1,
                            0,
                            missing),
                    "CobblestoneCoveredPipe");
            setOverrideName(
                    GT_ModHandler.getModItem(
                            BuildCraftTransport.ID,
                            "item.buildcraftPipe.pipepowercobblestone",
                            1,
                            0,
                            missing),
                    "CobblestoneCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsstone", 1, 0, missing),
                    "StoneCoveredPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                    "StoneCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler.getModItem(
                            BuildCraftTransport.ID,
                            "item.buildcraftPipe.pipeitemssandstone",
                            1,
                            0,
                            missing),
                    "SandstoneCoveredPipe");
            setOverrideName(
                    GT_ModHandler.getModItem(
                            BuildCraftTransport.ID,
                            "item.buildcraftPipe.pipepowersandstone",
                            1,
                            0,
                            missing),
                    "SandstoneCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsiron", 1, 0, missing),
                    "IronCoveredPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweriron", 1, 0, missing),
                    "IronCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsquartz", 1, 0, missing),
                    "QuartzCoveredPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerquartz", 1, 0, missing),
                    "QuartzCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                    "GoldCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                    "DiamondCoveredKinesisPipe");
            setOverrideName(
                    GT_ModHandler
                            .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweremerald", 1, 0, missing),
                    "EmeraldCoveredKinesisPipe");
        }
        if (BuildCraftSilicon.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(BuildCraftSilicon.ID, "redstoneCrystal", 1, 0, missing),
                    "FirestoneCrystal");
        }

        if (GalacticraftCore.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                    "CompressedMeteoricIronPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 6, missing),
                    "CompressedCopperPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 7, missing),
                    "CompressedTinPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8, missing),
                    "CompressedAluminiumPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing),
                    "CompressedSteelPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10, missing),
                    "CompressedBronzePlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1, 11, missing),
                    "CompressedIronPlate");
        }
        if (GalacticraftMars.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 6, missing),
                    "CompressedTitaniumPlate");
            setOverrideName(
                    GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                    "CompressedDeshPlate");
        }
        if (MagicBees.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(MagicBees.ID, "capsule.magic", 1, 32767, missing));
            API.hideItem(GT_ModHandler.getModItem(MagicBees.ID, "capsule.void", 1, 32767, missing));
        }

        if (ForbiddenMagic.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ForbiddenMagic.ID, "FMResource", 1, 1, missing));
        }

        if (Natura.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Natura.ID, "barleyFood", 1, 8, missing));
        }

        if (SGCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(SGCraft.ID, "sgControllerCrystal", 1, 0, missing));
        }

        if (BloodMagic.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(BloodMagic.ID, "Altar", 1, 0, missing),
                    "AltarOfGregoriusT'sBlood");
        }

        if (Railcraft.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(Railcraft.ID, "upgrade.lapotron", 1, 0, missing),
                    "LapatronLoaderUpgrade");
            setOverrideName(GT_ModHandler.getModItem(Railcraft.ID, "part.plate", 1, 4, missing), "LeadPlate");
        }

        if (StevesCarts2.isModLoaded()) {
            setOverrideName(GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 61, missing), "InfinityEngine");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "upgrade", 1, 14, missing),
                    "UpgradeIntegratedInfinityReactor");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 76, missing),
                    "QuantumMinecartHull");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing),
                    "GalgadorianMinecartHull");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing),
                    "ReinforcedMinecartHull");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing),
                    "StandardMinecartHull");
            setOverrideName(
                    GT_ModHandler.getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing),
                    "WoodenMinecartHull");
        }

        if (EnderIO.isModLoaded()) {
            ItemStack creativeBank = GT_ModHandler.getModItem(EnderIO.ID, "blockCapBank", 1, 0, missing);
            creativeBank.setTagInfo("type", new NBTTagString("CREATIVE"));
            creativeBank.setTagInfo("storedEnergyRF", new NBTTagInt(2500000));
            setOverrideName(creativeBank, "ChaoticCapacitorBank");
        }

        if (BiblioWoodsBoPEdition.isModLoaded()) {
            setOverrideName(
                    GT_ModHandler.getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodcase", 1, 4, missing),
                    "HellbarkCase");
        }

        setOverrideName(new ItemStack(Blocks.ender_chest), "PersonalEnderChest");

        MainRegistry.Logger.info("Added NEI Config");
    }

    private void hideFakeCircuits() {
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitLV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitLuV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitZPM", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUXV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitMAX", 1));
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
