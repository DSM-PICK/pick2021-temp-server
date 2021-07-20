package com.dsm.pick.temp_server.exception;

import com.dsm.pick.temp_server.error.exception.BusinessException;
import com.dsm.pick.temp_server.error.exception.ErrorCode;

public class CheckNotFoundException extends BusinessException {
    public CheckNotFoundException() {
        super(ErrorCode.CHECK_NOT_FOUND);
    }
}
