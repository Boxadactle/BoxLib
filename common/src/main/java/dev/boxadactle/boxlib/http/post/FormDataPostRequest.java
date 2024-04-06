package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

/**
 * This interface represents a form data POST request.
 * It extends the HttpPostRequest interface.
 */
public interface FormDataPostRequest extends HttpPostRequest<String> {

    /**
     * Returns the content type of the request, which is "application/x-www-form-urlencoded".
     *
     * @return The content type of the request.
     */
    @Override
    default String getContentType() {
        return "application/x-www-form-urlencoded";
    };

}
