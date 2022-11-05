package com.sotfcaribbean.veterinaria.exception;

public class ExceptionManager extends Exception{
    public ExceptionManager() {
    }

    public ExceptionManager(String message) {
        super(message);
    }

    public ExceptionManager(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionManager(Throwable cause) {
        super(cause);
    }

    public ExceptionManager(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
