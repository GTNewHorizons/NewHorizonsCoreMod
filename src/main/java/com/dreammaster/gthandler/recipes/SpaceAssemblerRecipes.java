package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SuperSolarPanels;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.github.technus.tectech.thing.CustomItemList;
import com.gtnewhorizons.gtnhintergalactic.recipe.IG_RecipeAdder;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class SpaceAssemblerRecipes implements Runnable {

    @Override
    public void run() {
        if (GalaxySpace.isModLoaded()) {

            Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                    ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                    : FluidRegistry.getFluid("molten.solderingalloy");

            if (BartWorks.isModLoaded()) {
                // Optically Perfected CPU
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Chip_Optical.get(1L),
                                ItemList.Optical_Cpu_Containment_Housing.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.InfinityCatalyst, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Draconium, 4L),
                                CustomItemList.DATApipe.get(1L),
                                // Atomic Separation Catalyst screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 4L, 10022),
                                // Precious Metals Alloy screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 4L, 10109) },
                        new FluidStack[] { new FluidStack(solderUEV, 288) },
                        ItemList.Optically_Perfected_CPU.get(1L),
                        1,
                        20 * 20,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);
            }

            if (OpenComputers.isModLoaded() && SuperSolarPanels.isModLoaded()) {
                // Optically Compatible Memory
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 8L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 1L, 0) // Solar Light
                                                                                                      // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 288) },
                        ItemList.Optically_Compatible_Memory.get(2),
                        1,
                        20 * 20,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);

                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 16L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 4L, 0) // Solar Light
                                                                                                      // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 576) },
                        ItemList.Optically_Compatible_Memory.get(8),
                        2,
                        20 * 20,
                        (int) TierEU.RECIPE_UEV,
                        null,
                        null);

                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 16L, 39), // Memory tier
                                                                                                       // 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 32L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 16L, 0) // Solar Light
                                                                                                       // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 1152) },
                        ItemList.Optically_Compatible_Memory.get(32),
                        2,
                        20 * 20,
                        (int) TierEU.RECIPE_UIV,
                        null,
                        null);
            }
        }
    }
}
