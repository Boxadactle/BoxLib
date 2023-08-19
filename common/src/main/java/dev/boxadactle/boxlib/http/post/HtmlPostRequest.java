package dev.boxadactle.boxlib.http.post;

import dev.boxadactle.boxlib.http.HttpPostRequest;

public interface HtmlPostRequest extends HttpPostRequest {

    @Override
    default String getContentType() {
        return "text/html";
    };
}
