package com.dreammaster.tinkersConstruct;

import static gregtech.api.enums.Mods.TinkerConstruct;

import com.dreammaster.mantle.BookLoader;

public class TiCoLoader {

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
