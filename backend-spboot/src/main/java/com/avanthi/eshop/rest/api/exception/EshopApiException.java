package com.avanthi.eshop.rest.api.exception;

import org.springframework.http.HttpStatus;

public class EshopApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public EshopApiException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public EshopApiException(String customMessage, HttpStatus status, String message){
        super(customMessage);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
