package collectionsmaps;

public class PathNotEquasException extends RuntimeException {
    public PathNotEquasException(String errorMessage) {
        super(errorMessage);
    }

    public PathNotEquasException(String message, Throwable cause) {
        super(message, cause);
    }
}
