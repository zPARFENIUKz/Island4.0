package Config.Exceptions;

public class ConfigurationLoadingException extends RuntimeException {
    public ConfigurationLoadingException() {
    }

    public ConfigurationLoadingException(String message) {
        super(message);
    }

    public ConfigurationLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationLoadingException(Throwable cause) {
        super(cause);
    }
}
