package dev.boxadactle.boxlib.http.get;

import dev.boxadactle.boxlib.http.HttpGetRequest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * Represents an HTTP GET request that expects an XML response.
 */
public interface XmlGetRequest extends HttpGetRequest<Document> {

    @Override
    default Document handleResponse(String response) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(new StringReader(response)));
        } catch (Exception e) {
            onException(e);
            return null;
        }
    }
}
