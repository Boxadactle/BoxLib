package dev.boxadactle.boxlib.http.get;

import dev.boxadactle.boxlib.http.HttpGetRequest;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;

public interface XmlGetRequest extends HttpGetRequest {

    @Override
    default void onOkResponse(String response) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new StringReader(response)));

            onXml(document);
        } catch (Exception e) {
            onException(e);
        }
    }

    void onXml(Document document);
}
