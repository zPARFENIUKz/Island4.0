package IslandManager.Exceptions;

public class IslandManagerInterrupted extends RuntimeException {
    public IslandManagerInterrupted() {
    }

    public IslandManagerInterrupted(String message) {
        super(message);
    }

    public IslandManagerInterrupted(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandManagerInterrupted(Throwable cause) {
        super(cause);
    }
}
