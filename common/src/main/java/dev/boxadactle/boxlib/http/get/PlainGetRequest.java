package dev.boxadactle.boxlib.http.get;

import dev.boxadactle.boxlib.http.HttpGetRequest;

/**
 * Represents a plain HTTP GET request that returns a response of type String.
 */
public interface PlainGetRequest extends HttpGetRequest<String> {

    /**
     * Handles the response received from the HTTP GET request.
     *
     * @param response the response received from the HTTP GET request
     * @return the handled response
     */
    default String handleResponse(String response) {
        return response;
    }

}
