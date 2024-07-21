package com.gdg_market.app.bible.exception;

public class TooManyRequestsException extends RuntimeException {

    public TooManyRequestsException() {
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

    public TooManyRequestsException(String message, Throwable cause) {
        super(message, cause);
    }
}
