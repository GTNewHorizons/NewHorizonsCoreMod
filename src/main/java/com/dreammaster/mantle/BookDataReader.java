package com.dreammaster.mantle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * This class doesn't support loading different XML documents based on Minecraft's currently configured language. Books
 * are instead intended to be translated through lang files.
 * <p>
 * This is an implementation class. Use it through BookLoader::of
 */
class BookDataReader {

    private static final DocumentBuilderFactory DB_FACTORY = DocumentBuilderFactory.newInstance();

    @Nonnull
    Document readBook(String xmlDocumentLocation) {
        try (InputStream stream = loadBook(xmlDocumentLocation)) {
            return readBookDocument(stream);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalStateException(
                    "Failed to load book data from " + xmlDocumentLocation + ":\n" + e.getMessage(),
                    e);
        }
    }

    @Nonnull
    private InputStream loadBook(String path) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(path);
        if (Objects.isNull(inputStream)) {
            throw new IOException("File " + path + " does not exist.");
        }
        return inputStream;
    }

    @Nonnull
    private Document readBookDocument(InputStream stream)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = DB_FACTORY.newDocumentBuilder().parse(stream);
        doc.getDocumentElement().normalize();
        return doc;
    }

}
