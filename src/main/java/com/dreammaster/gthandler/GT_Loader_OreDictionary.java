package com.dreammaster.gthandler;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.scripts.IngredientFactory;
import com.ruling_0.materiallib.api.Material;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTOreDictUnificator;

public class GT_Loader_OreDictionary extends gregtech.loaders.preload.LoaderGTOreDictionary implements Runnable {

    // In a dev environment getModItem resolves items of absent mods to the shared missing-item placeholder
    // (see IngredientFactory.invalidItem). Registering that placeholder pollutes the oredict: every blockX
    // slot claimed by it feeds GT's block-processing recipe generator with the same input stack, and which
    // material association wins varies per boot, making the recipe census nondeterministic. Skip placeholder
    // registrations entirely; with all mods present (the shipped pack) these guards never trigger.
    private static void registerOre(Object name, ItemStack stack) {
        if (IngredientFactory.isMissingItem(stack)) return;
        GTOreDictUnificator.registerOre(name, stack);
    }

    private static void registerOre(OrePrefixes prefix, Material material, ItemStack stack) {
        if (IngredientFactory.isMissingItem(stack)) return;
        GTOreDictUnificator.registerOre(prefix, material, stack);
    }

    private static void registerOre(OrePrefixes prefix, String materialName, ItemStack stack) {
        if (IngredientFactory.isMissingItem(stack)) return;
        GTOreDictUnificator.registerOre(prefix.oreDictName(materialName), stack);
    }

    @Override
    public void run() {
        GTLog.out.println("Core-Mod: Register OreDict Entries of Non-GT-Items.");

        // Custom Stuff
        registerOre("ingotBloodInfusedIron", getModItem(BloodArsenal.ID, "blood_infused_iron", 1, 0));
        registerOre("blockBloodInfusedIron", getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0));

        registerOre(OrePrefixes.log, Materials.Wood, getModItem(BiomesOPlenty.ID, "logs4", 1, 3));
        registerOre("cropCarrot", getModItem(BiomesOPlenty.ID, "food", 1, 2));

        registerOre(OrePrefixes.compressed, Materials.Mytryl, NHItemList.MytrylCompressedPlate.get());
        registerOre(OrePrefixes.block, Materials.Mytryl, BlockList.Mytryl.get());
        registerOre("blockCallistoIce", BlockList.CallistoColdIce.get());
        registerOre(OrePrefixes.compressed, Materials.CallistoIce, NHItemList.CallistoIceCompressedPlate.get());
        registerOre("blockLedox", BlockList.Ledox.get());
        registerOre(OrePrefixes.compressed, Materials.Ledox, NHItemList.LedoxCompressedPlate.get());
        registerOre(OrePrefixes.stick, Materials.Stone, NHItemList.CobbleStoneRod.get());
        registerOre(OrePrefixes.plate, Materials.Stone, NHItemList.StonePlate.get());
        registerOre("stickSandstone", NHItemList.SandStoneRod.get());
        registerOre("lensReinforcedGlass", NHItemList.ReinforcedGlassLense.get());
        registerOre("plateReinforcedGlass", NHItemList.ReinforcedGlassPlate.get());
        registerOre("blockQuantium", BlockList.Quantinum.get());
        registerOre(OrePrefixes.compressed, Materials.Quantium, NHItemList.QuantinumCompressedPlate.get());
        registerOre(OrePrefixes.block, Materials.MysteriousCrystal, BlockList.MysteriousCrystalBlock.get());
        registerOre(
                OrePrefixes.compressed,
                Materials.MysteriousCrystal,
                NHItemList.MysteriousCrystalCompressedPlate.get());
        registerOre(OrePrefixes.block, Materials.BlackPlutonium, BlockList.BlackPlutonium.get());
        registerOre(OrePrefixes.dust, Materials.ChargedCertusQuartz, NHItemList.ChargedCertusQuartzDust.get(1));
        registerOre(OrePrefixes.plate, Materials.ChargedCertusQuartz, NHItemList.ChargedCertusQuartzPlate.get(1));
        registerOre(OrePrefixes.stick, Materials.ChargedCertusQuartz, NHItemList.ChargedCertusQuartzRod.get(1));
        registerOre(
                OrePrefixes.crystal,
                Materials.ChargedCertusQuartz,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        registerOre(
                OrePrefixes.gem,
                Materials.ChargedCertusQuartz,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        registerOre("dustCokeOvenBrick", NHItemList.CokeOvenBrickDust.get(1));
        registerOre("ingotCokeOvenBrick", NHItemList.CokeOvenBrick.get(1));
        registerOre("leather", NHItemList.ArtificialLeather.get(1));
        registerOre("itemLeather", NHItemList.ArtificialLeather.get(1));

        registerOre(OrePrefixes.stickLong, Materials.Obsidian, NHItemList.LongObsidianRod.get());

        registerOre(OrePrefixes.bars, Materials.Aluminium, BlockList.AluminiumBars.get());
        registerOre(OrePrefixes.bars, Materials.Chrome, BlockList.ChromeBars.get());
        registerOre(OrePrefixes.bars, Materials.Iridium, BlockList.IridiumBars.get());
        registerOre(OrePrefixes.bars, Materials.Neutronium, BlockList.NeutroniumBars.get());
        registerOre(OrePrefixes.bars, Materials.Osmium, BlockList.OsmiumBars.get());
        registerOre(OrePrefixes.bars, Materials.Soularium, getModItem(EnderIO.ID, "blockSoulariumBars", 1, 0));
        registerOre(OrePrefixes.bars, Materials.StainlessSteel, BlockList.StainlessSteelBars.get());
        registerOre(OrePrefixes.bars, Materials.Steel, BlockList.SteelBars.get());
        registerOre(OrePrefixes.bars, Materials.Titanium, BlockList.TitaniumBars.get());
        registerOre(OrePrefixes.bars, Materials.TungstenSteel, BlockList.TungstenSteelBars.get());

        registerOre(
                OrePrefixes.rawOre,
                Materials.MeteoricIron,
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1));
        registerOre(OrePrefixes.ore, Materials.Desh, getModItem(GalacticraftMars.ID, "tile.mars", 1, 2));
        registerOre(OrePrefixes.stick, Materials.Desh, getModItem(GalacticraftMars.ID, "item.null", 1, 1));
        registerOre(OrePrefixes.ore, Materials.Ilmenite, getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 4));
        registerOre(
                OrePrefixes.block,
                Materials.MeteoricIron,
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 12));

        registerOre(
                OrePrefixes.ingot,
                Materials.HeeEndium,
                getModItem(HardcoreEnderExpansion.ID, "endium_ingot", 1, 0));
        registerOre(
                OrePrefixes.block,
                Materials.HeeEndium,
                getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0));

        registerOre("oreAdamantium", getModItem(GalaxySpace.ID, "oberonblocks", 1, 3));
        registerOre("oreCobalt", getModItem(GalaxySpace.ID, "phobosblocks", 1, 4));

        registerOre(OrePrefixes.block, Materials.Lead, getModItem(GalaxySpace.ID, "metalsblock", 1, 0));
        registerOre(OrePrefixes.block, Materials.Adamantium, getModItem(GalaxySpace.ID, "metalsblock", 1, 1));
        registerOre(OrePrefixes.block, Materials.Cobalt, getModItem(GalaxySpace.ID, "metalsblock", 1, 2));
        registerOre(OrePrefixes.block, Materials.Magnesium, getModItem(GalaxySpace.ID, "metalsblock", 1, 3));
        registerOre(OrePrefixes.block, Materials.Mithril, getModItem(GalaxySpace.ID, "metalsblock", 1, 4));
        registerOre(OrePrefixes.block, Materials.Nickel, getModItem(GalaxySpace.ID, "metalsblock", 1, 5));
        registerOre(OrePrefixes.block, Materials.Oriharukon, getModItem(GalaxySpace.ID, "metalsblock", 1, 6));
        registerOre(OrePrefixes.block, Materials.Platinum, getModItem(GalaxySpace.ID, "metalsblock", 1, 7));
        registerOre(OrePrefixes.block, Materials.Tungsten, getModItem(GalaxySpace.ID, "metalsblock", 1, 8));
        registerOre(OrePrefixes.block, Materials.Copper, getModItem(GalaxySpace.ID, "metalsblock", 1, 9));

        registerOre("chestSteel", getModItem(IronChests.ID, "BlockIronChest", 1, 4));

        registerOre("craftingToolShears", new ItemStack(Items.shears, 1, 32767));

        registerOre("cropBarley", getModItem(Natura.ID, "barleyFood", 1, 0));

        registerOre("craftingToolShears", getModItem(ExtraUtilities.ID, "shears", 1, 32767));
        registerOre(OrePrefixes.block, Materials.Unstable, getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 5));

        registerOre("logWood", getModItem(ForbiddenMagic.ID, "TaintLog", 1, 32767));
        registerOre("plankWood", getModItem(ForbiddenMagic.ID, "TaintPlank", 1, 32767));

        registerOre("beeComb", getModItem(Gendustry.ID, "HoneyComb", 1));

        registerOre("itemBeeswax", getModItem(PamsHarvestCraft.ID, "beeswaxItem", 1, 0));
        registerOre("foodFlour", getModItem(PamsHarvestCraft.ID, "flourItem", 1, 0));
        registerOre("listAllmeatcooked", MaterialLibAPI.getStack(Materials.MeatCooked, Shapes.dust, (int) (1L)));
        registerOre("listAllporkcooked", MaterialLibAPI.getStack(Materials.MeatCooked, Shapes.dust, (int) (1L)));
        registerOre("listAllchickencooked", MaterialLibAPI.getStack(Materials.MeatCooked, Shapes.dust, (int) (1L)));
        registerOre("listAllbeefcooked", MaterialLibAPI.getStack(Materials.MeatCooked, Shapes.dust, (int) (1L)));
        registerOre("listAllmeatraw", MaterialLibAPI.getStack(Materials.MeatRaw, Shapes.dust, (int) (1L)));
        registerOre("listAllporkraw", MaterialLibAPI.getStack(Materials.MeatRaw, Shapes.dust, (int) (1L)));
        registerOre("listAllchickenraw", MaterialLibAPI.getStack(Materials.MeatRaw, Shapes.dust, (int) (1L)));
        registerOre("listAllbeefraw", MaterialLibAPI.getStack(Materials.MeatRaw, Shapes.dust, (int) (1L)));
        registerOre("foodSalt", MaterialLibAPI.getStack(Materials.Salt, Shapes.dust, (int) (1L)));
        registerOre(
                OrePrefixes.block,
                Materials.Salt,
                getModItem(PamsHarvestCraft.ID, "spamcompressedsaltBlockalt", 1, 0));

        registerOre(OrePrefixes.dust, Materials.Wheat, getModItem(PamsHarvestCraft.ID, "flourItem", 1, 0));

        registerOre("beeComp", getModItem(Computronics.ID, "computronics.partsForestry", 1, 0));

        registerOre("craftingToolShears", getModItem(Railcraft.ID, "tool.steel.shears", 1, 0));

        registerOre(OrePrefixes.block, Materials.Reinforced, getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0));
        registerOre(OrePrefixes.block, Materials.Galgadorian, getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 1));
        registerOre(
                OrePrefixes.block,
                Materials.EnhancedGalgadorian,
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 2));

        registerOre(OrePrefixes.nugget, Materials.Void, getModItem(Thaumcraft.ID, "ItemNugget", 1, 7));
        registerOre(OrePrefixes.block, Materials.Amber, getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 0));

        registerOre(OrePrefixes.ingot, Materials.Bedrockium, getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0));

        registerOre(OrePrefixes.block, Materials.Shadow, getModItem(TaintedMagic.ID, "BlockShadowmetal", 1, 0));
        registerOre(OrePrefixes.ingot, Materials.Shadow, getModItem(TaintedMagic.ID, "ItemMaterial", 1, 0));

        registerOre(OrePrefixes.ingot, Materials.Ichorium, getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 2));
        registerOre(OrePrefixes.nugget, Materials.Ichorium, getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 3));
        registerOre(OrePrefixes.paneGlass, getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        registerOre(OrePrefixes.ingot, "SearedBrick", getModItem(TinkerConstruct.ID, "materials", 1, 2));

        registerOre(OrePrefixes.ingot, "Firebrick", ItemList.Firebrick.get(1));

        registerOre("dyeLime", MaterialLibAPI.getStack(Materials.Soapstone, Shapes.dust, (int) (1L)));

        registerOre(OrePrefixes.log, Materials.Wood, getModItem(IndustrialCraft2.ID, "blockRubWood", 1, 0));

        // oreDict UMV - MAX circuits
        registerOre(OrePrefixes.circuit, "UMV", NHItemList.PikoCircuit.get());
        registerOre(OrePrefixes.circuit, "UXV", NHItemList.QuantumCircuit.get());
        registerOre(OrePrefixes.circuit, "MAX", NHItemList.PlanckCircuit.get());
        GTOreDictUnificator.addToBlacklist(NHItemList.PikoCircuit.get());
        GTOreDictUnificator.addToBlacklist(NHItemList.QuantumCircuit.get());
        GTOreDictUnificator.addToBlacklist(NHItemList.PlanckCircuit.get());

        // Add ore dictionary entries for sand and red sand to craft unfired coke oven bricks.
        registerOre("sand", new ItemStack(Blocks.sand, 1, 0));
        registerOre("sand", new ItemStack(Blocks.sand, 1, 1));
    }
}
