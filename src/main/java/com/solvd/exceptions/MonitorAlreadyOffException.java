package com.solvd.exceptions;

// Custom Exception Class for Monitor Already Off
public class MonitorAlreadyOffException extends Exception {
    public MonitorAlreadyOffException(String message) {
        super(message);
    }
}