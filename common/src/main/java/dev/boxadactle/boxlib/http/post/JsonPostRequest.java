package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

/**
 * Represents a JSON POST request.
 * This interface extends the {@link HttpPostRequest} interface and provides a default implementation for the
 * {@link #getContentType()} method, returning "application/json".
 */
public interface JsonPostRequest extends HttpPostRequest {

    /**
     * Returns the content type of the JSON POST request.
     * The default implementation returns "application/json".
     *
     * @return the content type of the JSON POST request
     */
    @Override
    default String getContentType() {
        return "application/json";
    };
}
