package be.kapture.spinnenweb.dto;

public class GeneralResult {
    private boolean hasError = false;
    private String errorMessage;

    protected GeneralResult() {}

    public static GeneralResult errorResult(String errorMessage) {
        GeneralResult result = new GeneralResult();
        result.hasError = true;
        result.errorMessage = errorMessage;
        return result;
    }

    public static GeneralResult successResult() {
        return new GeneralResult();
    }

    public boolean isHasError() {
        return hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
