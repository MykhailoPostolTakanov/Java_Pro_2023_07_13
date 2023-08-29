package generics;

public class DifferentClassException extends RuntimeException {
    public DifferentClassException(String errorMessage) {
        super(errorMessage);
    }

    public DifferentClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
