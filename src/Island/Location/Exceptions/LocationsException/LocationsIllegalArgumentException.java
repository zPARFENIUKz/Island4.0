package Island.Location.Exceptions.LocationsException;

public class LocationsIllegalArgumentException extends RuntimeException {
    public LocationsIllegalArgumentException() {
    }

    public LocationsIllegalArgumentException(String message) {
        super(message);
    }

    public LocationsIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationsIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
