package dev.boxadactle.boxlib.http;

import dev.boxadactle.boxlib.core.BoxLib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public interface HttpRequest {

    default URL getRequestURL() {
        try {
            return new URL(getRequestUrlString());
        } catch(Exception e) {
            throw new InvalidHttpRequestException(e);
        }
    }

    default String getRequestUrlString() {
        throw new InvalidHttpRequestException("No request URL was specified.");
    }

    default void setRequestHeaders(HttpURLConnection c) throws ProtocolException {
        c.setConnectTimeout(5000);
        c.setReadTimeout(5000);
    }

    void onOkResponse(String response);

    default void onOtherResponse(int code) {
        BoxLib.LOGGER.warn("Server responded with an unexpected response: " + code);
    }

    default void onException(Exception e) {
        BoxLib.LOGGER.error("Error occurred when sending http request:");
        BoxLib.LOGGER.printStackTrace(e);
    }

    default void onResponseCode(HttpURLConnection c, int responseCode) {
        try {
            if (responseCode == 200) {
                BufferedReader b = new BufferedReader(new InputStreamReader(c.getInputStream()));
                String string;
                StringBuilder content = new StringBuilder();

                while ((string = b.readLine()) != null) {
                    content.append(string).append("\n");
                }

                b.close();

                onOkResponse(content.toString().trim());
            } else {
                onOtherResponse(responseCode);
            }
        } catch (Exception e) {
            onException(e);
        }
    }

}
