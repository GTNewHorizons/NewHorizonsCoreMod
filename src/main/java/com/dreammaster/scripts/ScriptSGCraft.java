package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;
import com.gtnewhorizons.gtnhintergalactic.item.IGItems;
import com.gtnewhorizons.gtnhintergalactic.item.ItemMiningDrones;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import goodgenerator.loader.Loaders;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptSGCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Stargate Craft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(SGCraft.ID, BartWorks.ID, EnderIO.ID, GoodGenerator.ID, TecTech.ID);
    }

    @Override
    public void loadRecipes() {

        // spotless:off

        ItemStack darkMatterBlock = getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14, missing);
        ItemStack magmatterBlock = GTOreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.MagMatter, 1L);
        ItemStack magmatterSuperdensePlate = GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsUEVplus.MagMatter, 1L);
        ItemStack magmatterNanite = GTOreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.MagMatter, 1L);
        ItemStack compact5Coil = new ItemStack(Loaders.compactFusionCoil, 1, 4);

        ItemStack ringBlock = getModItem(SGCraft.ID, "stargateRing", 1, 0, missing);
        ItemStack chevronBlock = getModItem(SGCraft.ID, "stargateRing", 1, 1, missing);
        ItemStack chevronUpgrade = getModItem(SGCraft.ID, "sgChevronUpgrade", 1, 0, missing);
        ItemStack stargateCrystal = getModItem(SGCraft.ID, "sgCoreCrystal", 1, 0, missing);
        ItemStack stargateControllerCrystal = getModItem(SGCraft.ID, "sgControllerCrystal", 1, 0, missing);
        ItemStack stargateCapacitor = getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing);
        ItemStack stargateBase = getModItem(SGCraft.ID, "stargateBase", 1, 0, missing);
        ItemStack irisBlade = getModItem(SGCraft.ID, "sgIrisBlade", 1, 0, missing);
        ItemStack irisUpgrade = getModItem(SGCraft.ID, "sgIrisUpgrade", 1, 0, missing);
        ItemStack rfUnit = getModItem(SGCraft.ID, "rfPowerUnit", 1, 0, missing);
        ItemStack ocInterface = getModItem(SGCraft.ID, "ocInterface", 1, 0, missing);
        ItemStack stargateController = getModItem(SGCraft.ID, "stargateController", 1, 0, missing);

        ItemStack universeCell = getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Universe", 1, 0, missing);
        ItemStack universeFluidCell = getModItem(AE2FluidCraft.ID, "fluid_storage.Universe", 1, 0, missing);
        ItemStack singularityStorage = getModItem(AppliedEnergistics2.ID, "tile.BlockSingularityCraftingStorage", 1, 0, missing);
        ItemStack chaoticCapacitor = createItemStack(EnderIO.ID, "blockCapBank", 1, 0, "{type:\"CREATIVE\",storedEnergyRF:2500000}", missing);
        ItemStack keyboard = getModItem(OpenComputers.ID, "keyboard", 1, 0, missing);

        // Stargate Ring Block
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ringBlock,
                "mmmfcffpp",
                "mmmfffpgg",
                "mmmffpg--",
                "dddffpg--",
                "dddfcpg--",
                "dddffpg--",
                "mmmffpg--",
                "mmmfffpgg",
                "mmmfcffpp",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'f', CustomItemList.StargateFramePart.get(1L),
                'c', CustomItemList.StargateChevron.get(1L),
                'p', CustomItemList.StargateShieldingFoil.get(1L),
                'g', ItemList.Field_Generator_UXV.get(1L));

        // Stargate Chevron Upgrade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                chevronUpgrade,
                "---------",
                "fpfgfpf--",
                "-fcpcf---",
                "--sgs----",
                "--fpfgfpf",
                "---fcpcf-",
                "----ege--",
                "-----f---",
                "---------",
                'f', CustomItemList.StargateFramePart.get(1L),
                'c', CustomItemList.StargateChevron.get(1L),
                'p', ItemList.Electric_Piston_UXV.get(1L),
                'g', ItemList.Field_Generator_UXV.get(1L),
                's', ItemList.Sensor_UXV.get(1L),
                'e', ItemList.Emitter_UXV.get(1L));

        // Stargate Chevron Block
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                chevronBlock,
                "----m----",
                "---mdm---",
                "--mdgdm--",
                "-mdfufdm-",
                "mdgusugdm",
                "-mdfufdm-",
                "--mdgdm--",
                "---mdm---",
                "----m----",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'u', chevronUpgrade,
                's', ringBlock,
                'g', ItemList.Field_Generator_UXV.get(1L),
                'f', tectech.thing.CustomItemList.Godforge_GravitonFlowModulatorTier3.get(1L));

        // Stargate Base
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateBase,
                "abbcdcbba",
                "befghgfeb",
                "beigjgieb",
                "cklmmmlkc",
                "dkpmompkd",
                "cklmmmlkc",
                "beigngieb",
                "befghgfeb",
                "abbcdcbba",
                'a', ItemList.Transdimensional_Alignment_Matrix.get(1L),
                'b', ItemList.Field_Generator_UXV.get(1L),
                'c', ItemList.Emitter_UXV.get(1L),
                'd', magmatterNanite,
                'e', tectech.thing.CustomItemList.Godforge_GravitonFlowModulatorTier3.get(1L),
                'f', magmatterSuperdensePlate,
                'g', CustomItemList.StargateShieldingFoil.get(1L),
                'h', new ItemStack(IGItems.MiningDrones, 1, ItemMiningDrones.DroneTiers.UXV.ordinal()),
                'i', ItemList.ZPM6.get(1L),
                'j', universeCell,
                'k', tectech.thing.CustomItemList.astralArrayFabricator.get(1L),
                'l', tectech.thing.CustomItemList.Machine_Multi_EyeOfHarmony.get(1L),
                'm', chevronBlock,
                'n', universeFluidCell,
                'o', stargateCrystal,
                'p', IGItems.SpaceElevatorModuleAssemblerT3);

        // Ridiculously Large Capacitor
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateCapacitor,
                "---------",
                "----e----",
                "--pgpgp--",
                "-pcscscp-",
                "-pbcbcbp-",
                "-pcscscp-",
                "--pgpgp--",
                "----e----",
                "---------",
                'p', CustomItemList.StargateShieldingFoil.get(1L),
                's', tectech.thing.CustomItemList.Godforge_StellarEnergySiphonCasing.get(1),
                'g', ItemList.Field_Generator_UXV.get(1L),
                'e', ItemList.Emitter_UXV.get(1L),
                'b', ItemList.ZPM6.get(1L),
                'c', chaoticCapacitor);

        // Stargate Iris Blade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                irisBlade,
                "-----wwww",
                "----wmmw-",
                "---wmmw--",
                "--wmmw---",
                "-wmmmw---",
                "wpmmmw---",
                "wpmmmmw--",
                "wbppmmmw-",
                "cwwwwwwww",
                'w', GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsUEVplus.WhiteDwarfMatter, 1L),
                'm', magmatterSuperdensePlate,
                'p', ItemList.Electric_Piston_UXV.get(1L),
                'b', ItemList.ZPM6.get(1L),
                'c', compact5Coil);

        // Stargate Iris Upgrade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                irisUpgrade,
                "ddbbbbbdd",
                "db--n--bd",
                "b----n--b",
                "b-nn-n--b",
                "bn--s--nb",
                "b--n-nn-b",
                "b--n----b",
                "db--n--bd",
                "ddbbbbbdd",
                'b', irisBlade,
                'd', darkMatterBlock,
                'n', magmatterNanite,
                's', magmatterSuperdensePlate);

        // RF Stargate Power Unit
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                rfUnit,
                "mmcdddcmm",
                "m-c---c-m",
                "m-c-b-c-m",
                "d--cpc--d",
                "d-bprpb-d",
                "d--cpc--d",
                "mnn-b-nnm",
                "mgn---ngm",
                "mmmdddmmm",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'c', compact5Coil,
                'b', ItemList.ZPM6.get(1L),
                'p', stargateCapacitor,
                'r', ringBlock,
                'n', magmatterNanite,
                'g', ItemList.GigaChad.get(1L));

        // OpenComputers Stargate Interface
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ocInterface,
                "mmcdddcmm",
                "m-c---c-m",
                "m-c-w-c-m",
                "d--csc--d",
                "d-wsrsw-d",
                "d--csc--d",
                "mnn-w-nnm",
                "mgn---ngm",
                "mmmdddmmm",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'c', compact5Coil,
                'w', tectech.thing.CustomItemList.dataIn_Wireless_Hatch.get(1L),
                's', singularityStorage,
                'r', ringBlock,
                'n', magmatterNanite,
                'g', ItemList.GigaChad.get(1L));

        // Stargate Controller
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateController,
                "---mmm---",
                "--dkfkd--",
                "-mkfsfkm-",
                "-mfecefm-",
                "-mkfsfkm-",
                "--dkfkd--",
                "--mpbpm--",
                "--mpopm--",
                "--mpupm--",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'k', keyboard,
                'f', CustomItemList.StargateFramePart.get(1L),
                's', ItemList.Sensor_UXV.get(1L),
                'e', ItemList.Emitter_UXV.get(1L),
                'c', stargateControllerCrystal,
                'p', CustomItemList.StargateShieldingFoil.get(1L),
                'b', ItemList.ZPM6.get(1L),
                'o', ocInterface,
                'u', universeFluidCell);

        // spotless:on
    }
}
