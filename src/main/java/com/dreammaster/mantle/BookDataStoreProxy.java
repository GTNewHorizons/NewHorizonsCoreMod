package com.dreammaster.mantle;

import java.util.Objects;

import com.dreammaster.main.MainRegistry;

import eu.usrv.yamcore.auxiliary.LogHelper;
import mantle.books.BookData;
import mantle.books.BookDataStore;

/**
 * This class helps us avoid issues with books already loaded by another mod.
 * <p>
 * Implementation class. Use it through BookLoader::of
 */
class BookDataStoreProxy {

    private static final BookDataStoreProxy INSTANCE = new BookDataStoreProxy(MainRegistry.Logger);

    static BookDataStoreProxy getInstance() {
        return INSTANCE;
    }

    private final LogHelper logger;

    BookDataStoreProxy(LogHelper logger) {
        Objects.requireNonNull(logger);
        this.logger = logger;

    }

    void addBook(BookData bookData) {
        Objects.requireNonNull(bookData);
        try {
            BookDataStore.addBook(bookData);
        } catch (IllegalArgumentException e) {
            logger.error("Cannot override book " + bookData.unlocalizedName + " which is already defined elsewhere.");
        }
    }
}
