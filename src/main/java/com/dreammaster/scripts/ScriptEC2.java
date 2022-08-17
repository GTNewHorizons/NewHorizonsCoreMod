package com.dreammaster.scripts;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptEC2 implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("EC2");
        dependencies.clear();
        dependencies.add("extracells");
    }

    @Override
    public void loadRecipes() {
        final ItemStack GLASS_PANE = new ItemStack(Blocks.glass_pane, 1);

        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);

        final ItemStack EC2_ADVANCED_HOUSING = getModItem("extracells", "storage.casing", 1, 0);
        final ItemStack EC2_FLUID_HOUSING = getModItem("extracells", "storage.casing", 1, 1);

        // EC2 Housings
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[]{
                        GLASS_PANE,
                        CERTUS_PLATE,
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                        GT_Utility.getIntegratedCircuit(3)
                },
                GT_Values.NF,
                EC2_ADVANCED_HOUSING,
                100,
                16
        );

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[]{
                        GLASS_PANE,
                        CERTUS_PLATE,
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        GT_Utility.getIntegratedCircuit(3)
                },
                GT_Values.NF,
                EC2_FLUID_HOUSING,
                100,
                16
        );
    }
}
