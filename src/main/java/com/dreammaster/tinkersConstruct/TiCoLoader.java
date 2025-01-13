package com.dreammaster.tinkersConstruct;

import static gregtech.api.enums.Mods.TinkerConstruct;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.main.NHItems;
import com.dreammaster.mantle.BookLoader;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelOre;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelOreItem;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelWorldgen;

import cpw.mods.fml.common.registry.GameRegistry;

public class TiCoLoader {

    public static void doPreInitialization() {
        registerZincGravelOre();
    }

    private static void registerZincGravelOre() {
        NHItems.ZINC_GRAVEL_ORE = new ZincGravelOre().setBlockName("block.ore.gravel.zinc");
        NHItems.ZINC_GRAVEL_ORE.setHarvestLevel("shovel", 1, 0);
        GameRegistry.registerBlock(NHItems.ZINC_GRAVEL_ORE, ZincGravelOreItem.class, "ZincGravelOre");
        OreDictionary.registerOre("oreZinc", new ItemStack(NHItems.ZINC_GRAVEL_ORE, 1, 0));
    }

    public static void doInitialization() {
        registerZincGravelOreWorldGen();
    }

    private static void registerZincGravelOreWorldGen() {
        MinecraftForge.TERRAIN_GEN_BUS.register(new ZincGravelWorldgen());
    }

    public static void doPostInitialization() {
        addTiCoManuals();
    }

    private static void addTiCoManuals() {
        addTiCoManual("firstday", "tconstruct.manual.beginner", "manual1.tooltip", "tinker:tinkerbook_diary");
        addTiCoManual("materials", "tconstruct.manual.toolstation", "manual2.tooltip", "tinker:tinkerbook_toolstation");
        addTiCoManual("smeltery", "tconstruct.manual.smeltery", "manual3.tooltip", "tinker:tinkerbook_smeltery");
        addTiCoManual("diary", "tconstruct.manual.diary", "manual4.tooltip", "tinker:tinkerbook_blue");
        addTiCoManual("weaponry", "tconstruct.manual.weaponry", "manual5.tooltip", "tinker:tinkerbook_green");
    }

    private static void addTiCoManual(String bookName, String unlocalizedName, String tooltip, String itemImage) {
        BookLoader.of(unlocalizedName, TinkerConstruct.ID, "/assets/dreamcraft/tinker/manuals/" + bookName + ".xml")
                .setTooltip(tooltip).setItemImage(itemImage).makeTranslatable().addToBookDataStore();
    }
}
