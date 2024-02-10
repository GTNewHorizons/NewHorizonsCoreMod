package com.dreammaster.mantle;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import eu.usrv.yamcore.auxiliary.LogHelper;
import mantle.books.BookData;
import mantle.books.BookDataStore;

@ExtendWith(MockitoExtension.class)
class BookDataStoreProxyTest {

    @Mock
    LogHelper LOGGER;

    @Mock
    BookData BOOKDATA;

    @Test
    void instanciateWithNull() {
        assertThatThrownBy(() -> new BookDataStoreProxy(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciate() {
        assertThatCode(() -> new BookDataStoreProxy(LOGGER)).doesNotThrowAnyException();
    }

    @Test
    void addNullBook() {
        BookDataStoreProxy bookDataStoreProxy = new BookDataStoreProxy(LOGGER);

        assertThatThrownBy(() -> bookDataStoreProxy.addBook(null)).isInstanceOf(NullPointerException.class);
        verify(LOGGER, never()).error(anyString());
    }

    @Test
    void addValidBook() {
        try (MockedStatic<BookDataStore> bookDataStore = mockStatic(BookDataStore.class)) {
            BookDataStoreProxy bookDataStoreProxy = new BookDataStoreProxy(LOGGER);

            bookDataStoreProxy.addBook(BOOKDATA);

            bookDataStore.verify(() -> BookDataStore.addBook(BOOKDATA));
            verify(LOGGER, never()).error(anyString());
        }
    }

    /**
     * BookDataStore will throw an IllegalArgumentException if it already contains a book. We catch and log it to
     * increase interoperability.
     */
    @Test
    void addDuplicateBook() {
        try (MockedStatic<BookDataStore> bookDataStore = mockStatic(BookDataStore.class)) {
            bookDataStore.when(() -> BookDataStore.addBook(BOOKDATA)).thenThrow(new IllegalArgumentException());
            BookDataStoreProxy bookDataStoreProxy = new BookDataStoreProxy(LOGGER);

            bookDataStoreProxy.addBook(BOOKDATA);

            bookDataStore.verify(() -> BookDataStore.addBook(BOOKDATA));
            verify(LOGGER).error(anyString());
        }
    }
}
