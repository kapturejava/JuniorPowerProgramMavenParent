package be.kapture.spinnenweb.exception;

import java.io.IOException;

public class DocumentProcessorException extends RuntimeException {
    public DocumentProcessorException(String message) {
        super(message);
    }

    public DocumentProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}
