package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import gregtech.api.enums.ItemList;
import net.minecraft.item.ItemStack;

public class ScriptAlveary implements IScriptLoader {

    public ScriptAlveary() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("Alveary");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList("Forestry", "gregtech", "gendustry", "ExtraBees"));
    }

    public static ItemStack Alveary_1 = getModItem("ExtraBees", "alveary", 1, 1);
    public static ItemStack Alveary_3 = getModItem("ExtraBees", "alveary", 1, 3);
    public static ItemStack Alveary_7 = getModItem("Forestry", "alveary", 1, 7);
    public static ItemStack Chipset_1 = getModItem("Forestry", "chipsets", 1, 1);

    @Override
    public void loadRecipes() {
        addShapedRecipe(ItemList.Machine_IndustrialApiary.get(1), new Object[] {
            Alveary_1,
            Chipset_1,
            Alveary_1,
            ItemList.Robot_Arm_HV.get(1),
            ItemList.FR_Casing_Sturdy.get(1),
            ItemList.Robot_Arm_HV.get(1),
            Alveary_3,
            Alveary_7,
            Alveary_3
        });
    }
}
