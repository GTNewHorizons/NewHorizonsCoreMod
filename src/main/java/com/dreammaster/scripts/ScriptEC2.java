package com.dreammaster.scripts;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.GT_ModHandler.getModItem;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;

public class ScriptEC2 implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("EC2");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList("extracells", "Avaritia", "eternalsingularity"));
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
        //ME Digital Singularity
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(getModItem("extracells", "storage.physical.advanced.singularity", 1),
        "----a----",
        "---aba---",
        "--ecdce--",
        "-acdddca-",
        "abddfddba",
        "-acdddca-",
        "--ecdce--",
        "---aba---",
        "----a----",
        'a', "blockCosmicNeutronium",
        'b', getModItem("Avaritia", "Resource", 1, 5),
        'c', getModItem("gregtech", "gt.blockmachines", 1, 129),
        'd', getModItem("extracells", "storage.component", 1, 3),
        'e', "blockInfinity",
        'f', getModItem("eternalsingularity", "eternal_singularity", 1));

        //ME Quantum Storage
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(getModItem("extracells", "storage.physical.advanced.quantum", 1),
                "---------",
                "----a----",
                "---bdb---",
                "--bcdcb--",
                "-addedda-",
                "--bcdcb--",
                "---bdb---",
                "----a----",
                "---------",
                'a', "blockCosmicNeutronium",
                'b', "plateDenseNeutronium",
                'c', "circuitInfinite",
                'd', getModItem("extracells", "storage.component", 1, 3),
                'e', getModItem("extracells", "storage.casing", 1));
    }
}
