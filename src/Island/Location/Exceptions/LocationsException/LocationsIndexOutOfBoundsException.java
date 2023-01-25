package Island.Location.Exceptions.LocationsException;

public class LocationsIndexOutOfBoundsException extends RuntimeException {
    public LocationsIndexOutOfBoundsException() {
    }

    public LocationsIndexOutOfBoundsException(String message) {
        super(message);
    }

    public LocationsIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationsIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
