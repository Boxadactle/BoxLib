package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

public interface FormDataPostRequest extends HttpPostRequest {

    @Override
    default String getContentType() {
        return "application/x-www-form-urlencoded";
    };

}
