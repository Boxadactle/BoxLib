package dev.boxadactle.boxlib.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * Represents an HTTP POST request.
 * Extends the {@link HttpRequest} interface.
 */
public interface HttpPostRequest<T> extends HttpRequest<T> {

    /**
     * Sets the request headers for the HTTP POST request.
     * Overrides the default implementation in the {@link HttpRequest} interface.
     *
     * @param c The {@link HttpURLConnection} object representing the connection.
     * @throws ProtocolException If an error occurs while setting the request method.
     */
    @Override
    default void setRequestHeaders(HttpURLConnection c) throws ProtocolException {
        c.setRequestMethod("POST");
        HttpRequest.super.setRequestHeaders(c);

        c.setDoOutput(true);
        c.setDoInput(true);

        c.setRequestProperty("Content-type", getContentType());

        try (DataOutputStream outputStream = new DataOutputStream(c.getOutputStream())) {
            outputStream.writeBytes(getPayload());
            outputStream.flush();
        } catch (IOException e) {
            onException(e);
        }
    }

    /**
     * Gets the content type for the HTTP POST request.
     *
     * @return The content type as a {@link String}.
     */
    String getContentType();

    /**
     * Gets the payload for the HTTP POST request.
     *
     * @return The payload as a {@link String}.
     */
    String getPayload();

}
