package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

/**
 * Represents a plain text HTTP POST request.
 * This interface extends the HttpPostRequest interface.
 */
public interface PlainTextPostRequest extends HttpPostRequest {

    /**
     * Returns the content type of the request, which is "text/plain".
     *
     * @return The content type of the request.
     */
    @Override
    default String getContentType() {
        return "text/plain";
    };
}
