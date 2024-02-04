package com.dreammaster.mantle;

import java.util.Objects;
import java.util.stream.Stream;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;

import gregtech.GT_Mod;
import gregtech.api.interfaces.internal.IGT_Mod;
import mantle.books.BookData;

/**
 * Implementation class. Use it through BookLoader::of
 */
final class MantleBookLoader implements BookLoader {

    private static final BookDataReader BOOK_DATA_READER = new BookDataReader();
    private static final BookDataStoreProxy BOOK_DATA_STORE_PROXY = BookDataStoreProxy.getInstance();
    private final BookDataStoreProxy bookDataStoreProxy;
    private final BookData data;
    private final IGT_Mod sideChecker;
    private final BookDataReader bookDataReader;

    static BookLoader readBook(String unlocalizedName, String modId, String xmlDocumentPath) {
        return new MantleBookLoader(BOOK_DATA_STORE_PROXY, BOOK_DATA_READER, GT_Mod.gregtechproxy)
                .setRequiredData(unlocalizedName, modId, xmlDocumentPath);
    }

    @VisibleForTesting
    MantleBookLoader(BookDataStoreProxy bookDataStoreProxy, BookDataReader bookDataReader, IGT_Mod sideChecker) {
        Stream.of(bookDataStoreProxy, bookDataReader, sideChecker).forEach(Objects::requireNonNull);
        this.bookDataStoreProxy = bookDataStoreProxy;
        this.bookDataReader = bookDataReader;
        this.sideChecker = sideChecker;
        this.data = new BookData();
    }

    @VisibleForTesting
    BookLoader setRequiredData(String unlocalizedName, String modId, String xmlDocumentPath) {
        Objects.requireNonNull(unlocalizedName);
        Objects.requireNonNull(modId);
        Objects.requireNonNull(xmlDocumentPath);
        this.data.unlocalizedName = unlocalizedName;
        this.data.modID = modId;
        if (sideChecker.isClientSide()) {
            data.doc = bookDataReader.readBook(xmlDocumentPath);
        }
        return this;
    }

    @Override
    public BookLoader setTooltip(String tooltip) {
        Objects.requireNonNull(tooltip);
        data.toolTip = "§o" + StatCollector.translateToLocal(tooltip);
        return this;
    }

    @Override
    public BookLoader setItemImage(String itemImage) {
        Objects.requireNonNull(itemImage);
        data.itemImage = new ResourceLocation(data.modID, itemImage);
        return this;
    }

    @Override
    public BookLoader makeTranslatable() {
        data.isTranslatable = true;
        return this;
    }

    @Override
    public void addToBookDataStore() {
        if (Strings.isNullOrEmpty(data.unlocalizedName)) {
            throw new IllegalStateException("You must call setRequiredData before addToBookDataStore.");
        }
        bookDataStoreProxy.addBook(data);
    }
}
