package dev.boxadactle.boxlib.http;

import java.net.HttpURLConnection;
import java.net.ProtocolException;

public interface HttpGetRequest extends HttpRequest {

    @Override
    default void setRequestHeaders(HttpURLConnection c) throws ProtocolException {
        c.setRequestMethod("GET");
        HttpRequest.super.setRequestHeaders(c);
    }

}
