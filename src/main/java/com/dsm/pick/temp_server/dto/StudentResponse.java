package com.dsm.pick.temp_server.dto;

import com.dsm.pick.temp_server.entity.check.Check;
import lombok.Getter;

@Getter
public class StudentResponse {

    private String gcn;

    private String name;

    private String gubun;

    private String period;

    private String isAttendance;

    public StudentResponse(Check check) {
        this.gcn = check.getStudent().getGcn();
        this.name = check.getStudent().getName();
        this.gubun = check.getGubun();
        this.isAttendance = check.getIsAttendance().name();
        this.period = check.getPeriod();
    }

}
