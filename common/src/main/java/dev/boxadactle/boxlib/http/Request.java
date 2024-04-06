package dev.boxadactle.boxlib.http;

import dev.boxadactle.boxlib.http.get.PlainGetRequest;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The Request class is responsible for sending HTTP requests.
 */
public class Request {

    /**
     * Sends an HTTP request.
     *
     * @param request the HttpRequest object representing the request to be sent
     */
    public static <T> T sendRequest(HttpRequest<T> request) {
        try {
            URL url = request.getRequestURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            request.setRequestHeaders(connection);

            T response = request.onResponseCode(connection, connection.getResponseCode());

            connection.disconnect();

            return response;
        } catch (Exception e) {
            request.onException(e);

            return null;
        }
    }

    /**
     * Sends a plain GET request to the specified URL and returns the response as a string.
     *
     * @param url the URL to send the GET request to
     * @return the response from the server as a string
     */
    public static String sendPlainGetRequest(String url) {
        return sendRequest(new PlainGetRequest() {

            @Override
            public String getRequestUrlString() throws InvalidHttpRequestException {
                return url;
            }

            @Override
            public String handleResponse(String response) {
                return PlainGetRequest.super.handleResponse(response);
            }
        });
    }

}
