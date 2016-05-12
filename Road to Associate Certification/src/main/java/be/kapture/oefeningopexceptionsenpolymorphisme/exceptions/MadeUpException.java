package be.kapture.oefeningopexceptionsenpolymorphisme.exceptions;

/**
 * Created by cromhjo on 28/04/2016.
 */
public class MadeUpException extends IllegalArgumentException {

    public MadeUpException() {
    }

    public MadeUpException(String s) {
        super(s);
    }

    public MadeUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public MadeUpException(Throwable cause) {
        super(cause);
    }
}
