package IslandManager.Exceptions;

public class IslandManagerSpawnAliveOrganismException extends RuntimeException {
    public IslandManagerSpawnAliveOrganismException() {
    }

    public IslandManagerSpawnAliveOrganismException(String message) {
        super(message);
    }

    public IslandManagerSpawnAliveOrganismException(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandManagerSpawnAliveOrganismException(Throwable cause) {
        super(cause);
    }
}
