package com.dreammaster.oredict;

import static com.dreammaster.MissingModIDs.ExtraTrees;
import static com.dreammaster.MissingModIDs.PamsHarvestTheNether;
import static gregtech.api.enums.ModIDs.Forestry;
import static gregtech.api.enums.ModIDs.GalacticraftCore;
import static gregtech.api.enums.ModIDs.GalacticraftMars;
import static gregtech.api.enums.ModIDs.GalaxySpace;
import static gregtech.api.enums.ModIDs.Natura;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.item.ItemList;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GT_ModHandler;

public class OreDictHandler {

    /*
     * Made by bartimaeusnek, cleaned up by glowredman
     */

    public static void register_space_dust() {

        reg_dust(OreDictTypes.Asteroids.name(), ItemList.AsteroidsStoneDust.getIS());
        reg_dust(OreDictTypes.BarnardaE.name(), ItemList.BarnardaEStoneDust.getIS());
        reg_dust(OreDictTypes.BarnardaF.name(), ItemList.BarnardaFStoneDust.getIS());
        reg_dust(OreDictTypes.Callisto.name(), ItemList.CallistoStoneDust.getIS());
        reg_dust(OreDictTypes.CentauriA.name(), ItemList.CentauriAStoneDust.getIS());
        reg_dust(OreDictTypes.CentauriA.name(), ItemList.CentauriASurfaceDust.getIS());
        reg_dust(OreDictTypes.Ceres.name(), ItemList.CeresStoneDust.getIS());
        reg_dust(OreDictTypes.Deimos.name(), ItemList.DeimosStoneDust.getIS());
        reg_dust(OreDictTypes.Enceladus.name(), ItemList.EnceladusStoneDust.getIS());
        reg_dust(OreDictTypes.Enceladus.name(), ItemList.EnceladusIceDust.getIS());
        reg_dust(OreDictTypes.Europa.name(), ItemList.EuropaIceDust.getIS());
        reg_dust(OreDictTypes.Europa.name(), ItemList.EuropaStoneDust.getIS());
        reg_dust(OreDictTypes.Ganymede.name(), ItemList.GanymedeStoneDust.getIS());
        reg_dust(OreDictTypes.Haumea.name(), ItemList.HaumeaStoneDust.getIS());
        reg_dust(OreDictTypes.Io.name(), ItemList.IoStoneDust.getIS());
        reg_dust(OreDictTypes.MakeMake.name(), ItemList.MakeMakeStoneDust.getIS());
        reg_dust(OreDictTypes.Mars.name(), ItemList.MarsStoneDust.getIS());
        reg_dust(OreDictTypes.PlanetMercury.name(), ItemList.MercuryStoneDust.getIS());
        reg_dust(OreDictTypes.PlanetMercury.name(), ItemList.MercuryCoreDust.getIS());
        reg_dust(OreDictTypes.Miranda.name(), ItemList.MirandaStoneDust.getIS());
        reg_dust(OreDictTypes.Moon.name(), ItemList.MoonStoneDust.getIS());
        reg_dust(OreDictTypes.Oberon.name(), ItemList.OberonStoneDust.getIS());
        reg_dust(OreDictTypes.Phobos.name(), ItemList.PhobosStoneDust.getIS());
        reg_dust(OreDictTypes.Pluto.name(), ItemList.PlutoIceDust.getIS());
        reg_dust(OreDictTypes.Pluto.name(), ItemList.PlutoStoneDust.getIS());
        reg_dust(OreDictTypes.Proteus.name(), ItemList.ProteusStoneDust.getIS());
        reg_dust(OreDictTypes.TcetiE.name(), ItemList.TCetiEStoneDust.getIS());
        reg_dust(OreDictTypes.Titan.name(), ItemList.TitanStoneDust.getIS());
        reg_dust(OreDictTypes.Triton.name(), ItemList.TritonStoneDust.getIS());
        reg_dust(OreDictTypes.VegaB.name(), ItemList.VegaBStoneDust.getIS());
        reg_dust(OreDictTypes.Venus.name(), ItemList.VenusStoneDust.getIS());

        if (GalaxySpace.isModLoaded()) {
            Item glowstoneDusts = GameRegistry.findItem(GalaxySpace.modID, "item.GlowstoneDusts");
            reg_dust(OreDictTypes.Ceres.name(), new ItemStack(glowstoneDusts, 1, 0));
            reg_dust(OreDictTypes.Io.name(), new ItemStack(glowstoneDusts, 1, 1));
            reg_dust(OreDictTypes.Enceladus.name(), new ItemStack(glowstoneDusts, 1, 2));
            reg_dust(OreDictTypes.Proteus.name(), new ItemStack(glowstoneDusts, 1, 3));
            reg_dust(OreDictTypes.Pluto.name(), new ItemStack(glowstoneDusts, 1, 4));
        }
    }

    public static void register_space_rocks() {
        if (GalacticraftCore.isModLoaded()) {
            Block moonBlocks = GameRegistry.findBlock(GalacticraftCore.modID, "tile.moonBlock");
            for (int i = 3; i < 6; i++) {
                reg_rock(OreDictTypes.Moon.name(), new ItemStack(moonBlocks, 1, i));
            }
        }

        if (GalacticraftMars.isModLoaded()) {
            Block marsBlocks = GameRegistry.findBlock(GalacticraftMars.modID, "tile.mars");
            Block asteroidsBlocks = GameRegistry.findBlock(GalacticraftMars.modID, "tile.asteroidsBlock");
            for (int i = 0; i < 3; i++) {
                reg_rock(OreDictTypes.Mars.name(), new ItemStack(marsBlocks, 1, i + 4));
                reg_rock(OreDictTypes.Asteroids.name(), new ItemStack(asteroidsBlocks, 1, i));
            }
            reg_rock(OreDictTypes.Mars.name(), new ItemStack(marsBlocks, 1, 9));
        }

        if (GalaxySpace.isModLoaded()) {
            Block phobosBlocks = GameRegistry.findBlock(GalaxySpace.modID, "phobosblocks");
            Block ioBlocks = GameRegistry.findBlock(GalaxySpace.modID, "ioblocks");
            Block mercuryBlocks = GameRegistry.findBlock(GalaxySpace.modID, "mercuryblocks");
            Block titanBlocks = GameRegistry.findBlock(GalaxySpace.modID, "titanblocks");
            Block oberonBlocks = GameRegistry.findBlock(GalaxySpace.modID, "oberonblocks");
            Block mirandaBlocks = GameRegistry.findBlock(GalaxySpace.modID, "mirandablocks");
            Block proteusBlocks = GameRegistry.findBlock(GalaxySpace.modID, "proteusblocks");
            Block tritonBlocks = GameRegistry.findBlock(GalaxySpace.modID, "tritonblocks");
            Block plutoBlocks = GameRegistry.findBlock(GalaxySpace.modID, "plutoblocks");
            Block tCetiEBlocks = GameRegistry.findBlock(GalaxySpace.modID, "tcetieblocks");
            Block deimosBlocks = GameRegistry.findBlock(GalaxySpace.modID, "deimosblocks");
            Block venusBlocks = GameRegistry.findBlock(GalaxySpace.modID, "venusblocks");
            Block ceresBlocks = GameRegistry.findBlock(GalaxySpace.modID, "ceresblocks");
            Block europaGrunt = GameRegistry.findBlock(GalaxySpace.modID, "europagrunt");
            Block ganymedeBlocks = GameRegistry.findBlock(GalaxySpace.modID, "ganymedeblocks");
            Block callistoBlocks = GameRegistry.findBlock(GalaxySpace.modID, "callistoblocks");
            Block enceladusBlocks = GameRegistry.findBlock(GalaxySpace.modID, "enceladusblocks");
            Block makemakeGrunt = GameRegistry.findBlock(GalaxySpace.modID, "makemakegrunt");
            for (int i = 0; i < 3; i++) {
                reg_rock(OreDictTypes.Phobos.name(), new ItemStack(phobosBlocks, 1, i));
                reg_rock(OreDictTypes.Io.name(), new ItemStack(ioBlocks, 1, i));
                reg_rock(OreDictTypes.PlanetMercury.name(), new ItemStack(mercuryBlocks, 1, i));
                reg_rock(OreDictTypes.Titan.name(), new ItemStack(titanBlocks, 1, i));
                reg_rock(OreDictTypes.Oberon.name(), new ItemStack(oberonBlocks, 1, i));
                reg_rock(OreDictTypes.Miranda.name(), new ItemStack(mirandaBlocks, 1, i));
                reg_rock(OreDictTypes.Proteus.name(), new ItemStack(proteusBlocks, 1, i));
                reg_rock(OreDictTypes.Triton.name(), new ItemStack(tritonBlocks, 1, i));
                reg_rock(OreDictTypes.Pluto.name(), new ItemStack(plutoBlocks, 1, i));
                reg_rock(OreDictTypes.Pluto.name(), new ItemStack(plutoBlocks, 1, i + 3));
                reg_rock(OreDictTypes.TcetiE.name(), new ItemStack(tCetiEBlocks, 1, i));
            }
            for (int i = 0; i < 2; i++) {
                reg_rock(OreDictTypes.Deimos.name(), new ItemStack(deimosBlocks, 1, i));
                reg_rock(OreDictTypes.Venus.name(), new ItemStack(venusBlocks, 1, i));
                reg_rock(OreDictTypes.Ceres.name(), new ItemStack(ceresBlocks, 1, i));
                reg_rock(OreDictTypes.Europa.name(), new ItemStack(europaGrunt, 1, i));
                reg_rock(OreDictTypes.Ganymede.name(), new ItemStack(ganymedeBlocks, 1, i));
                reg_rock(OreDictTypes.Callisto.name(), new ItemStack(callistoBlocks, 1, i));
                reg_rock(OreDictTypes.Enceladus.name(), new ItemStack(enceladusBlocks, 1, i));
                reg_rock(OreDictTypes.MakeMake.name(), new ItemStack(makemakeGrunt, 1, i));
            }
            reg_rock(
                    OreDictTypes.Europa.name(),
                    GT_ModHandler.getModItem(GalaxySpace.modID, "europaunderwatergeyser", 1L, 0));
            reg_rock(OreDictTypes.Europa.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "europageyser", 1L, 0));
            reg_rock(OreDictTypes.Haumea.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "haumeablocks", 1L, 0));
            reg_rock(OreDictTypes.CentauriA.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "acentauribbgrunt", 1L, 0));
            reg_rock(
                    OreDictTypes.CentauriA.name(),
                    GT_ModHandler.getModItem(GalaxySpace.modID, "acentauribbsubgrunt", 1L, 0));
            reg_rock(OreDictTypes.VegaB.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "vegabsubgrunt", 1L, 0));
            reg_rock(OreDictTypes.VegaB.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "vegabgrunt", 1L, 0));
            reg_rock(OreDictTypes.BarnardaE.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaEgrunt", 1L, 0));
            reg_rock(
                    OreDictTypes.BarnardaE.name(),
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaEsubgrunt", 1L, 0));
            reg_rock(
                    OreDictTypes.BarnardaF.name(),
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaFsubgrunt", 1L, 0));
            reg_rock(OreDictTypes.BarnardaF.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaFgrunt", 1L, 0));
            reg_rock(OreDictTypes.Io.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "ioglowstone", 1L, 0));
            reg_rock(
                    OreDictTypes.Enceladus.name(),
                    GT_ModHandler.getModItem(GalaxySpace.modID, "enceladusglowstone", 1L, 0));
            reg_rock(OreDictTypes.Pluto.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "plutoglowstone", 1L, 0));
            reg_rock(OreDictTypes.Proteus.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "proteusglowstone", 1L, 0));
            reg_rock(OreDictTypes.Ceres.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "ceresglowstone", 1L, 0));
            reg_rock(OreDictTypes.Enceladus.name(), GT_ModHandler.getModItem(GalaxySpace.modID, "enceladusblocks", 1L, 3));
        }
    }

    public static void reg_additional() {
        if (GalaxySpace.isModLoaded()) {
            Item tCetiEDandelionsItem = GameRegistry.findItem(GalaxySpace.modID, "tcetiedandelions");
            for (int i = 0; i < 6; i++) {
                ItemStack tCetiEDandelionsStack = new ItemStack(tCetiEDandelionsItem, 1, i);
                OreDictionary.registerOre("cropSpace", tCetiEDandelionsStack);
                OreDictionary.registerOre("cropTcetiESeaweed", tCetiEDandelionsStack);
            }
        }

        if (PamsHarvestTheNether.isModLoaded()) {
            OreDictionary.registerOre("logWood", GameRegistry.findBlock(PamsHarvestTheNether.modID, "netherLog"));
        }

        OreDictionary.registerOre("foodSalt", ItemList.EdibleSalt.getIS());

        // Olivine = Peridot
        for (ItemStack stack : OreDictionary.getOres("blockOlivine")) {
            OreDictionary.registerOre("blockPeridot", stack);
        }
    }

    public static void register_all() {
        reg_woodItems();
        reg_additional();
        register_space_rocks();
        register_space_dust();
    }

    private static void reg_fenceWood() {
        for (ItemStack itemStack : new ItemStack[] { new ItemStack(Blocks.fence),
                GT_ModHandler.getModItem(ExtraTrees.modID, "fence", 1, WILDCARD_VALUE),
                GT_ModHandler.getModItem(Forestry.modID, "fences", 1, WILDCARD_VALUE),
                GT_ModHandler.getModItem(Forestry.modID, "fencesFireproof", 1, WILDCARD_VALUE),
                GT_ModHandler.getModItem(Natura.modID, "Natura.fence", 1, WILDCARD_VALUE) }) {
            if (itemStack != null) {
                OreDictionary.registerOre("fenceWood", itemStack);
            }
        }
    }

    private static void reg_woodItems() {
        reg_fenceWood(); // Register fenceWood
    }

    private static void reg_dust(String S, ItemStack I) {
        if (I != null) {
            String p = I.getUnlocalizedName().replaceAll("item\\.", "").replaceAll("Dust", "").replaceAll(" ", "")
                    .trim();
            OreDictionary.registerOre(OreDictTypes.dust.name() + p, I);
            OreDictionary.registerOre(OreDictTypes.dust.name() + S, I);
            OreDictionary.registerOre(OreDictTypes.dust.name() + OreDictTypes.Space.name(), I);
        }
    }

    private static void reg_rock(String S, ItemStack I) {
        if (I != null) {
            OreDictionary.registerOre(OreDictTypes.rock.name() + S, I);
            OreDictionary.registerOre(OreDictTypes.rock.name() + OreDictTypes.Space.name(), I);
        }
    }
}
