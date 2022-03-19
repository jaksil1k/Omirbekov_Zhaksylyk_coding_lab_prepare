package com.company.exception;

public class ItemException extends Exception{
    public ItemException() {

    }

    public ItemException(String message){
        super(message);
    }

    public ItemException(String message, Throwable cause){
        super(message, cause);
    }
}
