package dev.boxadactle.boxlib.http;

/**
 * Exception thrown when an invalid HTTP request is encountered.
 */
public class InvalidHttpRequestException extends RuntimeException {

    /**
     * Constructs a new InvalidHttpRequestException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidHttpRequestException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidHttpRequestException with the specified cause.
     *
     * @param e the cause
     */
    public InvalidHttpRequestException(Exception e) {
        super(e);
    }

}
