package com.dsm.pick.temp_server.error;

import com.dsm.pick.temp_server.error.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }

}
