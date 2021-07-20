package com.dsm.pick.temp_server.exception;

import com.dsm.pick.temp_server.error.exception.BusinessException;
import com.dsm.pick.temp_server.error.exception.ErrorCode;

public class StudentNotFoundException extends BusinessException {
    public StudentNotFoundException() {
        super(ErrorCode.STUDENT_NOT_FOUND);
    }
}
