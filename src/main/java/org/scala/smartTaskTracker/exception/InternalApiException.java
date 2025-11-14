package org.scala.smartTaskTracker.exception;

import org.apache.logging.log4j.util.InternalApi;

public class InternalApiException extends Exception {
    public InternalApiException(String message) {
        super(message);
    }

    public InternalApiException() { super(); }

    public InternalApiException(String message, Throwable cause) { super(message, cause); }
}
