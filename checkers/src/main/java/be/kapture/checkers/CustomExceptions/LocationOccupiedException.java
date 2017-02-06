package be.kapture.checkers.CustomExceptions;

public class LocationOccupiedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LocationOccupiedException(String message) {
        super(message);

    }

}
