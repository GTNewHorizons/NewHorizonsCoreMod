package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.CoreConfig;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.network.msg.ZZClientOnlySyncMessage;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import forestry.api.recipes.RecipeManagers;
import forestry.core.recipes.ShapedRecipeCustom;
import forestry.factory.recipes.CarpenterRecipe;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Mods;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTRecipe;

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
    ArrayList<GTRecipe> coins = new ArrayList<>();

    @Optional.Method(modid = Mods.ModIDs.FORESTRY)
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
                GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlank.get()).circuit(1)
                        .itemOutputs(NHItemList.CoinChunkloaderTierI.get())
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 3000)).duration(30 * SECONDS)
                        .eut(TierEU.RECIPE_MV).disabled().hidden().addTo(assemblerRecipes));
        coins.addAll(
                GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlank.get()).circuit(2)
                        .itemOutputs(NHItemList.CoinChunkloaderTierII.get())
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 6000)).duration(30 * SECONDS)
                        .eut(TierEU.RECIPE_HV).disabled().hidden().addTo(assemblerRecipes));
        coins.addAll(
                GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlank.get()).circuit(3)
                        .itemOutputs(NHItemList.CoinChunkloaderTierIII.get())
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 12000)).duration(30 * SECONDS)
                        .eut(TierEU.RECIPE_EV).disabled().hidden().addTo(assemblerRecipes));
        coins.addAll(
                GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlank.get()).circuit(4)
                        .itemOutputs(NHItemList.CoinChunkloaderTierIV.get())
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 24000)).duration(30 * SECONDS)
                        .eut(TierEU.RECIPE_IV).disabled().hidden().addTo(assemblerRecipes));
        coins.addAll(
                GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlank.get()).circuit(5)
                        .itemOutputs(NHItemList.CoinChunkloaderTierV.get())
                        .fluidInputs(FluidRegistry.getFluidStack("ender", 48000)).duration(30 * SECONDS)
                        .eut(TierEU.RECIPE_LuV).disabled().hidden().addTo(assemblerRecipes));

        if (MainRegistry.isServer() && CoreConfig.ForestryStampsAndChunkLoaderCoinsServerEnabled) {
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
        if (MainRegistry.isClient()) {
            // this runs on the server thread of a client
            // -> we are playing single player (TODO: Does this work correctly on LAN?)
            MainRegistry.dispatcher.sendTo(
                    new ZZClientOnlySyncMessage(CoreConfig.ForestryStampsAndChunkLoaderCoinsEnabled),
                    (EntityPlayerMP) pEvent.player);
        } else {
            MainRegistry.dispatcher.sendTo(
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
