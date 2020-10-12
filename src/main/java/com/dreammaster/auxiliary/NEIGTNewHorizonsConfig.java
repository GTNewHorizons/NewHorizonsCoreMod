package com.dreammaster.auxiliary;

import com.dreammaster.item.food.QuantumBread;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.item.ItemStack;

public class NEIGTNewHorizonsConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        API.hideItem(new ItemStack(QuantumBread.Instance()));
        API.hideItem(GT_ModHandler.getModItem("Aroma1997Core", "wrenched", 1));
        API.hideItem(GT_ModHandler.getModItem("BiblioCraft", "BiblioClipboard", 1));
        API.hideItem(GT_ModHandler.getModItem("EnderZoo", "enderZooIcon", 1));
        API.hideItem(GT_ModHandler.getModItem("ExtraTrees", "multifence", 1, 16387));
        API.hideItem(GT_ModHandler.getModItem("ForgeRelocation", "relocation.blockmovingrow", 1));
        API.hideItem(GT_ModHandler.getModItem("GraviSuite", "BlockRelocatorPortal", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "death_flower_pot", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "corrupted_energy_high", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "biome_core", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "corrupted_energy_low", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "enhanced_brewing_stand_block", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "temple_end_portal", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "laser_beam", 1));
        API.hideItem(GT_ModHandler.getModItem("HardcoreEnderExpansion", "item_special_effects", 1));
        API.hideItem(GT_ModHandler.getModItem("Mantle", "mantleBook", 1));
        API.hideItem(GT_ModHandler.getModItem("Thaumcraft", "blockWarded", 1));
        API.hideItem(GT_ModHandler.getModItem("Thaumcraft", "blockEldritchNothing", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "vatInterior", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "evanescent", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "portalTH", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "syringeInjection", 1, 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "syringeInjection", 1, 15));
        API.hideItem(GT_ModHandler.getModItem("ThaumicHorizons", "dummyVat", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicMachina", "metaphysicalBrick", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicMachina", "metaphysicalRose", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicMachina", "wandCore", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicTinkerer", "gaseousLight", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicTinkerer", "gaseousShadow", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicTinkerer", "infusedGrainBlock", 1));
        API.hideItem(GT_ModHandler.getModItem("ThaumicTinkerer", "nitorGas", 1));
        for(int i = 5; i <= 15; i++) {
        	API.hideItem(GT_ModHandler.getModItem("TwilightForest", "tile.TFBossSpawner", 1, i));
        }
        for(int i = 8; i <= 15; i++) {
        	API.hideItem(GT_ModHandler.getModItem("TwilightForest", "tile.TFTowerTranslucent", 1, i));
        }
        API.hideItem(GT_ModHandler.getModItem("TwilightForest", "tile.TFTrophy", 1));
        API.hideItem(GT_ModHandler.getModItem("WarpTheory", "blockVanish", 1));
        API.hideItem(GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockPaint", 1));
        API.hideItem(GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedGTEnhancementcapsule", 1, 477));
        API.hideItem(GT_ModHandler.getModItem("chisel", "amber", 1));
        API.hideItem(GT_ModHandler.getModItem("chisel", "bloodBrick", 1));
        API.hideItem(GT_ModHandler.getModItem("harvestcraft", "ovenon", 1));
        API.hideItem(GT_ModHandler.getModItem("harvestcraft", "churnon", 1));
        API.hideItem(GT_ModHandler.getModItem("harvestcraft", "quernon", 1));
        API.hideItem(GT_ModHandler.getModItem("malisisdoors", "null", 1));
        API.hideItem(GT_ModHandler.getModItem("opensecurity", "SecurityDoor", 1));
        API.hideItem(GT_ModHandler.getModItem("opensecurity", "SecurityDoorPrivate", 1));
        API.hideItem(GT_ModHandler.getModItem("sleepingbag", "sleepingBagBlock", 1));
        // Hide metaID 0, as this is the generic item for trash bags
        MainRegistry.Logger.info("Added NEI Config");
    }

    @Override
    public String getName()
    {
        return "GTNewHorizons-NEIConfig";
    }

    @Override
    public String getVersion()
    {
        return Refstrings.VERSION;
    }

}
