package com.dreammaster.mantle;

import java.util.Objects;

import org.apache.logging.log4j.Logger;

import com.dreammaster.main.MainRegistry;

import mantle.books.BookData;
import mantle.books.BookDataStore;

/**
 * This class helps us avoid issues with books already loaded by another mod.
 * <p>
 * Implementation class. Use it through BookLoader::of
 */
class BookDataStoreProxy {

    private static final BookDataStoreProxy INSTANCE = new BookDataStoreProxy(MainRegistry.LOGGER);

    static BookDataStoreProxy getInstance() {
        return INSTANCE;
    }

    private final Logger logger;

    BookDataStoreProxy(Logger logger) {
        Objects.requireNonNull(logger);
        this.logger = logger;

    }

    void addBook(BookData bookData) {
        Objects.requireNonNull(bookData);
        try {
            BookDataStore.addBook(bookData);
        } catch (IllegalArgumentException e) {
            logger.error("Cannot override book {} which is already defined elsewhere.", bookData.unlocalizedName);
        }
    }
}
