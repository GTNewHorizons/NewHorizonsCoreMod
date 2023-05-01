package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.CoreConfig;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.network.msg.ZZClientOnlySyncMessage;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import forestry.api.recipes.RecipeManagers;
import forestry.core.recipes.ShapedRecipeCustom;
import forestry.factory.recipes.CarpenterRecipe;
import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Recipe;

public class ScriptZZClientOnly implements IScriptLoader {

    public static ScriptZZClientOnly instance = new ScriptZZClientOnly();

    @Override
    public String getScriptName() {
        return "ZZ Client Only";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Forestry.ID, IndustrialCraft2.ID);
    }

    private boolean initialized = false;
    private boolean registered = false;
    CarpenterRecipe[] stamps;
    ArrayList<GT_Recipe> coins = new ArrayList<>();

    @Override
    public void loadRecipes() {

        CarpenterRecipe[] stamps = new CarpenterRecipe[] {

                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'b',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'h',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                                "abc",
                                "def",
                                "ghi",
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'b',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'h',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                                "abc",
                                "def",
                                "ghi",
                                'e',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 1, missing),
                                "abc",
                                "def",
                                "ghi",
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'h',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 1, missing),
                                "abc",
                                "def",
                                "ghi",
                                'e',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'h',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 2, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 2, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'c',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'e',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'g',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'i',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 3, missing),
                                "abc",
                                "def",
                                "ghi",
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 3, missing),
                                "abc",
                                "def",
                                "ghi",
                                'd',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'f',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 4, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 4, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'c',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'g',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'i',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 5, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'b',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'h',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 5, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'b',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'h',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 6, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'b',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'd',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32003, missing),
                                'f',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                                'h',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing))),
                new CarpenterRecipe(
                        10,
                        FluidRegistry.getFluidStack("seedoil", 100),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        ShapedRecipeCustom.createShapedRecipe(
                                getModItem(Forestry.ID, "stamps", 1, 6, missing),
                                "abc",
                                "def",
                                "ghi",
                                'a',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'b',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'c',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'd',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'e',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32014, missing),
                                'f',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'g',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                                'h',
                                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                'i',
                                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing)))

        };

        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierI", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 3000)).noFluidOutputs().duration(600).eut(120)
                        .disabled().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierII", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 6000)).noFluidOutputs().duration(600).eut(480)
                        .disabled().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIII", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 12000)).noFluidOutputs().duration(600)
                        .eut(1920).disabled().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIV", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 24000)).noFluidOutputs().duration(600)
                        .eut(7680).disabled().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierV", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 48000)).noFluidOutputs().duration(600)
                        .eut(30720).disabled().addTo(sAssemblerRecipes));

        if (GT_Mod.gregtechproxy.isServerSide() && CoreConfig.ForestryStampsAndChunkLoaderCoinsServerEnabled) {
            for (CarpenterRecipe stamp : stamps) RecipeManagers.carpenterManager.addRecipe(stamp);
            coins.forEach(r -> r.mEnabled = true);
            registered = true;
        }

        MinecraftForge.EVENT_BUS.register(this);

        initialized = true;
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent pEvent) {
        if (pEvent.player instanceof EntityPlayerMP) {
            if (GT_Mod.gregtechproxy.isClientSide()) // We are on single player
                MainRegistry.NW.sendTo(
                        new ZZClientOnlySyncMessage(CoreConfig.ForestryStampsAndChunkLoaderCoinsEnabled),
                        (EntityPlayerMP) pEvent.player);
            else MainRegistry.NW.sendTo(
                    new ZZClientOnlySyncMessage(CoreConfig.ForestryStampsAndChunkLoaderCoinsServerEnabled),
                    (EntityPlayerMP) pEvent.player);
        }
    }

    public void handleServerMessage(boolean enabled) {
        if (!initialized) throw new RuntimeException("ZZClientOnly not initialized!");
        if (enabled && !registered) {
            for (CarpenterRecipe stamp : stamps) RecipeManagers.carpenterManager.addRecipe(stamp);
            coins.forEach(r -> r.mEnabled = true);
            registered = true;
        } else if (!enabled && registered) {
            for (CarpenterRecipe stamp : stamps) RecipeManagers.carpenterManager.removeRecipe(stamp);
            coins.forEach(r -> r.mEnabled = false);
            registered = false;
        }
    }
}
