package Island.Location.Exceptions.LocationException;

public class LocationNullPointerException extends RuntimeException {
    public LocationNullPointerException() {
    }

    public LocationNullPointerException(String message) {
        super(message);
    }

    public LocationNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationNullPointerException(Throwable cause) {
        super(cause);
    }
}
