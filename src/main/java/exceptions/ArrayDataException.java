package exceptions;

public class ArrayDataException extends RuntimeException{
    public ArrayDataException(String errorMessage) {
        super(errorMessage);
    }
    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
