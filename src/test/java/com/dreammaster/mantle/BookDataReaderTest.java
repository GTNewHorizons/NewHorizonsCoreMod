package com.dreammaster.mantle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

class BookDataReaderTest {

    private static final String TEST_BOOKS_LOCATION = "/assets/dreamcraft/mantle/";

    @Test
    void instanciate() {
        assertThatCode(BookDataReader::new).doesNotThrowAnyException();
    }

    @Test
    void readValidBook() {
        BookDataReader bookDataReader = new BookDataReader();
        String bookName = TEST_BOOKS_LOCATION + "test-book.xml";

        Document document = bookDataReader.readBook(bookName);

        assertThat(document).extracting(Node::getFirstChild).extracting(Node::getNodeName).isEqualTo("book");

    }

    @Test
    void readMissingBook() {
        BookDataReader bookDataReader = new BookDataReader();
        String bookName = TEST_BOOKS_LOCATION + "missing-book.xml";

        assertThatThrownBy(() -> bookDataReader.readBook(bookName)).isInstanceOf(IllegalStateException.class)
                .hasCauseInstanceOf(IOException.class);
    }

    @Test
    void readInvalidBook() {
        BookDataReader bookDataReader = new BookDataReader();
        String bookName = TEST_BOOKS_LOCATION + "blank-book.xml";

        assertThatThrownBy(() -> bookDataReader.readBook(bookName)).isInstanceOf(IllegalStateException.class)
                .hasCauseInstanceOf(SAXException.class);
    }
}
