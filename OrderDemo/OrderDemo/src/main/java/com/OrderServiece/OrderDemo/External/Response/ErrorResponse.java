package com.OrderServiece.OrderDemo.External.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
// @NoArgsConstructor
@Builder
@Log4j2
public class ErrorResponse {
    public ErrorResponse() {
        log.info("ErrorResponse class rendering ");
    }

    private String errorCode;
    private String errorMessage;
}
