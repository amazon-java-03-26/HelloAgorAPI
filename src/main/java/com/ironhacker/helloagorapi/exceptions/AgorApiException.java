package com.ironhacker.helloagorapi.exceptions;

public class AgorApiException extends RuntimeException {
    public AgorApiException(String message) {
        super("This is an AgorApi Exception: " + message);
    }
}
