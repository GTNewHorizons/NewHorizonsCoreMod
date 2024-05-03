package com.dreammaster.mantle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Consumer;
import java.util.stream.Stream;

import net.minecraft.util.ResourceLocation;

import org.assertj.core.api.ObjectAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.Document;

import gregtech.api.interfaces.internal.IGT_Mod;
import mantle.books.BookData;

@ExtendWith(MockitoExtension.class)
class MantleBookLoaderTest {

    private static final String PATH = "/somewhere/over/the/rainbow";
    private static final String MOD_ID = "modid";
    private static final String UNLOCALIZED_NAME = "testBook";
    private static final String TOOLTIP = "tooltip";
    private static final String ITEM_IMAGE = "itemImage.png";
    @Mock
    BookDataStoreProxy BOOK_DATA_STORE_PROXY;

    @Mock
    BookDataReader BOOK_DATA_READER;

    @Mock
    IGT_Mod SIDE_CHECKER;

    @Mock
    Document DOCUMENT;

    @Captor
    ArgumentCaptor<BookData> bookDataArgumentCaptor;

    private MantleBookLoader fixture;

    @BeforeEach
    void BeforeEach() {
        fixture = new MantleBookLoader(BOOK_DATA_STORE_PROXY, BOOK_DATA_READER, SIDE_CHECKER);
    }

    private void buildBookAndAddToBookDataStore(Stream<Consumer<BookLoader>> bookBuilderOperation) {
        fixture.setRequiredData(UNLOCALIZED_NAME, MOD_ID, PATH);
        bookBuilderOperation.forEach(operation -> operation.accept(fixture));
        fixture.addToBookDataStore();
    }

    @Test
    void instanciateWithNullBookDataStoreProxy() {
        ThrowingCallable code = () -> new MantleBookLoader(null, BOOK_DATA_READER, SIDE_CHECKER);

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciateWithNullBookDataReader() {
        ThrowingCallable code = () -> new MantleBookLoader(BOOK_DATA_STORE_PROXY, null, SIDE_CHECKER);

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciateWithNullSideChecker() {
        ThrowingCallable code = () -> new MantleBookLoader(BOOK_DATA_STORE_PROXY, BOOK_DATA_READER, null);

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciateProperly() {
        ThrowingCallable code = () -> new MantleBookLoader(BOOK_DATA_STORE_PROXY, BOOK_DATA_READER, SIDE_CHECKER);

        assertThatCode(code).doesNotThrowAnyException();
    }

    /**
     * This test case shouldn't be possible under the current implementation.
     */
    @Test
    void addToBookDataStorePrematurely() {
        ThrowingCallable code = fixture::addToBookDataStore;

        assertThatThrownBy(code).isInstanceOf(IllegalStateException.class);
        verify(BOOK_DATA_STORE_PROXY, never()).addBook(any());
    }

    @Test
    void addToBookDataStoreWithDefaultsServerside() {
        when(SIDE_CHECKER.isClientSide()).thenReturn(false);

        buildBookAndAddToBookDataStore(Stream.empty());

        verify(BOOK_DATA_READER, never()).readBook(PATH);
        assertBaseAddedBookData();
    }

    private ObjectAssert<BookData> assertBaseAddedBookData() {
        verify(BOOK_DATA_STORE_PROXY).addBook(bookDataArgumentCaptor.capture());
        return assertThat(bookDataArgumentCaptor.getValue())
                .hasFieldOrPropertyWithValue("fullUnlocalizedName", MOD_ID + ":" + UNLOCALIZED_NAME);
    }

    @Test
    void addToBookDataStoreWithDefaultsClientside() {
        when(SIDE_CHECKER.isClientSide()).thenReturn(true);
        when(BOOK_DATA_READER.readBook(PATH)).thenReturn(DOCUMENT);

        buildBookAndAddToBookDataStore(Stream.empty());

        assertBaseAddedBookData().hasFieldOrPropertyWithValue("doc", DOCUMENT);
    }

    @Test
    void addToBookDataStoreWithToolTip() {
        buildBookAndAddToBookDataStore(Stream.of((bookLoader) -> bookLoader.setTooltip(TOOLTIP)));

        assertBaseAddedBookData().hasFieldOrPropertyWithValue("toolTip", "§o" + TOOLTIP);
    }

    @Test
    void addToBookDataStoreWithNullToolTip() {
        ThrowingCallable code = () -> buildBookAndAddToBookDataStore(
                Stream.of((bookLoader) -> bookLoader.setTooltip(null)));

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    // Not mocking ResourceLocation, API assumed stable
    @Test
    void addToBookDataStoreWithItemImage() {
        buildBookAndAddToBookDataStore(Stream.of((bookLoader) -> bookLoader.setItemImage(ITEM_IMAGE)));

        assertBaseAddedBookData().extracting((bookData -> bookData.itemImage))
                .isEqualTo(new ResourceLocation(MOD_ID, ITEM_IMAGE));
    }

    @Test
    void addToBookDataStoreWithNullItemImage() {
        ThrowingCallable code = () -> buildBookAndAddToBookDataStore(
                Stream.of((bookLoader) -> bookLoader.setItemImage(null)));

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void addToBookDataStoreAsTranslatable() {
        buildBookAndAddToBookDataStore(Stream.of(BookLoader::makeTranslatable));

        assertBaseAddedBookData().hasFieldOrPropertyWithValue("isTranslatable", true);
    }

}
