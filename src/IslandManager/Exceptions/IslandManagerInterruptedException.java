package IslandManager.Exceptions;

public class IslandManagerInterruptedException extends RuntimeException {
    public IslandManagerInterruptedException() {
    }

    public IslandManagerInterruptedException(String message) {
        super(message);
    }

    public IslandManagerInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandManagerInterruptedException(Throwable cause) {
        super(cause);
    }
}
