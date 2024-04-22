package dev.boxadactle.boxlib.http;

import dev.boxadactle.boxlib.core.BoxLib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * The HttpRequest interface represents an HTTP request.
 * Implementations of this interface can be used to send HTTP requests and handle the responses.
 */
public interface HttpRequest<T> {

    /**
     * Returns the URL of the HTTP request.
     *
     * @return the URL of the HTTP request
     * @throws InvalidHttpRequestException if the request URL is invalid
     */
    default URL getRequestURL() throws InvalidHttpRequestException {
        try {
            return new URL(getRequestUrlString());
        } catch(Exception e) {
            throw new InvalidHttpRequestException(e);
        }
    }

    /**
     * Returns the URL string of the HTTP request.
     *
     * @return the URL string of the HTTP request
     * @throws InvalidHttpRequestException if no request URL was specified
     */
    default String getRequestUrlString() throws InvalidHttpRequestException {
        throw new InvalidHttpRequestException("No request URL was specified.");
    }

    /**
     * Sets the request headers for the HTTP connection.
     *
     * @param c the HTTP connection
     * @throws ProtocolException if an error occurs while setting the request headers
     */
    default void setRequestHeaders(HttpURLConnection c) throws ProtocolException {
        c.setConnectTimeout(5000);
        c.setReadTimeout(5000);
    }

    /**
     * Called when the HTTP response has a successful status code (200).
     *
     * @param response the response content
     */
    T handleResponse(String response);

    /**
     * Called when the HTTP response has an unexpected status code.
     *
     * @param code the response status code
     */
    default void onOtherResponse(int code) {
        BoxLib.LOGGER.warn("Server responded with an unexpected response: " + code);
    }

    /**
     * Called when an exception occurs during the HTTP request.
     *
     * @param e the exception that occurred
     */
    default void onException(Exception e) {
        BoxLib.LOGGER.error("Error occurred when sending http request:");
        BoxLib.LOGGER.printStackTrace(e);
    }

    /**
     * Called after receiving the response code from the HTTP connection.
     *
     * @param c the HTTP connection
     * @param responseCode the response code
     */
    default T onResponseCode(HttpURLConnection c, int responseCode) {
        try {
            if (responseCode == 200) {
                BufferedReader b = new BufferedReader(new InputStreamReader(c.getInputStream()));
                String string;
                StringBuilder content = new StringBuilder();

                while ((string = b.readLine()) != null) {
                    content.append(string).append("\n");
                }

                b.close();

                return handleResponse(content.toString().trim());
            } else {
                return null;
            }
        } catch (Exception e) {
            onException(e);
            return null;
        }
    }

}
