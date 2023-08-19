package dev.boxadactle.boxlib.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public interface HttpPostRequest extends HttpRequest {

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

    @Override
    default void onResponseCode(HttpURLConnection c, int responseCode) {

    };

    String getContentType();

    String getPayload();

}
