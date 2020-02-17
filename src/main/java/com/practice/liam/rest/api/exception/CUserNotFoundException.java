package com.practice.liam.rest.api.exception;

public class CUserNotFoundException extends RuntimeException {
    public CUserNotFoundException() {
        super();
    }

    public CUserNotFoundException(String msg) {
        super(msg);
    }

}
