package dev.boxadactle.boxlib.http;

import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * Represents an HTTP GET request.
 * This interface extends the {@link HttpRequest} interface and provides a default implementation for setting request headers.
 */
public interface HttpGetRequest extends HttpRequest {

    /**
     * Sets the request headers for the HTTP GET request.
     * Overrides the default implementation in the {@link HttpRequest} interface.
     *
     * @param c the {@link HttpURLConnection} object representing the connection to the server
     * @throws ProtocolException if an error occurs while setting the request method
     */
    @Override
    default void setRequestHeaders(HttpURLConnection c) throws ProtocolException {
        c.setRequestMethod("GET");
        HttpRequest.super.setRequestHeaders(c);
    }

}
