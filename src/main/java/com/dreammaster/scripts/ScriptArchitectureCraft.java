package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.ArchitectureCraft;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;

import java.util.Arrays;
import java.util.List;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.Mods;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

public class ScriptArchitectureCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Architecture Craft";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(ArchitectureCraft, TinkerConstruct);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(ArchitectureCraft.ID, "sawbench", 1),
                "screwSteel",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1),
                getModItem(ArchitectureCraft.ID, "sawblade", 1),
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1),
                "craftingToolScrewdriver",
                getModItem(ArchitectureCraft.ID, "largePulley", 1),
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(ArchitectureCraft.ID, "largePulley", 1),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "gearGtSmallAnyIron",
                "gearWood",
                "gearGtSmallAnyIron",
                "screwSteel",
                "craftingToolHardHammer",
                "screwSteel");

        addShapedRecipe(
                getModItem(ArchitectureCraft.ID, "hammer", 1),
                "plateSteel",
                "plateSteel",
                "ingotIron",
                "craftingToolFile",
                "stickWood",
                "ingotIron",
                null,
                "stickWood",
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(ArchitectureCraft.ID, "chisel", 1),
                "craftingToolHardHammer",
                "plateIron",
                "plateSteel",
                "screwIron",
                "stickIron",
                "plateIron",
                "stickWood",
                "screwIron",
                "craftingToolScrewdriver");

        addShapedRecipe(
                getModItem(ArchitectureCraft.ID, "glowbrush", 1),
                null,
                "materialCloth",
                "dustGlowstone",
                null,
                "gearWood",
                "materialCloth",
                "stickWood",
                null,
                null);

        addShapelessRecipe(getModItem(ArchitectureCraft.ID, "sawblade", 1), "toolHeadBuzzSawAnyIron");

        addShapelessRecipe(
                MaterialLibAPI.getStack(Materials.Iron, Shapes.toolHeadBuzzSaw, (int) (1L)),
                getModItem(ArchitectureCraft.ID, "sawblade", 1));
    }
}
