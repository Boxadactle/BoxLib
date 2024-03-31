package dev.boxadactle.boxlib.http;

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
    public static void sendRequest(HttpRequest request) {
        try {
            URL url = request.getRequestURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            request.setRequestHeaders(connection);

            request.onResponseCode(connection, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            request.onException(e);
        }
    }

}
