package com.OrderServiece.OrderDemo.Exception;

import lombok.Data;

@Data
public class CustomeException extends RuntimeException {
    private String errorCode;
    private int status;

    public CustomeException(String messag, String errorCode, int status) {

        super(messag);
        this.errorCode = errorCode;
        this.status = status;
    }

}
