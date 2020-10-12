package edu.wctc.wholesale.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String resource, String parameter, String value) {
        super(String.format("%s not found for %s: %s", resource, parameter, value));
    }

    public ResourceNotFoundException(String resource, String parameter, int value) {
        this(resource, parameter, Integer.toString(value));
    }
}
