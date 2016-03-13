package com.pardasani.digital.exception;

/**
 * Created by pankajpardasani on 27/02/2016.
 */
public class MediaManagementException extends RuntimeException {

    public MediaManagementException(String message) {
        super(message);
    }

    public MediaManagementException(String message, Throwable t) {
        super(message, t);
    }

    public MediaManagementException(Throwable t) {
        super(t);
    }
}
