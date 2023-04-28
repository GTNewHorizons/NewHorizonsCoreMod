package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptCompactKineticGenerators implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Compact Kinetic Generators";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("compactkineticgenerators");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("compactkineticgenerators", "IridiumBlade", 1, 0, missing),
                new Object[] { "plateAlloyIridium", "plateAlloyIridium", "plateAlloyIridium", "plateAlloyIridium",
                        "ringOsmium", "plateAlloyIridium", "plateAlloyIridium", "plateAlloyIridium",
                        "plateAlloyIridium" });
        addShapedRecipe(
                getModItem("compactkineticgenerators", "IridiumRotor", 1, 0, missing),
                new Object[] { getModItem("miscutils", "itemIridiumShaft", 1, 0, missing),
                        getModItem("compactkineticgenerators", "IridiumBlade", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("compactkineticgenerators", "IridiumBlade", 1, 0, missing), "ringChrome",
                        getModItem("compactkineticgenerators", "IridiumBlade", 1, 0, missing), "craftingToolWrench",
                        getModItem("compactkineticgenerators", "IridiumBlade", 1, 0, missing),
                        getModItem("miscutils", "itemIridiumShaft", 1, 0, missing) });

    }
}
