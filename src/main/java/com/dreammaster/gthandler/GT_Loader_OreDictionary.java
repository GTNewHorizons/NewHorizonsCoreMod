package com.dreammaster.gthandler;

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
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.ItemList;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class GT_Loader_OreDictionary extends gregtech.loaders.preload.LoaderGTOreDictionary implements Runnable {

    @Override
    public void run() {
        GTLog.out.println("Core-Mod: Register OreDict Entries of Non-GT-Items.");

        // Custom Stuff
        GTOreDictUnificator.registerOre(
                "ingotBloodInfusedIron",
                GTModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0));
        GTOreDictUnificator.registerOre(
                "blockBloodInfusedIron",
                GTModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.log,
                Materials.Wood,
                GTModHandler.getModItem(BiomesOPlenty.ID, "logs4", 1L, 3));
        GTOreDictUnificator.registerOre("cropCarrot", GTModHandler.getModItem(BiomesOPlenty.ID, "food", 1L, 2));

        GTOreDictUnificator
                .registerOre(OrePrefixes.compressed, Materials.Mytryl, ItemList.MytrylCompressedPlate.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.block, Materials.Mytryl, BlockList.Mytryl.getIS());
        GTOreDictUnificator.registerOre("blockCallistoIce", BlockList.CallistoColdIce.getIS());
        GTOreDictUnificator.registerOre(
                OrePrefixes.compressed,
                Materials.CallistoIce,
                ItemList.CallistoIceCompressedPlate.getIS());
        GTOreDictUnificator.registerOre("blockLedox", BlockList.Ledox.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.compressed, Materials.Ledox, ItemList.LedoxCompressedPlate.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.stick, Materials.Stone, ItemList.CobbleStoneRod.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.plate, Materials.Stone, ItemList.StonePlate.getIS());
        GTOreDictUnificator.registerOre("stickSandstone", ItemList.SandStoneRod.getIS());
        GTOreDictUnificator.registerOre("lensReinforcedGlass", ItemList.ReinforcedGlassLense.getIS());
        GTOreDictUnificator.registerOre("plateReinforcedGlass", ItemList.ReinforcedGlassPlate.getIS());
        GTOreDictUnificator.registerOre("blockQuantium", BlockList.Quantinum.getIS());
        GTOreDictUnificator
                .registerOre(OrePrefixes.compressed, Materials.Quantium, ItemList.QuantinumCompressedPlate.getIS());
        GTOreDictUnificator
                .registerOre(OrePrefixes.block, Materials.MysteriousCrystal, BlockList.MysteriousCrystal.getIS());
        GTOreDictUnificator.registerOre(
                OrePrefixes.compressed,
                Materials.MysteriousCrystal,
                ItemList.MysteriousCrystalCompressedPlate.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.block, Materials.BlackPlutonium, BlockList.BlackPlutonium.getIS());
        GTOreDictUnificator.registerOre(
                OrePrefixes.dust,
                Materials.CertusQuartzCharged,
                com.dreammaster.item.ItemList.ChargedCertusQuartzDust.getIS(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.plate,
                Materials.CertusQuartzCharged,
                com.dreammaster.item.ItemList.ChargedCertusQuartzPlate.getIS(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.stick,
                Materials.CertusQuartzCharged,
                com.dreammaster.item.ItemList.ChargedCertusQuartzRod.getIS(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.crystal,
                Materials.CertusQuartzCharged,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.gem,
                Materials.CertusQuartzCharged,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        GTOreDictUnificator.registerOre("dustCokeOvenBrick", com.dreammaster.item.ItemList.CokeOvenBrickDust.getIS(1));
        GTOreDictUnificator.registerOre("ingotCokeOvenBrick", com.dreammaster.item.ItemList.CokeOvenBrick.getIS(1));
        GTOreDictUnificator.registerOre("leather", com.dreammaster.item.ItemList.ArtificialLeather.getIS(1));
        GTOreDictUnificator.registerOre("itemLeather", com.dreammaster.item.ItemList.ArtificialLeather.getIS(1));
        GTOreDictUnificator
                .registerOre("dustPotassiumHydroxide", com.dreammaster.item.ItemList.PotassiumHydroxideDust.getIS(1));

        GTOreDictUnificator.registerOre(OrePrefixes.stickLong, Materials.Obsidian, ItemList.LongObsidianRod.getIS());

        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Aluminium, ItemList.AluminiumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Chrome, ItemList.ChromeBars.getIS());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.ConductiveIron, ItemList.ConductiveIronBars.getIS());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.ElectricalSteel, ItemList.ElectricalSteelBars.getIS());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.EnergeticAlloy, ItemList.EnergeticAlloyBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Enderium, ItemList.EnderiumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.EnderiumBase, ItemList.EnderiumBaseBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Iridium, ItemList.IridiumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Neutronium, ItemList.NeutroniumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Osmium, ItemList.OsmiumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.PulsatingIron, ItemList.PulsatingIronBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.RedstoneAlloy, ItemList.RedstoneAlloyBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Soularium, ItemList.SoulariumBars.getIS());
        GTOreDictUnificator.registerOre(
                OrePrefixes.bars,
                Materials.Soularium,
                GTModHandler.getModItem(EnderIO.ID, "blockSoulariumBars", 1L, 0));
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.StainlessSteel, ItemList.StainlessSteelBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Steel, ItemList.SteelBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Titanium, ItemList.TitaniumBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Tungsten, ItemList.TungstenBars.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.TungstenSteel, ItemList.TungstenSteelBars.getIS());

        GTOreDictUnificator.registerOre(
                OrePrefixes.ore,
                Materials.Desh,
                GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.stick,
                Materials.Desh,
                GTModHandler.getModItem(GalacticraftMars.ID, "item.null", 1L, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ore,
                Materials.Ilmenite,
                GTModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 4));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.MeteoricIron,
                GTModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 12));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.HeeEndium,
                GTModHandler.getModItem(HardcoreEnderExpansion.ID, "endium_ingot", 1L, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.HeeEndium,
                GTModHandler.getModItem(HardcoreEnderExpansion.ID, "endium_block", 1L, 0));

        GTOreDictUnificator
                .registerOre("oreAdamantium", GTModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 3));
        GTOreDictUnificator
                .registerOre("ingotAdamantium", GTModHandler.getModItem(GalaxySpace.ID, "item.Ingots", 1L, 0));
        GTOreDictUnificator.registerOre("oreCobalt", GTModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 4));
        GTOreDictUnificator.registerOre("ingotCobalt", GTModHandler.getModItem(GalaxySpace.ID, "item.Ingots", 1L, 1));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Lead,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Adamantium,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Cobalt,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Magnesium,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 3));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Mithril,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 4));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Nickel,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 5));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Oriharukon,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 6));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Platinum,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 7));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Tungsten,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 8));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Copper,
                GTModHandler.getModItem(GalaxySpace.ID, "metalsblock", 1L, 9));

        GTOreDictUnificator.registerOre("chestSteel", GTModHandler.getModItem(IronChests.ID, "BlockIronChest", 1L, 4));

        GTOreDictUnificator.registerOre("craftingToolShears", new ItemStack(Items.shears, 1, 32767));

        GTOreDictUnificator.registerOre("cropBarley", GTModHandler.getModItem(Natura.ID, "barleyFood", 1L, 0));

        GTOreDictUnificator
                .registerOre("craftingToolShears", GTModHandler.getModItem(ExtraUtilities.ID, "shears", 1L, 32767));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Unstable,
                GTModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 5));

        GTOreDictUnificator.registerOre("logWood", GTModHandler.getModItem(ForbiddenMagic.ID, "TaintLog", 1L, 32767));
        GTOreDictUnificator
                .registerOre("plankWood", GTModHandler.getModItem(ForbiddenMagic.ID, "TaintPlank", 1L, 32767));

        GTOreDictUnificator.registerOre("beeComb", GTModHandler.getModItem(Gendustry.ID, "HoneyComb", 1L));

        GTOreDictUnificator
                .registerOre("itemBeeswax", GTModHandler.getModItem(PamsHarvestCraft.ID, "beeswaxItem", 1L, 0));
        GTOreDictUnificator.registerOre("foodFlour", GTModHandler.getModItem(PamsHarvestCraft.ID, "flourItem", 1L, 0));
        GTOreDictUnificator
                .registerOre("listAllmeatcooked", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GTOreDictUnificator
                .registerOre("listAllporkcooked", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GTOreDictUnificator.registerOre(
                "listAllchickencooked",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GTOreDictUnificator
                .registerOre("listAllbeefcooked", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GTOreDictUnificator
                .registerOre("listAllmeatraw", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L));
        GTOreDictUnificator
                .registerOre("listAllporkraw", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L));
        GTOreDictUnificator
                .registerOre("listAllchickenraw", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L));
        GTOreDictUnificator
                .registerOre("listAllbeefraw", GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L));
        GTOreDictUnificator.registerOre("foodSalt", GTOreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Salt,
                GTModHandler.getModItem(PamsHarvestCraft.ID, "spamcompressedsaltBlockalt", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.dust,
                Materials.Wheat,
                GTModHandler.getModItem(PamsHarvestCraft.ID, "flourItem", 1L, 0));

        GTOreDictUnificator
                .registerOre("beeComp", GTModHandler.getModItem(Computronics.ID, "computronics.partsForestry", 1L, 0));

        GTOreDictUnificator
                .registerOre("craftingToolShears", GTModHandler.getModItem(Railcraft.ID, "tool.steel.shears", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Reinforced,
                GTModHandler.getModItem(StevesCarts2.ID, "BlockMetalStorage", 1L, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Galgadorian,
                GTModHandler.getModItem(StevesCarts2.ID, "BlockMetalStorage", 1L, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.EnhancedGalgadorian,
                GTModHandler.getModItem(StevesCarts2.ID, "BlockMetalStorage", 1L, 2));

        GTOreDictUnificator.registerOre(
                OrePrefixes.nugget,
                Materials.Void,
                GTModHandler.getModItem(Thaumcraft.ID, "ItemNugget", 1L, 7));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Amber,
                GTModHandler.getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Bedrockium,
                GTModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Shadow,
                GTModHandler.getModItem(TaintedMagic.ID, "BlockShadowmetal", 1L, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Shadow,
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1L, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Ichorium,
                GTModHandler.getModItem(ThaumicTinkerer.ID, "kamiResource", 1L, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.nugget,
                Materials.Ichorium,
                GTModHandler.getModItem(ThaumicTinkerer.ID, "kamiResource", 1L, 3));

        GTOreDictUnificator.registerOre("dyeLime", GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L));

        GTOreDictUnificator.registerOre(
                OrePrefixes.log,
                Materials.Wood,
                GTModHandler.getModItem(IndustrialCraft2.ID, "blockRubWood", 1L, 0));

        // oreDict UMV and UXV circuits
        GTOreDictUnificator.registerOre(OrePrefixes.circuit, Materials.UMV, ItemList.PikoCircuit.getIS());
        GTOreDictUnificator.registerOre(OrePrefixes.circuit, Materials.UXV, ItemList.QuantumCircuit.getIS());
        GTOreDictUnificator.addToBlacklist(ItemList.PikoCircuit.getIS());
        GTOreDictUnificator.addToBlacklist(ItemList.QuantumCircuit.getIS());

        // Add ore dictionary entries for sand and red sand to craft unfired coke oven bricks.
        GTOreDictUnificator.registerOre("sand", new ItemStack(Blocks.sand, 1, 0));
        GTOreDictUnificator.registerOre("sand", new ItemStack(Blocks.sand, 1, 1));
    }
}
