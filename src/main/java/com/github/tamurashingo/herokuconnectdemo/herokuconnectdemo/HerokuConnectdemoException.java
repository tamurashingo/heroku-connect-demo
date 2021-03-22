package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo;

public class HerokuConnectdemoException extends Exception {

    private static final long serialVersionUID = 1L;

    public HerokuConnectdemoException(String message) {
        super(message);
    }

    public HerokuConnectdemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public HerokuConnectdemoException(Throwable cause) {
        super(cause);
    }
}
