package com.dsm.pick.temp_server.exception;

import com.dsm.pick.temp_server.error.exception.BusinessException;
import com.dsm.pick.temp_server.error.exception.ErrorCode;

public class AttendanceNotFoundException extends BusinessException {
    public AttendanceNotFoundException() {
        super(ErrorCode.ATTENDANCE_NOT_FOUND);
    }
}
