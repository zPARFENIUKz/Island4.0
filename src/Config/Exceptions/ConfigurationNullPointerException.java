package Config.Exceptions;

public class ConfigurationNullPointerException extends RuntimeException {
    public ConfigurationNullPointerException() {
    }

    public ConfigurationNullPointerException(String message) {
        super(message);
    }

    public ConfigurationNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationNullPointerException(Throwable cause) {
        super(cause);
    }
}
