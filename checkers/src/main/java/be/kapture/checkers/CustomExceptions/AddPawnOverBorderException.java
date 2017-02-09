package be.kapture.checkers.CustomExceptions;

public class AddPawnOverBorderException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AddPawnOverBorderException(String message) {
        super(message);

    }

}
