package com.dreammaster.gthandler;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
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
import static com.dreammaster.scripts.IngredientFactory.createItemStack;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;

import gregtech.api.enums.ItemList;
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
                getModItem(BloodArsenal.ID, "blood_infused_iron", 1, 0));
        GTOreDictUnificator.registerOre(
                "blockBloodInfusedIron",
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.log,
                Materials.Wood,
                getModItem(BiomesOPlenty.ID, "logs4", 1, 3));
        GTOreDictUnificator.registerOre("cropCarrot", getModItem(BiomesOPlenty.ID, "food", 1, 2));

        GTOreDictUnificator
                .registerOre(OrePrefixes.compressed, Materials.Mytryl, NHItemList.MytrylCompressedPlate.get());
        GTOreDictUnificator.registerOre(OrePrefixes.block, Materials.Mytryl, BlockList.Mytryl.get());
        GTOreDictUnificator.registerOre("blockCallistoIce", BlockList.CallistoColdIce.get());
        GTOreDictUnificator.registerOre(
                OrePrefixes.compressed,
                Materials.CallistoIce,
                NHItemList.CallistoIceCompressedPlate.get());
        GTOreDictUnificator.registerOre("blockLedox", BlockList.Ledox.get());
        GTOreDictUnificator.registerOre(OrePrefixes.compressed, Materials.Ledox, NHItemList.LedoxCompressedPlate.get());
        GTOreDictUnificator.registerOre(OrePrefixes.stick, Materials.Stone, NHItemList.CobbleStoneRod.get());
        GTOreDictUnificator.registerOre(OrePrefixes.plate, Materials.Stone, NHItemList.StonePlate.get());
        GTOreDictUnificator.registerOre("stickSandstone", NHItemList.SandStoneRod.get());
        GTOreDictUnificator.registerOre("lensReinforcedGlass", NHItemList.ReinforcedGlassLense.get());
        GTOreDictUnificator.registerOre("plateReinforcedGlass", NHItemList.ReinforcedGlassPlate.get());
        GTOreDictUnificator.registerOre("blockQuantium", BlockList.Quantinum.get());
        GTOreDictUnificator
                .registerOre(OrePrefixes.compressed, Materials.Quantium, NHItemList.QuantinumCompressedPlate.get());
        GTOreDictUnificator
                .registerOre(OrePrefixes.block, Materials.MysteriousCrystal, BlockList.MysteriousCrystalBlock.get());
        GTOreDictUnificator.registerOre(
                OrePrefixes.compressed,
                Materials.MysteriousCrystal,
                NHItemList.MysteriousCrystalCompressedPlate.get());
        GTOreDictUnificator.registerOre(OrePrefixes.block, Materials.BlackPlutonium, BlockList.BlackPlutonium.get());
        GTOreDictUnificator.registerOre(
                OrePrefixes.dust,
                Materials.CertusQuartzCharged,
                NHItemList.ChargedCertusQuartzDust.get(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.plate,
                Materials.CertusQuartzCharged,
                NHItemList.ChargedCertusQuartzPlate.get(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.stick,
                Materials.CertusQuartzCharged,
                NHItemList.ChargedCertusQuartzRod.get(1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.crystal,
                Materials.CertusQuartzCharged,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.gem,
                Materials.CertusQuartzCharged,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        GTOreDictUnificator.registerOre("dustCokeOvenBrick", NHItemList.CokeOvenBrickDust.get(1));
        GTOreDictUnificator.registerOre("ingotCokeOvenBrick", NHItemList.CokeOvenBrick.get(1));
        GTOreDictUnificator.registerOre("leather", NHItemList.ArtificialLeather.get(1));
        GTOreDictUnificator.registerOre("itemLeather", NHItemList.ArtificialLeather.get(1));
        GTOreDictUnificator.registerOre("dustPotassiumHydroxide", NHItemList.PotassiumHydroxideDust.get(1));

        GTOreDictUnificator.registerOre(OrePrefixes.stickLong, Materials.Obsidian, NHItemList.LongObsidianRod.get());

        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Aluminium, NHItemList.AluminiumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Chrome, NHItemList.ChromeBars.get());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.ConductiveIron, NHItemList.ConductiveIronBars.get());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.ElectricalSteel, NHItemList.ElectricalSteelBars.get());
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.EnergeticAlloy, NHItemList.EnergeticAlloyBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Enderium, NHItemList.EnderiumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.EnderiumBase, NHItemList.EnderiumBaseBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Iridium, NHItemList.IridiumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Neutronium, NHItemList.NeutroniumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Osmium, NHItemList.OsmiumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.PulsatingIron, NHItemList.PulsatingIronBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.RedstoneAlloy, NHItemList.RedstoneAlloyBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Soularium, NHItemList.SoulariumBars.get());
        GTOreDictUnificator.registerOre(
                OrePrefixes.bars,
                Materials.Soularium,
                getModItem(EnderIO.ID, "blockSoulariumBars", 1, 0));
        GTOreDictUnificator
                .registerOre(OrePrefixes.bars, Materials.StainlessSteel, NHItemList.StainlessSteelBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Steel, NHItemList.SteelBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Titanium, NHItemList.TitaniumBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.Tungsten, NHItemList.TungstenBars.get());
        GTOreDictUnificator.registerOre(OrePrefixes.bars, Materials.TungstenSteel, NHItemList.TungstenSteelBars.get());

        GTOreDictUnificator.registerOre(
                OrePrefixes.rawOre,
                Materials.MeteoricIron,
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ore,
                Materials.Desh,
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.stick,
                Materials.Desh,
                getModItem(GalacticraftMars.ID, "item.null", 1, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ore,
                Materials.Ilmenite,
                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 4));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.MeteoricIron,
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 12));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Endium,
                getModItem(HardcoreEnderExpansion.ID, "endium_ingot", 1, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Endium,
                getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0));

        GTOreDictUnificator
                .registerOre("oreAdamantium", getModItem(GalaxySpace.ID, "oberonblocks", 1, 3));
        GTOreDictUnificator.registerOre("oreCobalt", getModItem(GalaxySpace.ID, "phobosblocks", 1, 4));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Lead,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Adamantium,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Cobalt,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Magnesium,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 3));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Mithril,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 4));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Nickel,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 5));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Oriharukon,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 6));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Platinum,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 7));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Tungsten,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 8));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Copper,
                getModItem(GalaxySpace.ID, "metalsblock", 1, 9));

        GTOreDictUnificator.registerOre("chestSteel", getModItem(IronChests.ID, "BlockIronChest", 1, 4));

        GTOreDictUnificator.registerOre("craftingToolShears", new ItemStack(Items.shears, 1, 32767));

        GTOreDictUnificator.registerOre("cropBarley", getModItem(Natura.ID, "barleyFood", 1, 0));

        GTOreDictUnificator
                .registerOre("craftingToolShears", getModItem(ExtraUtilities.ID, "shears", 1, 32767));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Unstable,
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 5));

        GTOreDictUnificator.registerOre("logWood", getModItem(ForbiddenMagic.ID, "TaintLog", 1, 32767));
        GTOreDictUnificator
                .registerOre("plankWood", getModItem(ForbiddenMagic.ID, "TaintPlank", 1, 32767));

        GTOreDictUnificator.registerOre("beeComb", getModItem(Gendustry.ID, "HoneyComb", 1));

        GTOreDictUnificator
                .registerOre("itemBeeswax", getModItem(PamsHarvestCraft.ID, "beeswaxItem", 1, 0));
        GTOreDictUnificator.registerOre("foodFlour", getModItem(PamsHarvestCraft.ID, "flourItem", 1, 0));
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
                getModItem(PamsHarvestCraft.ID, "spamcompressedsaltBlockalt", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.dust,
                Materials.Wheat,
                getModItem(PamsHarvestCraft.ID, "flourItem", 1, 0));

        GTOreDictUnificator
                .registerOre("beeComp", getModItem(Computronics.ID, "computronics.partsForestry", 1, 0));

        GTOreDictUnificator
                .registerOre("craftingToolShears", getModItem(Railcraft.ID, "tool.steel.shears", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Reinforced,
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Galgadorian,
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 1));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.GalgadorianEnhanced,
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 2));

        GTOreDictUnificator.registerOre(
                OrePrefixes.nugget,
                Materials.Void,
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 7));
        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Amber,
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Bedrockium,
                getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.block,
                Materials.Shadow,
                getModItem(TaintedMagic.ID, "BlockShadowmetal", 1, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Shadow,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 0));

        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                Materials.Ichorium,
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 2));
        GTOreDictUnificator.registerOre(
                OrePrefixes.nugget,
                Materials.Ichorium,
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 3));
        GTOreDictUnificator
                .registerOre(OrePrefixes.paneGlass, getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        GTOreDictUnificator.registerOre(
                OrePrefixes.ingot,
                "SearedBrick",
                getModItem(TinkerConstruct.ID, "materials", 1, 2));

        GTOreDictUnificator.registerOre(OrePrefixes.ingot, "Firebrick", ItemList.Firebrick.get(1));

        GTOreDictUnificator.registerOre("dyeLime", GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L));

        GTOreDictUnificator.registerOre(
                OrePrefixes.log,
                Materials.Wood,
                getModItem(IndustrialCraft2.ID, "blockRubWood", 1, 0));

        // oreDict UMV and UXV circuits
        GTOreDictUnificator.registerOre(OrePrefixes.circuit, Materials.UMV, NHItemList.PikoCircuit.get());
        GTOreDictUnificator.registerOre(OrePrefixes.circuit, Materials.UXV, NHItemList.QuantumCircuit.get());
        GTOreDictUnificator.addToBlacklist(NHItemList.PikoCircuit.get());
        GTOreDictUnificator.addToBlacklist(NHItemList.QuantumCircuit.get());

        // Add ore dictionary entries for sand and red sand to craft unfired coke oven bricks.
        GTOreDictUnificator.registerOre("sand", new ItemStack(Blocks.sand, 1, 0));
        GTOreDictUnificator.registerOre("sand", new ItemStack(Blocks.sand, 1, 1));

        // Allow EFR blast furnace to be used instead of GT iron furnace.
        GTOreDictUnificator.registerOre(
                "craftingIronFurnace",
                getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0));
    }
}
