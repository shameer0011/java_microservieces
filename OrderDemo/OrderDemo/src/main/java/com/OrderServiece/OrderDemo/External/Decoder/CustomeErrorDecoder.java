package com.OrderServiece.OrderDemo.External.Decoder;

import java.io.IOException;

import com.OrderServiece.OrderDemo.Exception.CustomeException;
import com.OrderServiece.OrderDemo.External.Response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomeErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("headersr", response.request().headers());
        log.info(response.request().url(), "urlll");
        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),
                    ErrorResponse.class);
            return new CustomeException(errorResponse.getErrorMessage(),
                    errorResponse.getErrorCode(), response.status());

        } catch (IOException e) {
            return new CustomeException("Internal server error",
                    "INTERNAL SERVER ERROR", 500);
        }
    }

}
