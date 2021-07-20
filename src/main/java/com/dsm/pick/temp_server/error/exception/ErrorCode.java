package com.dsm.pick.temp_server.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ErrorCode {

    STUDENT_NOT_FOUND(404, "Student not found."),
    CHECK_NOT_FOUND(404, "Check not found."),
    ATTENDANCE_NOT_FOUND(404, "Attendance not found.");

    private int status;
    private String message;
}
