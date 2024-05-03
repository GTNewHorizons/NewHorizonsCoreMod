package com.dreammaster.mantle;

public interface BookLoader {

    static BookLoader of(String unlocalizedName, String modId, String xmlDocumentPath) {
        return MantleBookLoader.readBook(unlocalizedName, modId, xmlDocumentPath);
    }

    BookLoader setTooltip(String tooltip);

    BookLoader setItemImage(String itemImage);

    BookLoader makeTranslatable();

    void addToBookDataStore();
}
