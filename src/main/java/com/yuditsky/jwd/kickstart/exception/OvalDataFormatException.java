package com.yuditsky.jwd.kickstart.exception;

public class OvalDataFormatException extends Exception {
    public OvalDataFormatException() {
        super();
    }

    public OvalDataFormatException(String message) {
        super(message);
    }

    public OvalDataFormatException(Exception e) {
        super(e);
    }

    public OvalDataFormatException(String message, Exception e) {
        super(message, e);
    }
}
