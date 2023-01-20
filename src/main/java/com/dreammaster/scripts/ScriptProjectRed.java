package com.dreammaster.scripts;

import gregtech.api.util.GT_ModHandler;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.ItemStack;

public class ScriptProjectRed implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("ProjectRed");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("ProjRed|Core"));
    }

    @Override
    public void loadRecipes() {

        // Core
        final String core[] = new String[] {"ProjRed|Core", "projectred.core"};
        final ItemStack electrotineDust = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 56);
        final ItemStack circuitPlate = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 0);
        final ItemStack conductivePlate = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 1);
        final ItemStack wiredPlate = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 2);
        final ItemStack bundledPlate = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 3);
        final ItemStack anode = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 4);
        final ItemStack cathode = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 5);
        final ItemStack pointer = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 6);
        final ItemStack siliconChip = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 7);
        final ItemStack energisedSiliconChip = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 8);
        final ItemStack platformedPlate = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 9);
        final ItemStack siliconBoul = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 11);
        final ItemStack silicon = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 12);
        final ItemStack infusedSilicon = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 13);
        final ItemStack energisedSilicon = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 14);
        final ItemStack sandyCoalCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 41);
        final ItemStack redSiliconCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 42);
        final ItemStack glowingSiliconCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 43);
        final ItemStack redIronCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 40);
        final ItemStack motor = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 15);
        final ItemStack electrotineIronCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 57);
        final ItemStack electrotineSiliconCompound = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 58);
        final ItemStack electrotine = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 55);
        final ItemStack electroSilicon = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 59);
        final ItemStack whiteIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 19);
        final ItemStack orangeIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 20);
        final ItemStack magentaIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 21);
        final ItemStack lightBlueIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 22);
        final ItemStack yellowIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 23);
        final ItemStack limeIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 24);
        final ItemStack pinkIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 25);
        final ItemStack greyIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 26);
        final ItemStack lightGreyIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 27);
        final ItemStack cyanIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 28);
        final ItemStack purpleIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 29);
        final ItemStack blueIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 30);
        final ItemStack brownIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 31);
        final ItemStack greenIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 32);
        final ItemStack redIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 33);
        final ItemStack blackIlluminar = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 34);
        final ItemStack nullLogicRoutingChip = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 44);
        final ItemStack nullLogicUpgradeChip = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 45);
        final ItemStack lxUpgrade = GT_ModHandler.getModItem(core[0], core[1] + ".part", 1, 46);
        final List<ItemStack> removeCoreCrafting = Arrays.asList(
                electrotineDust,
                wiredPlate,
                bundledPlate,
                anode,
                pointer,
                siliconChip,
                energisedSiliconChip,
                platformedPlate,
                silicon,
                sandyCoalCompound,
                redSiliconCompound,
                glowingSiliconCompound,
                redIronCompound,
                motor,
                electrotineIronCompound,
                electrotineSiliconCompound,
                conductivePlate,
                whiteIlluminar,
                orangeIlluminar,
                magentaIlluminar,
                lightBlueIlluminar,
                yellowIlluminar,
                limeIlluminar,
                pinkIlluminar,
                greyIlluminar,
                lightGreyIlluminar,
                cyanIlluminar,
                purpleIlluminar,
                blueIlluminar,
                brownIlluminar,
                greenIlluminar,
                redIlluminar,
                blackIlluminar,
                nullLogicRoutingChip,
                nullLogicUpgradeChip,
                lxUpgrade);
        GT_ModHandler.bulkRemoveRecipeByOutput(removeCoreCrafting);
        GT_ModHandler.removeFurnaceSmeltingByOutput(circuitPlate);
        GT_ModHandler.removeFurnaceSmeltingByOutput(siliconBoul);
        GT_ModHandler.removeFurnaceSmeltingByOutput(infusedSilicon);
        GT_ModHandler.removeFurnaceSmeltingByOutput(energisedSilicon);
        GT_ModHandler.removeFurnaceSmelting(electrotine);
        GT_ModHandler.removeFurnaceSmeltingByOutput(electroSilicon);
        GT_ModHandler.removeFurnaceSmeltingByOutput(electrotineDust);

        // Exploration
        final String expl[] = new String[] {"ProjRed|Exploration", "projectred.exploration"};
        final ItemStack blockOfElectrotine = GT_ModHandler.getModItem(expl[0], expl[1] + ".stone", 1, 11);
        final ItemStack removeBackPacks = GT_ModHandler.getModItem(expl[0], expl[1] + ".backpack", 1, wildcard);
        final ItemStack itemBarrel = GT_ModHandler.getModItem(expl[0], expl[1] + ".barrel", 1);
        final ItemStack goldSaw = GT_ModHandler.getModItem(expl[0], expl[1] + ".sawgold", 1);
        final ItemStack rubySaw = GT_ModHandler.getModItem(expl[0], expl[1] + ".sawruby", 1);
        final ItemStack sapphireSaw = GT_ModHandler.getModItem(expl[0], expl[1] + ".sawsapphire", 1);
        final ItemStack peridotSaw = GT_ModHandler.getModItem(expl[0], expl[1] + ".sawperidot", 1);
        final ItemStack rubyBoots = GT_ModHandler.getModItem(expl[0], expl[1] + ".rubyboots", 1);
        final ItemStack rubyChest = GT_ModHandler.getModItem(expl[0], expl[1] + ".rubychestplate", 1);
        final ItemStack rubyHelme = GT_ModHandler.getModItem(expl[0], expl[1] + ".rubyhelmet", 1);
        final ItemStack rubyLeggi = GT_ModHandler.getModItem(expl[0], expl[1] + ".rubyleggings", 1);
        final ItemStack sapphireBoots = GT_ModHandler.getModItem(expl[0], expl[1] + ".sapphireboots", 1);
        final ItemStack sapphireChestplate = GT_ModHandler.getModItem(expl[0], expl[1] + ".sapphirechestplate", 1);
        final ItemStack sapphireHelmet = GT_ModHandler.getModItem(expl[0], expl[1] + ".sapphirehelmet", 1);
        final ItemStack sapphireLeggings = GT_ModHandler.getModItem(expl[0], expl[1] + ".sapphireleggings", 1);
        final ItemStack peridotBoots = GT_ModHandler.getModItem(expl[0], expl[1] + ".peridotboots", 1);
        final ItemStack peridotChestplate = GT_ModHandler.getModItem(expl[0], expl[1] + ".peridotchestplate", 1);
        final ItemStack peridotHelmet = GT_ModHandler.getModItem(expl[0], expl[1] + ".peridothelmet", 1);
        final ItemStack peridotLeggings = GT_ModHandler.getModItem(expl[0], expl[1] + ".peridotleggings", 1);
        final List<ItemStack> removeExplorationCrafting = Arrays.asList(blockOfElectrotine);
        GT_ModHandler.bulkRemoveRecipeByOutput(removeExplorationCrafting);

        // Expansion
        final String expan[] = new String[] {"ProjRed|Expansion", "projectred.expansion"};
        final ItemStack inductiveFurnace = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine1", 1, 0);
        final ItemStack electrotineGenerator = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine1", 1, 1);
        final ItemStack blockBreaker = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 0);
        final ItemStack itemImporter = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 1);
        final ItemStack blockPlacer = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 2);
        final ItemStack filteredImporter = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 3);
        final ItemStack fireStarter = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 4);
        final ItemStack batteryBox = GT_ModHandler.getModItem(expan[0], expan[1] + ".machine2", 1, 5);
        final ItemStack solarPanel = GT_ModHandler.getModItem(expan[0], expan[1] + ".solar_panel", 1, 0);
        final ItemStack battery = GT_ModHandler.getModItem(expan[0], expan[1] + ".battery", 1);
        final List<ItemStack> removeExpansionCrafting = Arrays.asList(inductiveFurnace);
        GT_ModHandler.bulkRemoveRecipeByOutput(removeExpansionCrafting);
        // Fabrication
        final String fabr[] = new String[] {"ProjRed|Fabrication", "projectred.fabrication"};

        // Illumination
        final String illu[] = new String[] {"ProjRed|Illumination", "projectred.illumination"};
        // Integration
        final String integ[] = new String[] {"ProjRed|Integration", "projrectred.integration"};

        // Transmission
        final String transm[] = new String[] {"ProjRed|Transmition", "projectred.transmition"};
        final ItemStack removeWires = GT_ModHandler.getModItem(transm[0], transm[1] + ".wire", 1, wildcard);

        // Transportation
        final String transp[] = new String[] {"ProjRed|Transportation", "projectred.transportation"};
    }
}
