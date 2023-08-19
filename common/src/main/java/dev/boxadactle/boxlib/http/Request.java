package dev.boxadactle.boxlib.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

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
