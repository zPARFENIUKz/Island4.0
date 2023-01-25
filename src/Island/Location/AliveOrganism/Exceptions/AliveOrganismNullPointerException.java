package Island.Location.AliveOrganism.Exceptions;

public class AliveOrganismNullPointerException extends RuntimeException {
    public AliveOrganismNullPointerException() {
    }

    public AliveOrganismNullPointerException(String message) {
        super(message);
    }

    public AliveOrganismNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliveOrganismNullPointerException(Throwable cause) {
        super(cause);
    }
}
