package be.kapture.spinnenweb.exception;

public class EnumerationElementParserException extends RuntimeException {
    private final String stringValue;

    public EnumerationElementParserException(String stringValue) {
        super(stringValue + " is geen geldige waarde");

        this.stringValue = stringValue;
    }
}
