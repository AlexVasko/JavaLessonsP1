package com.javalesson.exceptionhandling;

public class InvalidInputException extends RuntimeException {


    public InvalidInputException(){super();}

    public InvalidInputException(String message){super(message);}

    public InvalidInputException(String message, Throwable e){super(message,e);}
}
