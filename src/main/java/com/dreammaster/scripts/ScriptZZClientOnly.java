package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.CoreConfig;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.network.msg.ZZClientOnlySyncMessage;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import forestry.api.recipes.RecipeManagers;
import forestry.core.recipes.ShapedRecipeCustom;
import forestry.factory.recipes.CarpenterRecipe;
import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

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
    Object[] stamps = null;
    ArrayList<GT_Recipe> coins = new ArrayList<>();

    @Optional.Method(modid = "Forestry")
    void stamps(boolean enabled) {
        if (stamps == null) {
            stamps = new CarpenterRecipe[] {

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
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'b',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'c',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'd',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'f',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'g',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'h',
                                    ItemList.Credit_Greg_Copper.get(1L),
                                    'i',
                                    ItemList.Credit_Greg_Copper.get(1L))),
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
                                    ItemList.Credit_Greg_Cupronickel.get(1L))),
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
                                    ItemList.Credit_Copper.get(1L),
                                    'b',
                                    ItemList.Credit_Copper.get(1L),
                                    'c',
                                    ItemList.Credit_Copper.get(1L),
                                    'd',
                                    ItemList.Credit_Copper.get(1L),
                                    'f',
                                    ItemList.Credit_Copper.get(1L),
                                    'g',
                                    ItemList.Credit_Copper.get(1L),
                                    'h',
                                    ItemList.Credit_Copper.get(1L),
                                    'i',
                                    ItemList.Credit_Copper.get(1L))),
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
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'h',
                                    ItemList.Credit_Greg_Cupronickel.get(1L))),
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
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'c',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'e',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'g',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'i',
                                    ItemList.Credit_Greg_Cupronickel.get(1L))),
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
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'e',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'f',
                                    ItemList.Credit_Greg_Cupronickel.get(1L))),
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
                                    ItemList.Credit_Silver.get(1L),
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
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'c',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'd',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'f',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'g',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'i',
                                    ItemList.Credit_Greg_Cupronickel.get(1L))),
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
                                    ItemList.Credit_Silver.get(1L),
                                    'f',
                                    ItemList.Credit_Silver.get(1L),
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
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'b',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'c',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'd',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'f',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'g',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'h',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'i',
                                    ItemList.Credit_Greg_Silver.get(1L))),
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
                                    ItemList.Credit_Silver.get(1L),
                                    'b',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'c',
                                    ItemList.Credit_Silver.get(1L),
                                    'd',
                                    ItemList.Credit_Silver.get(1L),
                                    'f',
                                    ItemList.Credit_Silver.get(1L),
                                    'g',
                                    ItemList.Credit_Silver.get(1L),
                                    'h',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'i',
                                    ItemList.Credit_Silver.get(1L))),
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
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'b',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'c',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'd',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'e',
                                    ItemList.Credit_Greg_Gold.get(1L),
                                    'f',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'g',
                                    ItemList.Credit_Greg_Silver.get(1L),
                                    'h',
                                    ItemList.Credit_Greg_Cupronickel.get(1L),
                                    'i',
                                    ItemList.Credit_Greg_Silver.get(1L))),
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
                                    ItemList.Credit_Silver.get(1L),
                                    'b',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'c',
                                    ItemList.Credit_Silver.get(1L),
                                    'd',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'e',
                                    ItemList.Credit_Gold.get(1L),
                                    'f',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'g',
                                    ItemList.Credit_Silver.get(1L),
                                    'h',
                                    getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                                    'i',
                                    ItemList.Credit_Silver.get(1L)))

            };
        }
        if (enabled)
            for (CarpenterRecipe stamp : (CarpenterRecipe[]) stamps) RecipeManagers.carpenterManager.addRecipe(stamp);
        else for (CarpenterRecipe stamp : (CarpenterRecipe[]) stamps)
            RecipeManagers.carpenterManager.removeRecipe(stamp);
    }

    @Override
    public void loadRecipes() {
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierI", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 3000)).noFluidOutputs().duration(600).eut(120)
                        .disabled().hidden().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierII", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 6000)).noFluidOutputs().duration(600).eut(480)
                        .disabled().hidden().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                GT_Utility.getIntegratedCircuit(3))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIII", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 12000)).noFluidOutputs().duration(600)
                        .eut(1920).disabled().hidden().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                GT_Utility.getIntegratedCircuit(4))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIV", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 24000)).noFluidOutputs().duration(600)
                        .eut(7680).disabled().hidden().addTo(sAssemblerRecipes));
        coins.addAll(
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                                GT_Utility.getIntegratedCircuit(5))
                        .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierV", 1, 0, missing))
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 48000)).noFluidOutputs().duration(600)
                        .eut(30720).disabled().hidden().addTo(sAssemblerRecipes));

        if (GT_Mod.gregtechproxy.isServerSide() && CoreConfig.ForestryStampsAndChunkLoaderCoinsServerEnabled) {
            stamps(true);
            coins.forEach(r -> {
                r.mEnabled = true;
                r.mHidden = false;
            });
            registered = true;
        }

        FMLCommonHandler.instance().bus().register(this);

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
            stamps(true);
            coins.forEach(r -> {
                r.mEnabled = true;
                r.mHidden = false;
            });
            registered = true;
        } else if (!enabled && registered) {
            stamps(false);
            coins.forEach(r -> {
                r.mEnabled = false;
                r.mHidden = true;
            });
            registered = false;
        }
    }
}
