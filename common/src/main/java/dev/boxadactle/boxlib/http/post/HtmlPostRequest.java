package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

/**
 * Represents an HTTP POST request with a content type of "text/html".
 * This interface extends the {@link HttpPostRequest} interface.
 */
public interface HtmlPostRequest extends HttpPostRequest<String> {

    /**
     * Returns the content type of the HTTP POST request.
     * 
     * @return the content type as a string, which is "text/html"
     */
    @Override
    default String getContentType() {
        return "text/html";
    };
}
