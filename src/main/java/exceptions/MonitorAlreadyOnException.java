package exceptions;

// Custom Exception Class for Monitor Already On
public class MonitorAlreadyOnException extends Exception {
    public MonitorAlreadyOnException(String message) {
        super(message);
    }
}