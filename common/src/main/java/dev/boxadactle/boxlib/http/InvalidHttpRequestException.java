package dev.boxadactle.boxlib.http;

public class InvalidHttpRequestException extends RuntimeException {

    public InvalidHttpRequestException(String message) {
        super(message);
    }

    public InvalidHttpRequestException(Exception e) {
        super(e);
    }

}
