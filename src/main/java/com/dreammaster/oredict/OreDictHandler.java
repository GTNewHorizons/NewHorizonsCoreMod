package com.dreammaster.oredict;

import com.dreammaster.item.ItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	/*
	 * Made by bartimaeusnek
	 */
	
	public static void register_space_dust() {
		reg_dust(OreDictTypes.Asteroids.name(),ItemList.AsteroidsStoneDust.getIS());
		reg_dust(OreDictTypes.BarnardaE.name(),ItemList.BarnardaEStoneDust.getIS());
		reg_dust(OreDictTypes.BarnardaF.name(),ItemList.BarnardaFStoneDust.getIS());
		reg_dust(OreDictTypes.Callisto.name(),ItemList.CallistoStoneDust.getIS());
		reg_dust(OreDictTypes.CentauriA.name(),ItemList.CentauriAStoneDust.getIS());
		reg_dust(OreDictTypes.Ceres.name(),ItemList.CeresStoneDust.getIS());
		reg_dust(OreDictTypes.Ceres.name(),GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L));
		reg_dust(OreDictTypes.Deimos.name(),ItemList.DeimosStoneDust.getIS());
		reg_dust(OreDictTypes.Enceladus.name(),ItemList.EnceladusStoneDust.getIS());
		reg_dust(OreDictTypes.Enceladus.name(),ItemList.EnceladusIceDust.getIS());
		reg_dust(OreDictTypes.Enceladus.name(),GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L,2));
		reg_dust(OreDictTypes.Europa.name(),ItemList.EuropaIceDust.getIS());
		reg_dust(OreDictTypes.Europa.name(),ItemList.EuropaStoneDust.getIS());
		reg_dust(OreDictTypes.Ganymede.name(),ItemList.GanymedStoneDust.getIS());
		reg_dust(OreDictTypes.Haumea.name(),ItemList.HaumeaStoneDust.getIS());
		reg_dust(OreDictTypes.Io.name(),ItemList.IoStoneDust.getIS());
		reg_dust(OreDictTypes.Io.name(),GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L,1));
		reg_dust(OreDictTypes.MakeMake.name(),ItemList.MakeMakeStoneDust.getIS());
		reg_dust(OreDictTypes.Mars.name(),ItemList.MarsStoneDust.getIS());
		reg_dust(OreDictTypes.Mercury.name(),ItemList.MercuryStoneDust.getIS());
		reg_dust(OreDictTypes.Mercury.name(),ItemList.MercuryCoreDust.getIS());
		reg_dust(OreDictTypes.Miranda.name(),ItemList.MirandaStoneDust.getIS());
		reg_dust(OreDictTypes.Moon.name(),ItemList.MoonStoneDust.getIS());
		reg_dust(OreDictTypes.Oberon.name(),ItemList.OberonStoneDust.getIS());
		reg_dust(OreDictTypes.Phobos.name(),ItemList.PhobosStoneDust.getIS());
		reg_dust(OreDictTypes.Pluto.name(),ItemList.PlutoIceDust.getIS());
		reg_dust(OreDictTypes.Pluto.name(),ItemList.PlutoStoneDust.getIS());
		reg_dust(OreDictTypes.Pluto.name(),GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L,4));
		reg_dust(OreDictTypes.Proteus.name(),ItemList.ProteusStoneDust.getIS());
		reg_dust(OreDictTypes.Proteus.name(),GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L,3));
		reg_dust(OreDictTypes.TcetiE.name(),ItemList.TCetiEStoneDust.getIS());
		reg_dust(OreDictTypes.Titan.name(),ItemList.TitanStoneDust.getIS());
		reg_dust(OreDictTypes.Triton.name(),ItemList.TritonStoneDust.getIS());
		reg_dust(OreDictTypes.VegaB.name(),ItemList.VegaBStoneDust.getIS());
		reg_dust(OreDictTypes.Venus.name(),ItemList.VenusStoneDust.getIS());
	}
	
	public static void register_space_rocks() {
		/*if(Loader.isModLoaded("GalacticraftCore"))
		for (byte i=3; i<6;i++)
			reg_rock(OreDictTypes.Moon.name(),GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, i));
		
		if(Loader.isModLoaded("GalacticraftMars")) {
		for (byte i=4; i<7;i++)
			reg_rock(OreDictTypes.Mars.name(),GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, i));
			reg_rock(OreDictTypes.Mars.name(),GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 9));
			
		}
		
		if(Loader.isModLoaded("GalaxySpace")) {
			for (byte i=0; i<3;i++)
				reg_rock(OreDictTypes.Phobos.name(),GT_ModHandler.getModItem("GalaxySpace", "phobosblocks", 1L, i));
		}
		
		*/
	}
	
	public static void reg_additional() {
		if(Loader.isModLoaded("GalaxySpace"))
		for (byte i = 0; i<6; i++) {
		OreDictionary.registerOre("cropSpace", GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 1L,i));
		OreDictionary.registerOre("cropTcetiESeaweed", GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 1L,i));
		}
	}
	
	public static void register_all() {
		reg_additional();
		register_space_rocks();
		register_space_dust();
	}
	
	private static void reg_dust(String S,ItemStack I) {
		String p = I.getDisplayName().replaceAll("Dust", "").replaceAll(" ", "").trim();
		OreDictionary.registerOre(OreDictTypes.dust.name()+p, I);
		OreDictionary.registerOre(OreDictTypes.dust.name()+S, I);
		OreDictionary.registerOre(OreDictTypes.dust.name()+OreDictTypes.Space.name(),I);
	}

	private static void reg_rock(String S,ItemStack I) {
		OreDictionary.registerOre(OreDictTypes.rock.name()+S, I);
		OreDictionary.registerOre(OreDictTypes.rock.name()+OreDictTypes.Space.name(), I);
	}
}
