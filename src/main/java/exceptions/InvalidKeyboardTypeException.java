package exceptions;

// Custom Exception Class for Invalid Keyboard Type
public class InvalidKeyboardTypeException extends Exception {
    public InvalidKeyboardTypeException(String message) {
        super(message);
    }
}
