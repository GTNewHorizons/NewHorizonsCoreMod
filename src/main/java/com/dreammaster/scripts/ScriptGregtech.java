package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.GregTechAPI.sBlockOres1;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MCFrames;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.StructureLib;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.benderRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import tconstruct.library.TConstructRegistry;
import tectech.thing.CustomItemList;
import vexatos.tgregworks.reference.PartTypes;
import vexatos.tgregworks.util.TGregUtils;

public class ScriptGregtech implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gregtech";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AdvancedSolarPanel.ID,
                AppliedEnergistics2.ID,
                Avaritia.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                DraconicEvolution.ID,
                IndustrialCraft2.ID,
                MCFrames.ID,
                Natura.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                ProjectRedExpansion.ID,
                ProjectRedTransmission.ID,
                SGCraft.ID,
                StructureLib.ID,
                SuperSolarPanels.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.ring, (int) (1L)),
                "craftingToolKnife",
                null,
                null,
                null,
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                null);
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1L)),
                "craftingToolMortar",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustSmall, (int) (1L)),
                "craftingToolMortar",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        List<ItemStack> meatItems = new ArrayList<>(OreDictionary.getOres("listAllmeatraw")).stream().filter(
                itemStack -> !ItemStack.areItemStacksEqual(
                        itemStack,
                        MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (1L))))
                .collect(Collectors.toList());
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (1L)),
                "craftingToolMortar",
                meatItems);
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (1L)),
                "craftingToolMortar",
                "listAllfishraw");
        List<ItemStack> cookedMeatItems = new ArrayList<>(OreDictionary.getOres("listAllmeatcooked")).stream().filter(
                itemStack -> !ItemStack.areItemStacksEqual(
                        itemStack,
                        MaterialLibAPI.getStack(Materials2Materials.MeatCooked, Materials2Shapes.dust, (int) (1L))))
                .collect(Collectors.toList());
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.MeatCooked, Materials2Shapes.dust, (int) (1L)),
                "craftingToolMortar",
                cookedMeatItems);
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.MeatCooked, Materials2Shapes.dust, (int) (1L)),
                "craftingToolMortar",
                "listAllfishcooked");
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.dust, (int) (2L)),
                "craftingToolMortar",
                "logWood");
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Brick, Materials2Shapes.dustSmall, (int) (1L)),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "brick", 1, 0));
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Plastic, Materials2Shapes.stickLong, (int) (1L)),
                "stickPlastic",
                "craftingToolHardHammer",
                "stickPlastic");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)),
                "cropBarley",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)),
                "cropWheat",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)),
                "cropRye",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)),
                "cropOats",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Salt, Materials2Shapes.dust, (int) (1L)),
                new ItemStack(sBlockOres1, 1, 817),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Salt, Materials2Shapes.dust, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, MU.materialOf(Materials2Materials.Salt), 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Salt, Materials2Shapes.dust, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, MU.materialOf(Materials2Materials.Salt), 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Salt, Materials2Shapes.dust, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, MU.materialOf(Materials2Materials.Salt), 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Salt, Materials2Shapes.dust, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, MU.materialOf(Materials2Materials.Salt), 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (1L)),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "clay_ball", 1, 0));
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetIron",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetGold",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetCopper",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetTin",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetSilver",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Lead, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetLead",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Zinc, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetZinc",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Nickel, Materials2Shapes.dustTiny, (int) (1L)),
                "nuggetNickel",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                ItemList.Casing_Motor.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel",
                ItemList.Electric_Motor_HV.get(1L),
                ItemList.Casing_SolidSteel.get(1L),
                ItemList.Electric_Motor_HV.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel");
        addShapelessRecipe(
                ItemList.Cover_SolarPanel.get(1L),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.solar_panel", 1, 0));
        // TODO: REMOVE BEFORE 2.10 RELEASE
        addShapelessRecipe(
                ItemList.Machine_ULV_SolarPanel.get(1L),
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3));
        addShapedRecipe(
                ItemList.Cover_SolarPanel.get(1L),
                "craftingToolCrowbar",
                ItemList.Machine_ULV_SolarPanel.get(1L),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.RedAlloy), 1L),
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0));
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Rubber, Materials2Shapes.stickLong, (int) (1)),
                "stickRubber",
                "craftingToolHardHammer",
                "stickRubber");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Apatite, Materials2Shapes.stickLong, (int) (1L)),
                "stickApatite",
                "craftingToolHardHammer",
                "stickApatite");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.stickLong, (int) (1L)),
                "stickLapis",
                "craftingToolHardHammer",
                "stickLapis");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.stickLong, (int) (1L)),
                "stickLazurite",
                "craftingToolHardHammer",
                "stickLazurite");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.stickLong, (int) (1L)),
                "stickSodalite",
                "craftingToolHardHammer",
                "stickSodalite");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.stickLong, (int) (1L)),
                "stickEnderPearl",
                "craftingToolHardHammer",
                "stickEnderPearl");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.stickLong, (int) (1L)),
                "stickEnderEye",
                "craftingToolHardHammer",
                "stickEnderEye");
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 2L),
                getModItem(MCFrames.ID, "mcframes.frame", 1, 0));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                getModItem(OpenBlocks.ID, "scaffolding", 1, 0));
        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustSmall, (int) (1L)),
                "craftingToolMortar",
                getModItem(BloodArsenal.ID, "glass_shard", 1, 0));
        addShapedRecipe(
                ItemList.Casing_Pump.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel",
                ItemList.Electric_Pump_HV.get(1L),
                ItemList.Casing_SolidSteel.get(1L),
                ItemList.Electric_Pump_HV.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.GraniteBlack, Materials2Shapes.gearGtSmall, (int) (1L)),
                "stoneGraniteBlack",
                null,
                null,
                null,
                "craftingToolFile",
                null);
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.GraniteRed, Materials2Shapes.gearGtSmall, (int) (1L)),
                "stoneGraniteRed",
                null,
                null,
                null,
                "craftingToolFile",
                null);
        addShapedRecipe(
                ItemList.Casing_Processor.get(1L),
                "itemCasingStainlessSteel",
                "circuitElite",
                "itemCasingStainlessSteel",
                "circuitElite",
                ItemList.Casing_SolidSteel.get(1L),
                "circuitElite",
                "itemCasingStainlessSteel",
                "circuitElite",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                null,
                null,
                "ingotObsidian",
                null,
                null,
                "ingotObsidian",
                null,
                null);
        addShapedRecipe(
                ItemList.WirelessHeadphones.get(1),
                GTOreDictUnificator.get(OrePrefixes.rod, MU.materialOf(Materials2Materials.Rubber), 1L),
                ItemList.Sensor_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.rod, MU.materialOf(Materials2Materials.Rubber), 1L),
                "circuitBasic",
                null,
                "circuitBasic",
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                null,
                getModItem(Minecraft.ID, "noteblock", 1, 0));
        addShapedRecipe(
                ItemList.BetterJukebox_LV.get(1),
                ItemList.Electric_Piston_LV.get(1),
                ItemList.Emitter_LV.get(1),
                ItemList.Electric_Motor_LV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                ItemList.Hull_LV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Tin), 1L),
                "circuitBasic",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Tin), 1L));
        addShapedRecipe(
                ItemList.BetterJukebox_MV.get(1),
                ItemList.Electric_Piston_MV.get(1),
                ItemList.Emitter_MV.get(1),
                ItemList.Electric_Motor_MV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                ItemList.Hull_MV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Copper), 1L),
                "circuitGood",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Copper), 1L));
        addShapedRecipe(
                ItemList.BetterJukebox_HV.get(1),
                ItemList.Electric_Piston_HV.get(1),
                ItemList.Emitter_HV.get(1),
                ItemList.Electric_Motor_HV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                ItemList.Hull_HV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Gold), 1L),
                "circuitAdvanced",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Gold), 1L));
        addShapedRecipe(
                ItemList.BetterJukebox_EV.get(1),
                ItemList.Electric_Piston_EV.get(1),
                ItemList.Emitter_EV.get(1),
                ItemList.Electric_Motor_EV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                ItemList.Hull_EV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Aluminium), 1L),
                "circuitData",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Aluminium), 1L));
        addShapedRecipe(
                ItemList.BetterJukebox_IV.get(1),
                ItemList.Electric_Piston_IV.get(1),
                ItemList.Emitter_IV.get(1),
                ItemList.Electric_Motor_IV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                ItemList.Hull_IV.get(1),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Tungsten), 1L),
                "circuitElite",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Tungsten), 1L));

        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockStones, 1, 2),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockStones, 1, 1),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockStones, 1, 5),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockStones, 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockConcretes, 1, 10),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockConcretes, 1, 9),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockConcretes, 1, 13),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockConcretes, 1, 11),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockStones, 1, 10),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockStones, 1, 9),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockStones, 1, 13),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockStones, 1, 11),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockGranites, 1, 2),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockGranites, 1, 1),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockGranites, 1, 5),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockGranites, 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockGranites, 1, 10),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockGranites, 1, 9),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                new ItemStack(GregTechAPI.sBlockGranites, 1, 13),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                new ItemStack(GregTechAPI.sBlockGranites, 1, 11),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(ItemList.Color_03.get(1L), null, null, null, "dyeBrown", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_07.get(1L), null, null, null, "dyeLightGray", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_11.get(1L), null, null, null, "dyeYellow", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_15.get(1L), null, null, null, "dyeWhite", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_04.get(1L), null, null, null, "dyeBlue", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_08.get(1L), null, null, null, "dyeGray", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_10.get(1L), null, null, null, "dyeLime", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_14.get(1L), null, null, null, "dyeOrange", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_01.get(1L), null, null, null, "dyeRed", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_05.get(1L), null, null, null, "dyePurple", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_09.get(1L), null, null, null, "dyePink", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_13.get(1L), null, null, null, "dyeMagenta", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_00.get(1L), null, null, null, "dyeBlack", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_02.get(1L), null, null, null, "dyeGreen", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_06.get(1L), null, null, null, "dyeCyan", null, null, null, null, null);
        addShapedRecipe(ItemList.Color_12.get(1L), null, null, null, "dyeLightBlue", null, null, null, null, null);
        addShapelessRecipe(
                getModItem(StructureLib.ID, "item.structurelib.constructableTrigger", 1, 0),
                "dyeBlue",
                "platePaper",
                "dyeBlue",
                "dyeWhite");
        addShapedRecipe(
                ItemList.PadBouncy.get(1L),
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                null,
                null,
                null);
        addShapedRecipe(
                ItemList.PadSticky.get(1L),
                ItemList.IC2_Resin.get(1L),
                ItemList.IC2_Resin.get(1L),
                ItemList.IC2_Resin.get(1L),
                ItemList.IC2_Resin.get(1L),
                ItemList.IC2_Resin.get(1L),
                ItemList.IC2_Resin.get(1L),
                null,
                null,
                null);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Spray_Color_Infinite.get(1L),
                "---RR----",
                "---PsR---",
                "---RRR---",
                "--rrrrr--",
                "--If-AI--",
                "--IF-AI--",
                "--IWCcI--",
                "--IbSEI--",
                "---III---",
                'I',
                TGregUtils.newItemStack(MU.materialOf(Materials2Materials.Iridium), PartTypes.LargePlate, 1),
                'R',
                TGregUtils.newItemStack(MU.materialOf(Materials2Materials.Tungsten), PartTypes.LargePlate, 1),
                'r',
                TGregUtils.newItemStack(MU.materialOf(Materials2Materials.Palladium), PartTypes.LargePlate, 1),
                'S',
                getModItem(Minecraft.ID, "sand", 1, 0),
                'C',
                getModItem(ThaumicBases.ID, "rainbowCactus", 1, 0),
                'E',
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0),
                'W',
                ItemList.AcceleratorIV.get(1L),
                'F',
                "fenceWood",
                'f',
                getModItem(OpenBlocks.ID, "fan", 1, 0),
                'c',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 36),
                'A',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300),
                's',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 57),
                'P',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 320),
                'b',
                ItemList.Battery_Buffer_3by3_IV.get(1L));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                NHItemList.SingularityComputationCore.get(),
                "eeebbbeee",
                "es-----se",
                "e-sgags-e",
                "b-gsdsg-b",
                "b-adcda-b",
                "b-gsdsg-b",
                "e-sgags-e",
                "es-----se",
                "eeebbbeee",
                'b',
                CustomItemList.Godforge_SingularityShieldingCasing.get(1),
                's',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47),
                'g',
                CustomItemList.StabilisationFieldGeneratorTier8.get(1),
                'a',
                CustomItemList.astralArrayFabricator.get(1),
                'd',
                getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1, 0),
                'c',
                getModItem(AppliedEnergistics2.ID, "tile.BlockSingularityCraftingStorage", 1, 0),
                'e',
                CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(1));

        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.RawRubber, Materials2Shapes.dust, (int) (2L)))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Empty.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                null,
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Plate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPlate.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Casing.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormCasing.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormGear.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Credit.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormCoinage.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bottle.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBottle.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ingot.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormIngot.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ball.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBall.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Block.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBlock.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Nugget.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormNuggets.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bun.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBuns.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bread.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBread.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Baguette.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBaguette.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Cylinder.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormCylinder.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Anvil.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormAnvil.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Name.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormName.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Arrow.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormArrowHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Gear_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormSmallGear.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rod.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormStick.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bolt.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBolt.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Round.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormRound.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Screw.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormScrew.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ring.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormRing.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rod_Long.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormStickLong.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Turbine_Blade.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormTurbineBlade.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rotor.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormRotor.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPipeTiny.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPipeSmall.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Medium.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPipeMedium.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Large.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPipeLarge.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Huge.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormPipeHuge.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_ToolHeadDrill.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormDrillHead.get(1),
                true,
                100);

        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Plate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapePlate.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Rod.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeRod.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Bolt.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeBolt.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Cell.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeCell.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Ring.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeRing.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Ingot.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeIngot.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Casing.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeCasing.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeTinyPipe.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeSmallPipe.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeNormalPipe.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Large.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeLargePipe.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeHugePipe.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Block.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeBlock.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Sword.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeSwordBlade.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pickaxe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapePickaxeHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Shovel.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeShovelHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Axe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeAxeHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Hoe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeHoeHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Hammer.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeHammerHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_File.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeFileHead.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Saw.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeSawBlade.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeGear.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Bottle.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeBottle.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Rotor.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeRotor.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Turbine_Blade.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeTurbineBlade.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Small_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeSmallGear.get(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_ToolHeadDrill.get(1),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeDrillHead.get(1),
                true,
                100);

        GTModHandler.addSmeltingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.MeatCooked, Materials2Shapes.dust, (int) (1L)));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Tin), 2L))
                .itemOutputs(ItemList.Transformer_MV_LV.get(1L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Copper), 2L))
                .itemOutputs(ItemList.Transformer_HV_MV.get(1L)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Gold), 2L))
                .itemOutputs(ItemList.Transformer_EV_HV.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6),
                        GTOreDictUnificator
                                .get(OrePrefixes.cableGt02, MU.materialOf(Materials2Materials.Aluminium), 2L))
                .itemOutputs(ItemList.Transformer_IV_EV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.plateDense, (int) (6L)),
                        ItemList.IC2_Plutonium.get(3))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_EV.get(2, missing),
                        Circuits.EV.get(2),
                        ItemList.Electric_Motor_EV.get(2, missing),
                        ItemList.Hull_EV.get(1, missing),
                        GTOreDictUnificator
                                .get(OrePrefixes.cableGt01, MU.materialOf(Materials2Materials.Aluminium), missing, 1L))
                .circuit(1).itemOutputs(ItemList.Machine_EV_Bender.get(1, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.nugget, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.nugget, (int) (27L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Bronze, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.nugget, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (3L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Bronze, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.nugget, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.ingot, (int) (3L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Bronze, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.nugget, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Bronze, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.nugget, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.ingot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Bronze, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 9, 0), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 1, 1), ItemList.Shape_Mold_Nugget.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 9, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1L)),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustSmall, (int) (4L)),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustTiny, (int) (9L)),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedAir, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedAir, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedAir, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedFire, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedFire, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.InfusedFire, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedWater, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedWater, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedWater, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEarth, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEarth, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEarth, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedOrder, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedOrder, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedOrder, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEntropy, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEntropy, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedEntropy, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.PotassiumHydroxideGT5U), 3))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Saltpeter, Materials2Shapes.dust, (int) (5L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.NitricAcid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5000)))
                .fluidOutputs(MU.materialOf(Materials2Materials.Water).getGas(16000)).duration(10).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 1))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toolRod", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 2))
                .itemOutputs(getModItem(TinkerConstruct.ID, "pickaxeHead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 3))
                .itemOutputs(getModItem(TinkerConstruct.ID, "shovelHead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 4))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hatchetHead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 5))
                .itemOutputs(getModItem(TinkerConstruct.ID, "swordBlade", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 6))
                .itemOutputs(getModItem(TinkerConstruct.ID, "wideGuard", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 7))
                .itemOutputs(getModItem(TinkerConstruct.ID, "handGuard", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 8))
                .itemOutputs(getModItem(TinkerConstruct.ID, "crossbar", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 9))
                .itemOutputs(getModItem(TinkerConstruct.ID, "binding", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 10))
                .itemOutputs(getModItem(TinkerConstruct.ID, "frypanHead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 11))
                .itemOutputs(getModItem(TinkerConstruct.ID, "signHead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 12))
                .itemOutputs(getModItem(TinkerConstruct.ID, "knifeBlade", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 13))
                .itemOutputs(getModItem(TinkerConstruct.ID, "chiselHead", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (3L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 14))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughRod", 1, 11))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (3L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 15))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughBinding", 1, 11))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 16))
                .itemOutputs(getModItem(TinkerConstruct.ID, "heavyPlate", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 17))
                .itemOutputs(getModItem(TinkerConstruct.ID, "broadAxeHead", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 18))
                .itemOutputs(getModItem(TinkerConstruct.ID, "scytheBlade", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 19))
                .itemOutputs(getModItem(TinkerConstruct.ID, "excavatorHead", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 20))
                .itemOutputs(getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (8L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 21))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hammerHead", 1, 11))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (3L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 22))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fullGuard", 1, 11))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).recipeCategory(RecipeCategories.ticPartExtruding)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 11)).duration(1 * MINUTES + 13 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "ShurikenPart", 1, 11)).duration(30 * SECONDS + 6 * TICKS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (4L)),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 1))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1, 11))
                .duration(4 * MINUTES + 2 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (5L)),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 2))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1, 11))
                .duration(5 * MINUTES + 3 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_MV)
                .recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 3))
                .itemOutputs(getModItem(TinkerConstruct.ID, "BowLimbPart", 1, 11)).duration(1 * MINUTES + 31 * SECONDS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 18), ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.plate, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 18)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.plate, (int) (1L)))
                .duration(20).eut(24).addTo(benderRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 9, 18)).circuit(9)
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.plateDense, MU.materialOf(Materials2Materials.Obsidian), 1))
                .duration(180).eut(TierEU.RECIPE_MV).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Plastic, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Plastic, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Rubber, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Rubber, Materials2Shapes.stickLong, (int) (1)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Apatite, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Apatite, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.stick, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.stickLong, (int) (1L)))
                .duration(20).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "flint", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dustTiny, (int) (2L)))
                .duration(1 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.gem, (int) (1L)))
                .duration(10).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.gemChipped, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustSmall, (int) (1L)))
                .duration(10).eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.plate, (int) (1L)),
                        ItemList.Shape_Mold_Credit.get(0L))
                .itemOutputs(NHItemList.CoinBlank.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 6))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockTaint", 1, 2))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (9L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "glass_shard", 2, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTModHandler.addSmeltingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ore, MU.materialOf(Materials2Materials.Magnetite), 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0));
        GTModHandler.addSmeltingRecipe(
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, MU.materialOf(Materials2Materials.Magnetite), 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0));
        GTModHandler.addSmeltingRecipe(
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, MU.materialOf(Materials2Materials.Magnetite), 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0));
        GTModHandler.addSmeltingRecipe(
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, MU.materialOf(Materials2Materials.Magnetite), 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0));
        GTModHandler.addSmeltingRecipe(
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, MU.materialOf(Materials2Materials.Magnetite), 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.ChaosLocator.get(1),
                "----a----",
                "---bbb---",
                "--bcdcb--",
                "abcefecba",
                "-bdfgfdb-",
                "-bcefecb-",
                "-bbcdcbb-",
                "-aabbbaa-",
                "a-------a",
                'a',
                MaterialLibAPI
                        .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.plateSuperdense, (int) (1)),
                'b',
                MaterialLibAPI
                        .getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.plateSuperdense, (int) (1)),
                'c',
                getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.plateDense, (int) (1)),
                'e',
                NHItemList.ChaoticDust.get(1),
                'f',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                'g',
                getModItem(DraconicEvolution.ID, "teleporterMKI", 1, 0));
    }
}
