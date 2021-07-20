package com.dsm.pick.temp_server.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class CheckResponse {

    List<StudentResponse> studentResponseList;

    private LocalDate date;

    private String teacher;

    public CheckResponse(List<StudentResponse> studentResponses, LocalDate date, String teacher) {
        this.studentResponseList = studentResponses;
        this.date = date;
        this.teacher = teacher;
    }

}
