package com.target.myretail.model.productapi;

public class InformationUnavailableException extends Exception {

    private static final long serialVersionUID = 1L;

    public InformationUnavailableException() {
        super();
    }

    public InformationUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InformationUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public InformationUnavailableException(String message) {
        super(message);
    }

    public InformationUnavailableException(Throwable cause) {
        super(cause);
    }

}
