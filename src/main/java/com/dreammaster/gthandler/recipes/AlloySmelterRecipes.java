package com.dreammaster.gthandler.recipes;

import static com.dreammaster.gthandler.GT_MachineRecipeLoader.SECONDS;
import static com.dreammaster.gthandler.GT_MachineRecipeLoader.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class AlloySmelterRecipes implements Runnable {

    final String modIDEnderIO = "EnderIO";
    final String modIDTinkerConstruct = "TConstruct";

    @Override
    public void run() {
        registerCoreModRecipes();
        registerEnderIORecipes();
        registerTinkerConstructRecipes();

    }

    public void registerTinkerConstructRecipes() {
        if (!Loader.isModLoaded(modIDTinkerConstruct)) {
            return;
        }

        ItemStack x3_AluminiumDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L);
        ItemStack x1_CopperDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L);
        ItemStack x4_AluminiumBrassIngot = GT_ModHandler.getModItem(modIDTinkerConstruct, "materials", 4L, 14);

        GT_Values.RA.addAlloySmelterRecipe(
                x3_AluminiumDust,
                x1_CopperDust,
                x4_AluminiumBrassIngot,
                5 * SECONDS,
                (int) TierEU.RECIPE_MV);

    }

    public void registerCoreModRecipes() {
        ItemStack x4_MicaBasedSheet = CustomItemList.MicaBasedSheet.get(4L);
        ItemStack x1_SiliconDioxideDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L);
        ItemStack x4_MicaInsulatorSheet = CustomItemList.MicaInsulatorSheet.get(4L);
        ItemStack x1_RubyDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L);
        ItemStack x1_SapphireDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L);
        ItemStack x1_GreenSapphire = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L);
        ItemStack x1_NetherQuartzDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L);
        ItemStack x1_CertusQuartzDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L);
        ItemStack x2_AluminoSilicateWool = CustomItemList.AluminoSilicateWool.get(2L);
        ItemStack x2_QuartziteDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L);
        ItemStack x1_GlassDust = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1);
        ItemStack x1_GlassTube = ItemList.Circuit_Parts_Glass_Tube.get(1L);
        ItemStack x2_IridiumReinforcedPlate = GT_ModHandler.getModItem("IC2", "itemPartIridium", 2L);
        ItemStack x3_IridiumAlloyItemCasing = com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS()
                .splitStack(3);
        ItemStack x1_Clay = new ItemStack(Items.clay_ball);
        ItemStack x2_CokeOvenBrick = com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2);
        ItemStack x1_ObsidianBlock = new ItemStack(Blocks.obsidian, 1, 0);
        ItemStack x1_ObsidianIngot = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L);
        ItemStack shapeMoldIngot = ItemList.Shape_Mold_Ingot.get(0L);
        ItemStack shapeMoldBall = ItemList.Shape_Mold_Ball.get(0);

        GT_Values.RA.addAlloySmelterRecipe(
                x4_MicaBasedSheet,
                x1_SiliconDioxideDust,
                x4_MicaInsulatorSheet,
                20 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_RubyDust,
                x1_SiliconDioxideDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_SapphireDust,
                x1_SiliconDioxideDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_GreenSapphire,
                x1_SiliconDioxideDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x4_MicaBasedSheet,
                x1_NetherQuartzDust,
                x4_MicaInsulatorSheet,
                20 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_RubyDust,
                x1_NetherQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_SapphireDust,
                x1_NetherQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_GreenSapphire,
                x1_NetherQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x4_MicaBasedSheet,
                x1_CertusQuartzDust,
                x4_MicaInsulatorSheet,
                20 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_RubyDust,
                x1_CertusQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_SapphireDust,
                x1_CertusQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_GreenSapphire,
                x1_CertusQuartzDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x4_MicaBasedSheet,
                x2_QuartziteDust,
                x4_MicaInsulatorSheet,
                20 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_RubyDust,
                x2_QuartziteDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_SapphireDust,
                x2_QuartziteDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_GreenSapphire,
                x2_QuartziteDust,
                x2_AluminoSilicateWool,
                60 * SECONDS,
                (int) (TierEU.RECIPE_LV / 2));

        GT_Values.RA
                .addAlloySmelterRecipe(x1_GlassDust, shapeMoldBall, x1_GlassTube, 6 * SECONDS, (int) (TierEU.LV / 2));

        GT_Values.RA.addAlloySmelterRecipe(
                x2_IridiumReinforcedPlate,
                shapeMoldBall,
                x3_IridiumAlloyItemCasing,
                60 * SECONDS,
                (int) (TierEU.HV / 2));

        // in game this recipe (1 obsidian block -> 9 ingots) does not exist but there is a block giving 9 ingots.
        // Maybe it's overriden somewhere?
        GT_Values.RA
                .addAlloySmelterRecipe(x1_ObsidianBlock, shapeMoldIngot, x1_ObsidianIngot, 6 * SECONDS + 10 * TICKS, 3);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            ItemStack x1_SandOredict = OreDictionary.getOres("sand").get(i);

            GT_Values.RA
                    .addAlloySmelterRecipe(x1_SandOredict, x1_Clay, x2_CokeOvenBrick, 10 * SECONDS, (int) TierEU.ULV);
        }
    }

    public void registerEnderIORecipes() {
        if (!Loader.isModLoaded(modIDEnderIO)) {
            return;
        }

        ItemStack x1_CertusQuartzDust = Materials.CertusQuartz.getDust(1);
        ItemStack x2_CertusQuartzDust = Materials.CertusQuartz.getDust(2);
        ItemStack x1_GlassDust = Materials.Glass.getDust(1);
        ItemStack x3_GlassDust = Materials.Glass.getDust(3);
        ItemStack x1_FusedQuartzBlock = GT_ModHandler.getModItem(modIDEnderIO, "blockFusedQuartz", 1L);
        ItemStack x1_NetherQuartzDust = Materials.NetherQuartz.getDust(1);
        ItemStack x2_NetherQuartzDust = Materials.NetherQuartz.getDust(2);
        ItemStack x1_QuiteClearGlassBlock = GT_ModHandler.getModItem(modIDEnderIO, "blockFusedQuartz", 1L, 1);
        ItemStack x2_QuiteClearGlassBlock = GT_ModHandler.getModItem(modIDEnderIO, "blockFusedQuartz", 2L, 1);
        ItemStack x1_EnlightenedClearGlassBlock = GT_ModHandler.getModItem(modIDEnderIO, "blockFusedQuartz", 1L, 3);
        ItemStack x1_DarkClearGlass = GT_ModHandler.getModItem(modIDEnderIO, "blockFusedQuartz", 1L, 5);
        ItemStack x2_QuartziteDust = Materials.Quartzite.getDust(2);
        ItemStack x4_QuartziteDust = Materials.Quartzite.getDust(4);
        ItemStack x1_BorosilicateDust = Materials.BorosilicateGlass.getDust(1);
        ItemStack circuit_config_1 = GT_Utility.getIntegratedCircuit(1);
        ItemStack x4_GlowstoneDust = Materials.Glowstone.getDust(4);
        ItemStack x1_GlowstoneBlock = new ItemStack(Blocks.glowstone);

        // EnderIO Fused Quartz and Glass
        GT_Values.RA.addAlloySmelterRecipe(
                x2_CertusQuartzDust,
                x1_GlassDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x2_NetherQuartzDust,
                x1_GlassDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x2_CertusQuartzDust,
                x2_QuartziteDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x2_NetherQuartzDust,
                x2_QuartziteDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x1_CertusQuartzDust,
                x1_BorosilicateDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) (0.75 * TierEU.RECIPE_MV));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_NetherQuartzDust,
                x1_BorosilicateDust,
                x1_FusedQuartzBlock,
                25 * SECONDS,
                (int) (0.75 * TierEU.RECIPE_MV));

        GT_Values.RA.addAlloySmelterRecipe(
                x3_GlassDust,
                circuit_config_1,
                x1_QuiteClearGlassBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x4_QuartziteDust,
                circuit_config_1,
                x1_QuiteClearGlassBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x1_BorosilicateDust,
                circuit_config_1,
                x2_QuiteClearGlassBlock,
                25 * SECONDS,
                (int) (0.75 * TierEU.RECIPE_MV));

        GT_Values.RA.addAlloySmelterRecipe(
                x1_QuiteClearGlassBlock,
                x4_GlowstoneDust,
                x1_EnlightenedClearGlassBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addAlloySmelterRecipe(
                x1_QuiteClearGlassBlock,
                x1_GlowstoneBlock,
                x1_EnlightenedClearGlassBlock,
                25 * SECONDS,
                (int) TierEU.RECIPE_LV);

        for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {
            ItemStack x4_dyeBlackOredict = OreDictionary.getOres("dyeBlack").get(i).splitStack(4);

            GT_Values.RA.addAlloySmelterRecipe(
                    x1_QuiteClearGlassBlock,
                    x4_dyeBlackOredict,
                    x1_DarkClearGlass,
                    25 * SECONDS,
                    (int) TierEU.RECIPE_LV);
        }

    }
}
