package org.aadi.openAPI_Demo.exception;

public class MovieIdMismatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieIdMismatchException() {
    }

    public MovieIdMismatchException(String message) {
        super(message);
    }

    public MovieIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieIdMismatchException(Throwable cause) {
        super(cause);
    }

    public MovieIdMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}