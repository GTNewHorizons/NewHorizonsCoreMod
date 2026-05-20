package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.bloodmagic.BloodMagicHelper;
import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.thaumcraft.TCHelper;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptForbiddenMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forbidden Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                BloodMagic.ID,
                Botania.ID,
                EnderIO.ID,
                ForbiddenMagic.ID,
                IndustrialCraft2.ID,
                Thaumcraft.ID,
                ThaumicTinkerer.ID,
                TinkerConstruct.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(ForbiddenMagic.ID, "Crystalwell", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                "dyeBlack",
                getModItem(ForbiddenMagic.ID, "Crystalwell", 1, wildcard),
                "dyeBlack",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5));
        addShapelessRecipe(ItemList.Color_00.get(2L), getModItem(ForbiddenMagic.ID, "InkFlower", 1, 0));

        ChiselHelper.addGroup("blockNetherStar");
        ChiselHelper.registerOredict("blockNetherStar", "blockNetherStar");

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.emerald))
                .itemOutputs(getModItem(ForbiddenMagic.ID, "FMResource", 9, 0)).duration(1 * MINUTES).eut(5)
                .addTo(centrifugeRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ForbiddenMagic.ID, "InkFlower", 1, 0))
                .itemOutputs(ItemList.Color_00.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

        BloodMagicHelper.removeAltarRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 3));
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 3),
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 6),
                4,
                50000,
                20,
                20,
                false);

        // WANDS
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 12));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 9));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 0));

        TCHelper.clearPages("CAP_manasteel");
        TCHelper.clearPages("CAP_terrasteel");
        TCHelper.clearPages("CAP_elementium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_vinteum",
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 1),
                new AspectList().add(Aspect.AIR, 40).add(Aspect.EARTH, 40).add(Aspect.FIRE, 40).add(Aspect.WATER, 40)
                        .add(Aspect.ORDER, 40).add(Aspect.ENTROPY, 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                "foilVinteum",
                'c',
                "screwTitanium",
                'd',
                "foilVinteum",
                'e',
                "ringVinteum",
                'f',
                "foilVinteum",
                'g',
                "screwTitanium",
                'h',
                "foilVinteum",
                'i',
                "screwTitanium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_witchwood_staff",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 10),
                new AspectList().add(Aspect.AIR, 125).add(Aspect.EARTH, 125).add(Aspect.FIRE, 125)
                        .add(Aspect.WATER, 125).add(Aspect.ORDER, 125).add(Aspect.ENTROPY, 125),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        ThaumcraftApi.addCrucibleRecipe(
                "VINTEUM",
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Vinteum, 1L),
                "nuggetThaumium",
                new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.ORDER, 2).add(Aspect.CRYSTAL, 2));
        TCHelper.addInfusionCraftingRecipe(
                "ROD_witchwood",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 4),
                6,
                new AspectList().add(Aspect.TREE, 64).add(Aspect.MAGIC, 48).add(Aspect.PLANT, 32).add(Aspect.TOOL, 24)
                        .add(Aspect.VOID, 24),
                getModItem(Witchery.ID, "ingredient", 1, 82),
                OrePrefixes.gem.get(Materials.Vinteum),
                getModItem(Witchery.ID, "witchsapling", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 34),
                getModItem(Witchery.ID, "witchsapling", 1, 1),
                getModItem(Witchery.ID, "ingredient", 1, 36),
                getModItem(Witchery.ID, "witchsapling", 1, 2),
                OrePrefixes.gem.get(Materials.Vinteum),
                getModItem(Witchery.ID, "witchsapling", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 34),
                getModItem(Witchery.ID, "witchsapling", 1, 1),
                getModItem(Witchery.ID, "ingredient", 1, 36),
                getModItem(Witchery.ID, "witchsapling", 1, 2));
        new ResearchItem(
                "JOURNEY",
                "FORBIDDEN",
                new AspectList().add(Aspect.TRAVEL, 5).add(Aspect.MAGIC, 10).add(Aspect.TOOL, 3),
                -3,
                1,
                3,
                getModItem(BiomesOPlenty.ID, "food", 1, 7)).setPages(new ResearchPage("derp.research_page.JOURNEY"))
                        .setParents("SCHOOLS").setRound().setStub().setAutoUnlock().registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_infernal",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 1),
                7,
                new AspectList().add(DarkAspects.PRIDE, 16).add(Aspect.MAGIC, 16).add(DarkAspects.NETHER, 32)
                        .add(Aspect.FIRE, 48).add(Aspect.TOOL, 8),
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3),
                OrePrefixes.plate.get(Materials.Soularium),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                OrePrefixes.plate.get(Materials.Soularium));
        TCHelper.setResearchAspects(
                "ROD_infernal",
                new AspectList().add(DarkAspects.NETHER, 15).add(Aspect.FIRE, 12).add(Aspect.WATER, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.TOOL, 3));
        TCHelper.setResearchComplexity("ROD_infernal", 3);
        ThaumcraftApi.addWarpToResearch("ROD_infernal", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_blood",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 6),
                9,
                new AspectList().add(Aspect.WATER, 16).add(Aspect.MAGIC, 32).add(Aspect.LIFE, 24).add(Aspect.UNDEAD, 8)
                        .add(Aspect.ELDRITCH, 8),
                getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "sanctus", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "crystallos", 1, 0),
                getModItem(BloodMagic.ID, "crepitous", 1, 0));
        TCHelper.setResearchAspects(
                "ROD_blood",
                new AspectList().add(Aspect.LIFE, 15).add(Aspect.WATER, 12).add(Aspect.DARKNESS, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.WEAPON, 3));
        TCHelper.setResearchComplexity("ROD_blood", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_livingwood",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 8),
                9,
                new AspectList().add(Aspect.TREE, 32).add(Aspect.MAGIC, 16).add(Aspect.LIFE, 16).add(Aspect.SENSES, 8)
                        .add(Aspect.PLANT, 8),
                getModItem(Botania.ID, "livingwood", 1, 0), // livingwood log
                getModItem(Botania.ID, "manaResource", 1, 2), // mana diamond
                getModItem(Botania.ID, "rune", 1, 0), // water rune
                getModItem(Botania.ID, "rune", 1, 1), // fire rune
                getModItem(Botania.ID, "rune", 1, 2), // earth rune
                getModItem(Botania.ID, "rune", 1, 3), // air rune
                getModItem(Botania.ID, "rune", 1, 8)); // mana rune;
        new ResearchItem(
                "ROD_livingwood",
                "FORBIDDEN",
                new AspectList().add(Aspect.LIFE, 5).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.TREE, 5),
                -1,
                3,
                3,
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 7))
                        .setPages(new ResearchPage("derp.research_page.ROD_livingwood")).setConcealed()
                        .setParents("JOURNEY", "BLOODALTAR", "BALLOFMOSS", "ROD_greatwood").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_livingwood", 2);
        TCHelper.orphanResearch("ROD_dreamwood");
        TCHelper.removeResearch("ROD_dreamwood");
        InfusionRecipe ROD_dreamwood_recipe = TCHelper.addInfusionCraftingRecipe(
                "ROD_dreamwood",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 12),
                9,
                new AspectList().add(Aspect.TREE, 64).add(Aspect.MAGIC, 48).add(Aspect.AURA, 32).add(Aspect.LIFE, 24)
                        .add(Aspect.SENSES, 16).add(Aspect.PLANT, 8),
                getModItem(Botania.ID, "dreamwood", 1, 0), // dreamwood log
                getModItem(Botania.ID, "manaResource", 1, 9), // dragon stone
                getModItem(Botania.ID, "rune", 1, 0), // water rune
                getModItem(Botania.ID, "rune", 1, 1), // fire rune
                getModItem(Botania.ID, "rune", 1, 2), // earth rune
                getModItem(Botania.ID, "rune", 1, 3), // air rune
                getModItem(Botania.ID, "rune", 1, 8), // spring rune
                getModItem(Botania.ID, "rune", 1, 4), // summer rune
                getModItem(Botania.ID, "rune", 1, 5), // fall rune
                getModItem(Botania.ID, "rune", 1, 6), // winter rune
                getModItem(Botania.ID, "rune", 1, 7)); // mana rune
        new ResearchItem(
                "ROD_dreamwood",
                "FORBIDDEN",
                new AspectList().add(Aspect.AURA, 5).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.TREE, 5),
                1,
                4,
                3,
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 11))
                        .setPages(
                                new ResearchPage("derp.research_page.ROD_dreamwood"),
                                new ResearchPage(ROD_dreamwood_recipe))
                        .setConcealed().setParents("ROD_livingwood").registerResearchItem();
        TCHelper.setRecipeResearch(ROD_dreamwood_recipe, "ROD_dreamwood");
        TCHelper.orphanResearch("ROD_dreamwood_staff");
        TCHelper.removeResearch("ROD_dreamwood_staff");
        new ResearchItem(
                "ROD_dreamwood_staff",
                "FORBIDDEN",
                new AspectList().add(Aspect.AURA, 5).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.TREE, 5),
                3,
                4,
                3,
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 13)).registerResearchItem();
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 13));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_dreamwood_staff",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 13),
                new AspectList().add(Aspect.AIR, 125).add(Aspect.EARTH, 125).add(Aspect.FIRE, 125)
                        .add(Aspect.WATER, 125).add(Aspect.ORDER, 125).add(Aspect.ENTROPY, 125),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 11),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 11),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.addResearchPage("ROD_dreamwood_staff", new ResearchPage("derp.research_page.ROD_dreamwood_staff"));
        TCHelper.addResearchPrereq("ROD_dreamwood_staff", "ROD_dreamwood", false);
        TCHelper.addResearchPage(
                "ROD_dreamwood_staff",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 13))));
        ResearchCategories.getResearch("ROD_dreamwood_staff").setSpecial();
        ResearchCategories.getResearch("ROD_dreamwood_staff").setConcealed();
        TCHelper.addResearchPrereq("ROD_dreamwood_staff", "ROD_silverwood_staff", false);
        ThaumcraftApi.addWarpToResearch("ROD_dreamwood_staff", 3);
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 4));
        new ResearchItem(
                "CAP_manasteel",
                "FORBIDDEN",
                new AspectList().add(Aspect.METAL, 5).add(Aspect.MAGIC, 10).add(Aspect.GREED, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.AURA, 5),
                1,
                2,
                3,
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 3)).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CAP_manasteel",
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 4),
                6,
                new AspectList().add(Aspect.ENERGY, 40).add(Aspect.MAGIC, 24).add(Aspect.AURA, 24)
                        .add(Aspect.SENSES, 8),
                // gold cap, 6 manasteel, 6 salis mundus
                getModItem(Thaumcraft.ID, "WandCap", 1, 1), // gold cap
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14), // salis
                getModItem(Botania.ID, "manaResource", 1, 0), // manasteel
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Botania.ID, "manaResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Botania.ID, "manaResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Botania.ID, "manaResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Botania.ID, "manaResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Botania.ID, "manaResource", 1, 0));
        TCHelper.addResearchPage("CAP_manasteel", new ResearchPage("derp.research_page.CAP_manasteel"));
        TCHelper.addResearchPage(
                "CAP_manasteel",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 4))));
        ResearchCategories.getResearch("CAP_manasteel").setConcealed();
        TCHelper.addResearchPrereq("CAP_manasteel", "ROD_livingwood", false);
        TCHelper.addResearchPrereq("CAP_manasteel", "CAP_gold", false);
        TCHelper.addResearchPrereq("CAP_manasteel", "THAUMIUM", false);
        ThaumcraftApi.addWarpToResearch("CAP_manasteel", 2);
        new ResearchItem(
                "CAP_terrasteel",
                "FORBIDDEN",
                new AspectList().add(Aspect.EARTH, 5).add(Aspect.MAGIC, 10).add(DarkAspects.PRIDE, 3)
                        .add(Aspect.TOOL, 4).add(TCAspects.STRONTIO.getAspect(), 2).add(Aspect.CRYSTAL, 5),
                3,
                2,
                3,
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 2)).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CAP_terrasteel",
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 2),
                6,
                new AspectList().add(Aspect.MAGIC, 256).add(Aspect.ORDER, 64).add(Aspect.METAL, 64)
                        .add(DarkAspects.PRIDE, 20).add(TCAspects.STRONTIO.getAspect(), 10),
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 3),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.plate.get(Materials.Steeleaf),
                getModItem(Botania.ID, "manaResource", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Botania.ID, "manaResource", 1, 4),
                OrePrefixes.plate.get(Materials.Steeleaf),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.addResearchPage("CAP_terrasteel", new ResearchPage("derp.research_page.CAP_terrasteel"));
        TCHelper.addResearchPage(
                "CAP_terrasteel",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 2))));
        ResearchCategories.getResearch("CAP_terrasteel").setConcealed();
        TCHelper.addResearchPrereq("CAP_terrasteel", "CAP_manasteel", false);
        TCHelper.addResearchPrereq("CAP_terrasteel", "TRANSEMERALD", true);
        ThaumcraftApi.addWarpToResearch("CAP_terrasteel", 4);
        new ResearchItem(
                "CAP_elementium",
                "FORBIDDEN",
                new AspectList().add(Aspect.AURA, 5).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.MAN, 5),
                3,
                4,
                3,
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 5)).registerResearchItem();
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 6));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_elementium",
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 6),
                new AspectList().add(Aspect.EARTH, 40).add(Aspect.WATER, 40).add(Aspect.AIR, 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                "ingotElvenElementium",
                'c',
                "screwTungstenSteel",
                'd',
                "ingotElvenElementium",
                'e',
                "elvenPixieDust",
                'f',
                "ingotElvenElementium",
                'g',
                "screwTungstenSteel",
                'h',
                "ingotElvenElementium",
                'i',
                "screwTungstenSteel");
        TCHelper.addResearchPage("CAP_elementium", new ResearchPage("derp.research_page.CAP_elementium"));
        TCHelper.addResearchPrereq("CAP_elementium", "CAP_manasteel", false);
        TCHelper.addResearchPage(
                "CAP_elementium",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 6))));
        TCHelper.addResearchPage(
                "CAP_elementium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 5))));
        ResearchCategories.getResearch("CAP_elementium").setConcealed();
        new ResearchItem(
                "VINTEUM",
                "FORBIDDEN",
                new AspectList().add(Aspect.METAL, 5).add(Aspect.EXCHANGE, 10).add(Aspect.MAGIC, 3)
                        .add(Aspect.GREED, 2),
                -4,
                2,
                3,
                GTOreDictUnificator.get(OrePrefixes.gem, Materials.Vinteum, 1))
                        .setPages(
                                new ResearchPage("derp.research_page.VINTEUM"),
                                new ResearchPage(
                                        TCHelper.findCrucibleRecipe(
                                                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Vinteum, 1L))))
                        .setConcealed().setParents("JOURNEY", "THAUMIUM", "GT_ADVANCEDMETALLURGY")
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("VINTEUM", 1);
        new ResearchItem(
                "CAP_vinteum",
                "FORBIDDEN",
                new AspectList().add(Aspect.EXCHANGE, 5).add(Aspect.MAGIC, 10).add(Aspect.GREED, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.METAL, 5),
                -5,
                3,
                3,
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 1)).setPages(
                        new ResearchPage("derp.research_page.CAP_vinteum"),
                        new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 1))))
                        .setConcealed().setParents("VINTEUM", "CAP_thaumium").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("CAP_vinteum", 3);
        new ResearchItem(
                "ROD_witchwood",
                "FORBIDDEN",
                new AspectList().add(Aspect.LIFE, 5).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.TREE, 5),
                -4,
                0,
                3,
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 4)).setPages(
                        new ResearchPage("derp.research_page.ROD_witchwood"),
                        new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 4))))
                        .setConcealed().setParents("VINTEUM", "ANOINTINGPASTE", "OVEN").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_witchwood", 2);
        new ResearchItem(
                "ROD_witchwood_staff",
                "FORBIDDEN",
                new AspectList().add(Aspect.LIFE, 5).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 3).add(Aspect.TOOL, 4)
                        .add(Aspect.TREE, 5),
                -2,
                0,
                3,
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 10)).setPages(
                        new ResearchPage("derp.research_page.ROD_witchwood_staff"),
                        new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ForbiddenMagic.ID, "WandCores", 1, 10))))
                        .setSpecial().setConcealed().setParents("ROD_witchwood", "ROD_silverwood_staff")
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_witchwood_staff", 4);
        TCHelper.refreshResearchPages("CAP_manasteel");
        TCHelper.refreshResearchPages("CAP_terrasteel");
        TCHelper.refreshResearchPages("CAP_elementium");
        TCHelper.refreshResearchPages("ROD_livingwood");
        TCHelper.refreshResearchPages("ROD_dreamwood");
        TCHelper.refreshResearchPages("ROD_dreamwood_staff");
        TCHelper.refreshResearchPages("VINTEUM");
        TCHelper.refreshResearchPages("CAP_vinteum");
        TCHelper.refreshResearchPages("ROD_witchwood");
        TCHelper.refreshResearchPages("ROD_witchwood_staff");

        // END OF WANDS

        TCHelper.removeCrucibleRecipe(getModItem(ForbiddenMagic.ID, "FMResource", 4, 0));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "Crystalwell", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ForbiddenMagic.ID, "UmbralBush", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "RingNutrition", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "Bloodwell", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "BlinkFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "ArcaneCakeItem", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "DiabolistFork", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "SkullAxe", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "BloodRapier", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "WrathCage", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "MorphPickaxe", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "MorphAxe", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "MorphShovel", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "MorphSword", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "TaintShovel", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "TaintPickaxe", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ForbiddenMagic.ID, "TaintSapling", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "TaintBlock", 9, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "EldritchOrb", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ForbiddenMagic.ID, "Primewell", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ForbiddenMagic.ID, "SubCollar", 1, 0));
        TCHelper.clearPages("RIDINGCROP");
        TCHelper.addResearchPage("RIDINGCROP", new ResearchPage("forbidden.research_page.RIDINGCROP.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RIDINGCROP",
                getModItem(ForbiddenMagic.ID, "RidingCrop", 1, 0),
                new AspectList().add(Aspect.EARTH, 5).add(Aspect.FIRE, 5).add(Aspect.AIR, 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Backpack.ID, "boundLeather", 1, 0),
                'd',
                "screwIron",
                'e',
                "stickWood",
                'f',
                "screwIron",
                'g',
                "craftingToolScrewdriver",
                'h',
                "stickWood",
                'i',
                ToolDictNames.craftingToolSoftMallet.name());
        TCHelper.addResearchPage(
                "RIDINGCROP",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ForbiddenMagic.ID, "RidingCrop", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CRYSTALWELL",
                getModItem(ForbiddenMagic.ID, "Crystalwell", 1, 0),
                new AspectList().add(Aspect.WATER, 5).add(Aspect.ORDER, 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'd',
                "dyeBlack",
                'e',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, wildcard),
                'f',
                "dyeBlack",
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.setResearchAspects(
                "CRYSTALWELL",
                new AspectList().add(Aspect.MIND, 18).add(Aspect.CRYSTAL, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.SENSES, 9).add(Aspect.AIR, 6).add(Aspect.WATER, 3));
        TCHelper.setResearchComplexity("CRYSTALWELL", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "BLACKFLOWER",
                getModItem(ForbiddenMagic.ID, "UmbralBush", 1, 0),
                getModItem(Minecraft.ID, "double_plant", 1, 4),
                new AspectList().add(Aspect.DARKNESS, 16).add(Aspect.LIFE, 10));
        TCHelper.setResearchAspects(
                "BLACKFLOWER",
                new AspectList().add(Aspect.PLANT, 12).add(Aspect.DARKNESS, 9).add(Aspect.SENSES, 6)
                        .add(Aspect.LIFE, 3));
        TCHelper.setResearchComplexity("BLACKFLOWER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RINGFOOD",
                getModItem(ForbiddenMagic.ID, "RingNutrition", 1, 0),
                new AspectList().add(Aspect.WATER, 35).add(Aspect.AIR, 35).add(Aspect.FIRE, 35).add(Aspect.EARTH, 35)
                        .add(Aspect.ENTROPY, 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedWater",
                'b',
                "blockNetherStar",
                'c',
                "screwInfusedAir",
                'd',
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                'f',
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                'g',
                "screwInfusedEarth",
                'h',
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                'i',
                "screwInfusedFire");
        TCHelper.setResearchAspects(
                "RINGFOOD",
                new AspectList().add(Aspect.HUNGER, 15).add(Aspect.LIFE, 12).add(DarkAspects.GLUTTONY, 9)
                        .add(Aspect.GREED, 6).add(Aspect.MIND, 3));
        TCHelper.setResearchComplexity("RINGFOOD", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODWELL",
                getModItem(ForbiddenMagic.ID, "Bloodwell", 1, 0),
                new AspectList().add(Aspect.WATER, 25).add(Aspect.AIR, 25).add(Aspect.FIRE, 25).add(Aspect.EARTH, 25)
                        .add(Aspect.ENTROPY, 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedWater",
                'b',
                getModItem(BloodMagic.ID, "bucketLife", 1, 0),
                'c',
                "screwInfusedAir",
                'd',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                'g',
                "screwInfusedEarth",
                'h',
                getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0),
                'i',
                "screwInfusedFire");
        TCHelper.setResearchAspects(
                "BLOODWELL",
                new AspectList().add(Aspect.LIFE, 15).add(Aspect.MIND, 12).add(Aspect.SENSES, 9).add(Aspect.GREED, 6)
                        .add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("BLOODWELL", 3);
        TCHelper.addInfusionCraftingRecipe(
                "FOCUSBLINK",
                getModItem(ForbiddenMagic.ID, "BlinkFocus", 1, 0),
                8,
                new AspectList().add(DarkAspects.SLOTH, 16).add(DarkAspects.NETHER, 16).add(Aspect.TRAVEL, 32)
                        .add(Aspect.ENTROPY, 32).add(Aspect.ELDRITCH, 8).add(Aspect.MAGIC, 8),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 92),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5),
                ItemList.QuantumEye.get(1L),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5),
                ItemList.QuantumEye.get(1L),
                getModItem(Witchery.ID, "ingredient", 1, 92),
                ItemList.QuantumEye.get(1L),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5),
                ItemList.QuantumEye.get(1L),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7));
        TCHelper.setResearchAspects(
                "FOCUSBLINK",
                new AspectList().add(DarkAspects.SLOTH, 21).add(Aspect.TRAVEL, 18).add(Aspect.ENTROPY, 15)
                        .add(DarkAspects.NETHER, 12).add(Aspect.ELDRITCH, 9).add(Aspect.DARKNESS, 6)
                        .add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("FOCUSBLINK", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ARCANECAKE",
                getModItem(ForbiddenMagic.ID, "ArcaneCakeItem", 1, 0),
                6,
                new AspectList().add(Aspect.CRAFT, 32).add(Aspect.HUNGER, 32).add(DarkAspects.GLUTTONY, 16)
                        .add(Aspect.WATER, 64).add(Aspect.SLIME, 16).add(Aspect.MAGIC, 8),
                getModItem(Minecraft.ID, "cake", 1, 0),
                getModItem(ForbiddenMagic.ID, "StarBlock", 1, 0),
                getModItem(Minecraft.ID, "milk_bucket", 1, 0),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                getModItem(Minecraft.ID, "egg", 1, 0),
                getModItem(ForbiddenMagic.ID, "StarBlock", 1, 0),
                getModItem(Minecraft.ID, "egg", 1, 0),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                getModItem(Minecraft.ID, "milk_bucket", 1, 0));
        TCHelper.setResearchAspects(
                "ARCANECAKE",
                new AspectList().add(Aspect.MAGIC, 18).add(DarkAspects.GLUTTONY, 15).add(Aspect.HUNGER, 12)
                        .add(Aspect.CRAFT, 9).add(Aspect.SLIME, 6).add(Aspect.WATER, 3));
        TCHelper.setResearchComplexity("ARCANECAKE", 3);
        TCHelper.addInfusionCraftingRecipe(
                "FORK",
                getModItem(ForbiddenMagic.ID, "DiabolistFork", 1, 0),
                10,
                new AspectList().add(Aspect.WEAPON, 32).add(DarkAspects.NETHER, 24).add(Aspect.ENERGY, 16)
                        .add(Aspect.MECHANISM, 8),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0),
                OrePrefixes.stick.get(Materials.BloodInfusedIron),
                OrePrefixes.screw.get(Materials.InfusedFire),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                OrePrefixes.stick.get(Materials.BloodInfusedIron),
                OrePrefixes.screw.get(Materials.InfusedFire),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                OrePrefixes.stick.get(Materials.BloodInfusedIron),
                OrePrefixes.screw.get(Materials.InfusedFire),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        TCHelper.setResearchAspects(
                "FORK",
                new AspectList().add(Aspect.DARKNESS, 18).add(Aspect.MAGIC, 15).add(DarkAspects.NETHER, 12)
                        .add(Aspect.MECHANISM, 9).add(Aspect.TOOL, 6).add(Aspect.WEAPON, 3));
        TCHelper.setResearchComplexity("FORK", 3);
        ThaumcraftApi.addWarpToResearch("FORK", 2);
        TCHelper.addInfusionCraftingRecipe(
                "SKULLAXE",
                getModItem(ForbiddenMagic.ID, "SkullAxe", 1, 0),
                10,
                new AspectList().add(DarkAspects.NETHER, 32).add(DarkAspects.WRATH, 24).add(Aspect.WEAPON, 24)
                        .add(Aspect.ENERGY, 16).add(Aspect.DEATH, 8),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 4));
        TCHelper.setResearchAspects(
                "SKULLAXE",
                new AspectList().add(Aspect.MAGIC, 18).add(Aspect.TOOL, 15).add(Aspect.DEATH, 12)
                        .add(DarkAspects.WRATH, 9).add(Aspect.WEAPON, 6).add(DarkAspects.NETHER, 3));
        TCHelper.setResearchComplexity("SKULLAXE", 3);
        ThaumcraftApi.addWarpToResearch("SKULLAXE", 2);
        TCHelper.addInfusionCraftingRecipe(
                "BLOODRAPIER",
                getModItem(ForbiddenMagic.ID, "BloodRapier", 1, 0),
                10,
                new AspectList().add(Aspect.DARKNESS, 16).add(Aspect.LIFE, 24).add(Aspect.WEAPON, 16)
                        .add(Aspect.HUNGER, 32).add(DarkAspects.GLUTTONY, 8),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                getModItem(Minecraft.ID, "feather", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0));
        TCHelper.setResearchAspects(
                "BLOODRAPIER",
                new AspectList().add(Aspect.DARKNESS, 18).add(DarkAspects.GLUTTONY, 15).add(Aspect.LIFE, 12)
                        .add(Aspect.HUNGER, 9).add(Aspect.MAGIC, 6).add(Aspect.WEAPON, 3));
        TCHelper.setResearchComplexity("BLOODRAPIER", 3);
        ThaumcraftApi.addWarpToResearch("BLOODRAPIER", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "TRANSEMERALD",
                getModItem(ForbiddenMagic.ID, "FMResource", 4, 0),
                getModItem(ForbiddenMagic.ID, "FMResource", 1, 0),
                new AspectList().add(Aspect.GREED, 4).add(Aspect.CRYSTAL, 4));
        TCHelper.setResearchAspects(
                "TRANSEMERALD",
                new AspectList().add(Aspect.EXCHANGE, 15).add(Aspect.CRYSTAL, 12).add(Aspect.GREED, 9)
                        .add(Aspect.EARTH, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("TRANSEMERALD", 3);
        TCHelper.addInfusionCraftingRecipe(
                "WRATHCAGE",
                getModItem(ForbiddenMagic.ID, "WrathCage", 1, 0),
                15,
                new AspectList().add(DarkAspects.WRATH, 32).add(Aspect.MECHANISM, 32).add(Aspect.BEAST, 64)
                        .add(Aspect.METAL, 48).add(Aspect.ELDRITCH, 16).add(Aspect.UNDEAD, 16).add(Aspect.MAGIC, 32),
                getModItem(EnderIO.ID, "itemBrokenSpawner", 1, 0),
                OrePrefixes.block.get(Materials.Thaumium),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0),
                getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0),
                getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0),
                getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0),
                getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0));
        ThaumcraftApi.addCrucibleRecipe(
                "WRATHCAGE",
                getModItem(ForbiddenMagic.ID, "MobCrystal", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                new AspectList().add(Aspect.MIND, 10).add(Aspect.ENERGY, 10).add(Aspect.MAGIC, 10)
                        .add(Aspect.CRYSTAL, 10));
        TCHelper.setResearchAspects(
                "WRATHCAGE",
                new AspectList().add(DarkAspects.WRATH, 21).add(Aspect.MECHANISM, 18).add(Aspect.BEAST, 15)
                        .add(Aspect.METAL, 12).add(Aspect.MAGIC, 9).add(Aspect.ELDRITCH, 6).add(Aspect.UNDEAD, 3));
        TCHelper.setResearchComplexity("WRATHCAGE", 3);
        ThaumcraftApi.addWarpToResearch("WRATHCAGE", 5);
        TCHelper.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem(ForbiddenMagic.ID, "MorphPickaxe", 1, 0),
                10,
                new AspectList().add(DarkAspects.ENVY, 16).add(Aspect.TOOL, 16).add(Aspect.EXCHANGE, 32)
                        .add(Aspect.MIND, 8).add(Aspect.MAGIC, 48).add(Aspect.ENERGY, 8),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem(ForbiddenMagic.ID, "MorphAxe", 1, 0),
                10,
                new AspectList().add(DarkAspects.ENVY, 16).add(Aspect.TOOL, 16).add(Aspect.EXCHANGE, 32)
                        .add(Aspect.MIND, 8).add(Aspect.MAGIC, 48).add(Aspect.ENERGY, 8),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem(ForbiddenMagic.ID, "MorphShovel", 1, 0),
                10,
                new AspectList().add(DarkAspects.ENVY, 16).add(Aspect.TOOL, 16).add(Aspect.EXCHANGE, 32)
                        .add(Aspect.MIND, 8).add(Aspect.MAGIC, 48).add(Aspect.ENERGY, 8),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem(ForbiddenMagic.ID, "MorphSword", 1, 0),
                10,
                new AspectList().add(DarkAspects.ENVY, 16).add(Aspect.WEAPON, 16).add(Aspect.EXCHANGE, 32)
                        .add(Aspect.MIND, 8).add(Aspect.MAGIC, 48).add(Aspect.ENERGY, 8),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1));
        TCHelper.setResearchAspects(
                "MORPHTOOLS",
                new AspectList().add(DarkAspects.ENVY, 18).add(Aspect.TOOL, 15).add(Aspect.EXCHANGE, 12)
                        .add(Aspect.MIND, 9).add(Aspect.MAGIC, 6).add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("MORPHTOOLS", 3);
        ThaumcraftApi.addWarpToResearch("MORPHTOOLS", 5);
        TCHelper.addInfusionCraftingRecipe(
                "TAINTSHOVEL",
                getModItem(ForbiddenMagic.ID, "TaintShovel", 1, 0),
                10,
                new AspectList().add(Aspect.MINE, 16).add(Aspect.HEAL, 16).add(Aspect.CRYSTAL, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.SLIME, 8).add(Aspect.TOOL, 8),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Sapphire),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        TCHelper.setResearchAspects(
                "TAINTSHOVEL",
                new AspectList().add(Aspect.CRYSTAL, 21).add(Aspect.TAINT, 18).add(Aspect.TOOL, 15)
                        .add(Aspect.SLIME, 12).add(Aspect.MAGIC, 9).add(Aspect.POISON, 6).add(Aspect.EXCHANGE, 3));
        TCHelper.setResearchComplexity("TAINTSHOVEL", 3);
        TCHelper.addInfusionCraftingRecipe(
                "TAINTPICK",
                getModItem(ForbiddenMagic.ID, "TaintPickaxe", 1, 0),
                10,
                new AspectList().add(Aspect.MINE, 16).add(Aspect.TOOL, 8).add(Aspect.TAINT, 16).add(Aspect.ENTROPY, 32)
                        .add(Aspect.MAGIC, 32).add(Aspect.DEATH, 8),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                OrePrefixes.gemExquisite.get(Materials.Amethyst),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "TAINTPICK",
                new AspectList().add(Aspect.TAINT, 18).add(Aspect.ENTROPY, 15).add(Aspect.TOOL, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.DEATH, 6).add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("TAINTPICK", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "TAINTTREE",
                getModItem(ForbiddenMagic.ID, "TaintSapling", 1, 0),
                "treeSapling",
                new AspectList().add(Aspect.POISON, 8).add(Aspect.TAINT, 20));
        TCHelper.setResearchAspects(
                "TAINTTREE",
                new AspectList().add(Aspect.TAINT, 18).add(Aspect.TREE, 15).add(Aspect.PLANT, 12).add(Aspect.POISON, 9)
                        .add(Aspect.DEATH, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("TAINTTREE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TAINTSTONE",
                getModItem(ForbiddenMagic.ID, "TaintBlock", 9, 0),
                new AspectList().add(Aspect.ORDER, 9).add(Aspect.ENTROPY, 9),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'b',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'c',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'd',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'e',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                'f',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'g',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'h',
                getModItem(Minecraft.ID, "stone", 1, 0),
                'i',
                getModItem(Minecraft.ID, "stone", 1, 0));
        TCHelper.setResearchAspects(
                "TAINTSTONE",
                new AspectList().add(Aspect.MAGIC, 12).add(Aspect.TAINT, 9).add(Aspect.EARTH, 6).add(Aspect.ORDER, 3));
        TCHelper.setResearchComplexity("TAINTSTONE", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ELDRITCHORB",
                getModItem(ForbiddenMagic.ID, "EldritchOrb", 1, 0),
                15,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.DARKNESS, 32).add(Aspect.VOID, 64)
                        .add(Aspect.LIFE, 64).add(Aspect.MAGIC, 16).add(Aspect.CRYSTAL, 8),
                getModItem(BloodArsenal.ID, "transparent_orb", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.QuantumEye.get(1L),
                ItemList.Gravistar.get(1L),
                ItemList.QuantumEye.get(1L),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0));
        TCHelper.setResearchAspects(
                "ELDRITCHORB",
                new AspectList().add(Aspect.VOID, 18).add(Aspect.LIFE, 15).add(Aspect.ELDRITCH, 12)
                        .add(Aspect.CRYSTAL, 9).add(Aspect.DARKNESS, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("ELDRITCHORB", 3);
        ThaumcraftApi.addWarpToResearch("ELDRITCHORB", 6);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PRIMEWELL",
                getModItem(ForbiddenMagic.ID, "Primewell", 1, 0),
                new AspectList().add(Aspect.WATER, 100).add(Aspect.FIRE, 100).add(Aspect.AIR, 100)
                        .add(Aspect.EARTH, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedAir",
                'b',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                'c',
                "screwInfusedEarth",
                'd',
                "screwInfusedFire",
                'e',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'f',
                "screwInfusedOrder",
                'g',
                "screwInfusedWater",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwInfusedEntropy");
        TCHelper.setResearchAspects(
                "PRIMEWELL",
                new AspectList().add(Aspect.ELDRITCH, 18).add(Aspect.MIND, 15).add(Aspect.CRAFT, 12)
                        .add(Aspect.CRYSTAL, 9).add(Aspect.FLIGHT, 6).add(Aspect.ORDER, 3));
        TCHelper.setResearchComplexity("PRIMEWELL", 3);
        ThaumcraftApi.addWarpToResearch("PRIMEWELL", 1);
        TCHelper.addInfusionCraftingRecipe(
                "SUBCOLLAR",
                getModItem(ForbiddenMagic.ID, "SubCollar", 1, 0),
                10,
                new AspectList().add(Aspect.TRAP, 8).add(DarkAspects.NETHER, 8).add(Aspect.AURA, 16)
                        .add(Aspect.FLESH, 16).add(DarkAspects.LUST, 8).add(Aspect.MAGIC, 32),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                getModItem(Thaumcraft.ID, "ItemAmuletVis", 1, 1),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4),
                getModItem(Minecraft.ID, "lead", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4),
                getModItem(Minecraft.ID, "lead", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4),
                getModItem(Minecraft.ID, "lead", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4),
                getModItem(Minecraft.ID, "lead", 1, 0));
        TCHelper.setResearchAspects(
                "SUBCOLLAR",
                new AspectList().add(Aspect.TRAP, 18).add(Aspect.AURA, 15).add(Aspect.FLESH, 12)
                        .add(DarkAspects.LUST, 9).add(Aspect.MAGIC, 6).add(Aspect.MIND, 3));
        TCHelper.setResearchComplexity("SUBCOLLAR", 3);
        TCHelper.setResearchAspects(
                "HELLFIRE",
                new AspectList().add(DarkAspects.NETHER, 18).add(Aspect.FIRE, 15).add(Aspect.TRAVEL, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.ENERGY, 6).add(Aspect.LIGHT, 3));
        TCHelper.setResearchComplexity("HELLFIRE", 3);
        TCHelper.setResearchAspects(
                "CONSUMING",
                new AspectList().add(Aspect.VOID, 18).add(Aspect.MAGIC, 15).add(Aspect.ENTROPY, 12).add(Aspect.GREED, 9)
                        .add(DarkAspects.GLUTTONY, 6));
        TCHelper.setResearchComplexity("CONSUMING", 3);
        TCHelper.setResearchAspects(
                "EDUCATIONAL",
                new AspectList().add(Aspect.MIND, 15).add(Aspect.MAGIC, 12).add(Aspect.WEAPON, 9).add(Aspect.GREED, 6)
                        .add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("EDUCATIONAL", 3);
        TCHelper.setResearchAspects(
                "GREEDY",
                new AspectList().add(Aspect.GREED, 18).add(Aspect.MAGIC, 15).add(Aspect.WEAPON, 12)
                        .add(DarkAspects.NETHER, 9).add(DarkAspects.LUST, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("GREEDY", 3);
        TCHelper.setResearchAspects(
                "CORRUPTING",
                new AspectList().add(DarkAspects.NETHER, 18).add(Aspect.CRYSTAL, 15).add(Aspect.EXCHANGE, 12)
                        .add(Aspect.SOUL, 9).add(TCAspects.NEBRISUM.getAspect(), 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("CORRUPTING", 3);
        ThaumcraftApi.addWarpToResearch("CORRUPTING", 2);
        TCHelper.setResearchAspects(
                "WRATH",
                new AspectList().add(DarkAspects.WRATH, 18).add(Aspect.MAGIC, 15).add(Aspect.WEAPON, 12)
                        .add(DarkAspects.PRIDE, 9).add(Aspect.ENERGY, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("WRATH", 3);
        ThaumcraftApi.addWarpToResearch("WRATH", 3);
        TCHelper.setResearchAspects(
                "VOIDTOUCHED",
                new AspectList().add(DarkAspects.ENVY, 18).add(Aspect.ELDRITCH, 15).add(Aspect.TOOL, 12)
                        .add(Aspect.CRAFT, 9).add(Aspect.DARKNESS, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("VOIDTOUCHED", 3);
        ThaumcraftApi.addWarpToResearch("VOIDTOUCHED", 2);
        TCHelper.setResearchAspects(
                "IMPACT",
                new AspectList().add(Aspect.MINE, 18).add(Aspect.TOOL, 15).add(DarkAspects.ENVY, 12)
                        .add(Aspect.ENTROPY, 9).add(Aspect.GREED, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("IMPACT", 3);
        TCHelper.setResearchAspects(
                "CLUSTER",
                new AspectList().add(DarkAspects.ENVY, 18).add(Aspect.METAL, 15).add(DarkAspects.NETHER, 12)
                        .add(Aspect.ENERGY, 9).add(Aspect.GREED, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("CLUSTER", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_tainted",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 0),
                12,
                new AspectList().add(Aspect.TAINT, 32).add(Aspect.MAGIC, 16).add(Aspect.ENTROPY, 48)
                        .add(Aspect.POISON, 24).add(Aspect.ELDRITCH, 8).add(Aspect.DARKNESS, 32),
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12));
        TCHelper.setResearchAspects(
                "ROD_tainted",
                new AspectList().add(Aspect.TAINT, 18).add(Aspect.MAGIC, 15).add(Aspect.TOOL, 12).add(Aspect.ENTROPY, 9)
                        .add(Aspect.POISON, 6).add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("ROD_tainted", 3);
        ThaumcraftApi.addWarpToResearch("ROD_tainted", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_blood_staff",
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 9),
                new AspectList().add(Aspect.WATER, 40).add(Aspect.FIRE, 40).add(Aspect.AIR, 40).add(Aspect.EARTH, 40)
                        .add(Aspect.ENTROPY, 40).add(Aspect.ORDER, 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedOrder",
                'b',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6),
                'c',
                getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                'e',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 3),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                'g',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 3),
                'h',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7),
                'i',
                "screwInfusedEntropy");
        TCHelper.setResearchAspects(
                "ROD_blood_staff",
                new AspectList().add(Aspect.LIFE, 18).add(Aspect.WATER, 15).add(Aspect.WEAPON, 12).add(Aspect.EARTH, 9)
                        .add(Aspect.DARKNESS, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("ROD_blood_staff", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood_staff", 4);
        TCHelper.clearPages("CAP_alchemical");
        TCHelper.addResearchPage("CAP_alchemical", new ResearchPage("forbidden.research_page.CAP_alchemical.1"));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_alchemical",
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 0),
                6,
                new AspectList().add(Aspect.LIFE, 16).add(Aspect.WATER, 32).add(Aspect.MAGIC, 16)
                        .add(Aspect.EXCHANGE, 8).add(Aspect.METAL, 8),
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                OrePrefixes.dust.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "CAP_alchemical",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 0))));
        TCHelper.setResearchAspects(
                "CAP_alchemical",
                new AspectList().add(Aspect.LIFE, 15).add(Aspect.WATER, 12).add(Aspect.TOOL, 9).add(Aspect.METAL, 6)
                        .add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("CAP_alchemical", 3);
        ThaumcraftApi.addWarpToResearch("CAP_alchemical", 2);
        TCHelper.refreshResearchPages("RIDINGCROP");
        TCHelper.refreshResearchPages("CRYSTALWELL");
        TCHelper.refreshResearchPages("BLACKFLOWER");
        TCHelper.refreshResearchPages("RINGFOOD");
        TCHelper.refreshResearchPages("BLOODWELL");
        TCHelper.refreshResearchPages("FOCUSBLINK");
        TCHelper.refreshResearchPages("ARCANECAKE");
        TCHelper.refreshResearchPages("TRANSEMERALD");
        TCHelper.refreshResearchPages("FORK");
        TCHelper.refreshResearchPages("SKULLAXE");
        TCHelper.refreshResearchPages("BLOODRAPIER");
        TCHelper.refreshResearchPages("WRATHCAGE");
        TCHelper.refreshResearchPages("MORPHTOOLS");
        TCHelper.refreshResearchPages("TAINTSHOVEL");
        TCHelper.refreshResearchPages("TAINTPICK");
        TCHelper.refreshResearchPages("TAINTTREE");
        TCHelper.refreshResearchPages("TAINTSTONE");
        TCHelper.refreshResearchPages("ELDRITCHORB");
        TCHelper.refreshResearchPages("PRIMEWELL");
        TCHelper.refreshResearchPages("SUBCOLLAR");
        TCHelper.refreshResearchPages("ROD_infernal");
        TCHelper.refreshResearchPages("ROD_blood");
        TCHelper.refreshResearchPages("ROD_tainted");
        TCHelper.refreshResearchPages("ROD_blood_staff");
        TCHelper.refreshResearchPages("CAP_alchemical");
    }
}
