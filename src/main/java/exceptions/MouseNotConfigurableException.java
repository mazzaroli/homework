package exceptions;

// Custom Exception Class for Mouse Not Configurable
public class MouseNotConfigurableException extends Exception {
    public MouseNotConfigurableException(String message) {
        super(message);
    }
}