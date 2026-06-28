package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TecTech;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import kekztech.common.Blocks;
import kekztech.common.TileEntities;
import tectech.thing.CustomItemList;

public class ScriptSGCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Stargate Craft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                SGCraft.ID,
                BartWorks.ID,
                EnderIO.ID,
                GoodGenerator.ID,
                TecTech.ID,
                EternalSingularity.ID,
                AppliedEnergistics2.ID,
                OpenComputers.ID);
    }

    @Override
    public void loadRecipes() {

        // spotless:off

        ItemStack darkMatterBlock = getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14);
        ItemStack magmatterBlock = GTOreDictUnificator.get(OrePrefixes.block, Materials.MagMatter, 1L);
        ItemStack magmatterSuperdensePlate = GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 1L);
        ItemStack magmatterNanite = GTOreDictUnificator.get(OrePrefixes.nanite, Materials.MagMatter, 1L);
        ItemStack umvCap = new ItemStack(Blocks.lscLapotronicEnergyUnit, 1, 10);

        ItemStack ringBlock = getModItem(SGCraft.ID, "stargateRing", 1, 0);
        ItemStack chevronBlock = getModItem(SGCraft.ID, "stargateRing", 1, 1);
        ItemStack chevronUpgrade = getModItem(SGCraft.ID, "sgChevronUpgrade", 1, 0);
        ItemStack stargateCrystal = getModItem(SGCraft.ID, "sgCoreCrystal", 1, 0);
        ItemStack stargateControllerCrystal = getModItem(SGCraft.ID, "sgControllerCrystal", 1, 0);
        ItemStack stargateCapacitor = getModItem(SGCraft.ID, "ic2Capacitor", 1, 0);
        ItemStack stargateBase = getModItem(SGCraft.ID, "stargateBase", 1, 0);
        ItemStack irisBlade = getModItem(SGCraft.ID, "sgIrisBlade", 1, 0);
        ItemStack irisUpgrade = getModItem(SGCraft.ID, "sgIrisUpgrade", 1, 0);
        ItemStack rfUnit = getModItem(SGCraft.ID, "rfPowerUnit", 1, 0);
        ItemStack ocInterface = getModItem(SGCraft.ID, "ocInterface", 1, 0);
        ItemStack stargateController = getModItem(SGCraft.ID, "stargateController", 1, 0);

        ItemStack universeCell = getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Universe", 1, 0);
        ItemStack universeFluidCell = getModItem(AE2FluidCraft.ID, "fluid_storage.Universe", 1, 0);
        ItemStack singularityStorage = getModItem(AppliedEnergistics2.ID, "tile.BlockSingularityCraftingStorage", 1, 0);
        ItemStack chaoticCapacitor = createItemStack(EnderIO.ID, "blockCapBank", 1, 0, "{type:\"CREATIVE\",storedEnergyRF:2500000}");
        ItemStack keyboard = getModItem(OpenComputers.ID, "keyboard", 1, 0);
        ItemStack arithmeticSing = getModItem(EternalSingularity.ID, "combined_singularity", 1, 10);

        // Stargate Ring Block
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ringBlock,
                "aaafcffpp",
                "addfffpgg",
                "admfwpg--",
                "sdmffpg--",
                "sdmfcpg--",
                "sdmffpg--",
                "admfwpg--",
                "addfffpgg",
                "aaafcffpp",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'f', NHItemList.StargateFramePart.get(),
                'c', NHItemList.StargateChevron.get(),
                'p', NHItemList.StargateShieldingFoil.get(),
                'g', ItemList.Field_Generator_UXV.get(1L),
                'w', ItemList.MetaMaterial_Waveguide3.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1),
                's', ItemList.PrecisionFieldSyncCasing.get(1));

        // Stargate Chevron Upgrade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                chevronUpgrade,
                "mmmmmmmmm",
                "fpfsfpfm-",
                "mfcgcfmmm",
                "-mfwfefpf",
                "--mfcgcfm",
                "---mfwfm-",
                "----mfm--",
                "-----m---",
                "---------",
                'f', NHItemList.StargateFramePart.get(),
                'c', NHItemList.StargateChevron.get(),
                'p', ItemList.Electric_Piston_UXV.get(1L),
                'g', ItemList.Field_Generator_UXV.get(1L),
                's', ItemList.Sensor_UXV.get(1L),
                'e', ItemList.Emitter_UXV.get(1L),
                'w', ItemList.MetaMaterial_Waveguide3.get(1),
                'm', magmatterSuperdensePlate);

        // Stargate Chevron Block
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                chevronBlock,
                "---psp---",
                "--pamap--",
                "-pwdgdwp-",
                "padfufdap",
                "smgubugms",
                "padfufdap",
                "-pwdgdwp-",
                "--pamap--",
                "---psp---",
                'm', magmatterBlock,
                'd', darkMatterBlock,
                'u', chevronUpgrade,
                'b', ringBlock,
                'g', ItemList.Field_Generator_UXV.get(1L),
                'f', tectech.thing.CustomItemList.Godforge_GravitonFlowModulatorTier3.get(1L),
                'p', NHItemList.StargateShieldingFoil.get(),
                'w', ItemList.MetaMaterial_Waveguide3.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1),
                's', ItemList.PrecisionFieldSyncCasing.get(1));

        // Stargate Base
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateBase,
                "tppcdcppt",
                "pesmhmsep",
                "psimjmisp",
                "vkummmukv",
                "dkamomakd",
                "vkummmukv",
                "psimnmisp",
                "pesmhmsep",
                "tppcdcppt",
                'a', ItemList.SpaceElevatorModuleAssemblerT3.get(1),
                's', chevronBlock,
                'c', ItemList.MetaMaterial_EnergyConduit3.get(1),
                'd', magmatterNanite,
                'e', tectech.thing.CustomItemList.Godforge_GravitonFlowModulatorTier3.get(1L),
                'h', ItemList.MiningDroneUXV.get(1),
                'i', ItemList.ZPM6.get(1L),
                'j', universeCell,
                'k', tectech.thing.CustomItemList.astralArrayFabricator.get(1L),
                'm', ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                'n', universeFluidCell,
                'o', stargateCrystal,
                'p', NHItemList.StargateShieldingFoil.get(),
                't', ItemList.Transdimensional_Alignment_Matrix.get(1L),
                'u', ItemList.Universal_Collapser_ExoFoundry.get(1L),
                'v', ItemList.MetaMaterial_ElectrograviticValve3.get(1));

        // Ridiculously Large Capacitor
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateCapacitor,
                "---sms---",
                "---sms---",
                "-ppgpgpp-",
                "pcbcbcbcp",
                "pbcblbcbp",
                "pcbchcbcp",
                "-ppgpgpp-",
                "---sms---",
                "---sms---",
                'p', NHItemList.StargateShieldingFoil.get(),
                's', tectech.thing.CustomItemList.Godforge_StellarEnergySiphonCasing.get(1),
                'g', ItemList.Field_Generator_UXV.get(1L),
                'b', umvCap,
                'c', chaoticCapacitor,
                'l', TileEntities.lsc.getStackForm(1),
                'h', CustomItemList.eM_energyWirelessTunnel9_UXV.get(1),
                'm', ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1));

        // Stargate Iris Blade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                irisBlade,
                "-----wwww",
                "----wmbw-",
                "---wmbw--",
                "--wmbw---",
                "-wmmbw---",
                "wpmmbw---",
                "wpmmmbw--",
                "wuppmmbw-",
                "cwwwwwwww",
                'w', GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.WhiteDwarfMatter, 1L),
                'b', GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.BlackDwarfMatter, 1L),
                'm', magmatterSuperdensePlate,
                'p', ItemList.Electric_Piston_UXV.get(1L),
                'u', ItemList.ZPM6.get(1L),
                'c', ItemList.CondensateTransformativeCoil.get(1));

        // Stargate Iris Upgrade
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                irisUpgrade,
                "aabbbbbaa",
                "ab--n--ba",
                "b----n--b",
                "b-nndn--b",
                "bn-dmd-nb",
                "b--ndnn-b",
                "b--n----b",
                "ab--n--ba",
                "aabbbbbaa",
                'b', irisBlade,
                'd', darkMatterBlock,
                'n', magmatterNanite,
                'm', ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1));

        // RF Stargate Power Unit
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                rfUnit,
                "aacssscaa",
                "adcnnncda",
                "m-cnnnc-m",
                "m--cpc--m",
                "m-oprpo-m",
                "m--cpc--m",
                "ad--b--da",
                "agd---dga",
                "aaammmaaa",
                'd', darkMatterBlock,
                'c', ItemList.CondensateTransformativeCoil.get(1),
                'b', ItemList.ZPM6.get(1L),
                'p', stargateCapacitor,
                'r', ringBlock,
                'n', magmatterNanite,
                'g', ItemList.GigaChad.get(1L),
                'm', ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                's', ItemList.PrecisionFieldSyncCasing.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1),
                'o', ItemList.MetaMaterial_ResonanceChamber4.get(1));

        // OpenComputers Stargate Interface
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ocInterface,
                "aacssscaa",
                "adcnnncda",
                "m-cnnnc-m",
                "m--cpc--m",
                "m-oprpo-m",
                "m--cpc--m",
                "ad--b--da",
                "agd---dga",
                "aaammmaaa",
                'd', darkMatterBlock,
                'c', ItemList.CondensateTransformativeCoil.get(1),
                'b', tectech.thing.CustomItemList.dataIn_Wireless_Hatch.get(1L),
                'p', singularityStorage,
                'r', ringBlock,
                'n', magmatterNanite,
                'g', ItemList.GigaChad.get(1L),
                'm', ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                's', ItemList.PrecisionFieldSyncCasing.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1),
                'o', ItemList.MetaMaterial_EnergyConduit3.get(1));

        // Stargate Controller
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                stargateController,
                "---sss---",
                "--dkfkd--",
                "-skfcfks-",
                "-sfmzmfs-",
                "-skflfks-",
                "--dkfkd--",
                "--apbpa--",
                "--apopa--",
                "--apupa--",
                'd', darkMatterBlock,
                'k', keyboard,
                'f', NHItemList.StargateFramePart.get(),
                'c', stargateControllerCrystal,
                'p', NHItemList.StargateShieldingFoil.get(),
                'b', ItemList.ZPM6.get(1L),
                'o', ocInterface,
                'u', universeFluidCell,
                's', ItemList.PrecisionFieldSyncCasing.get(1),
                'a', ItemList.FieldEnergyAbsorberCasing.get(1),
                'l', ItemList.Field_Generator_UXV.get(1),
                'z', arithmeticSing,
                'm', ItemList.MetaMaterial_FieldManipulator4.get(1));


        // spotless:on
    }
}
