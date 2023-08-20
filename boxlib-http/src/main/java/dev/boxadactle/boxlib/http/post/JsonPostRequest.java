package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

public interface JsonPostRequest extends HttpPostRequest {

    @Override
    default String getContentType() {
        return "application/json";
    };
}
