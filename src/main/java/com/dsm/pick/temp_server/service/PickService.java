package com.dsm.pick.temp_server.service;

import com.dsm.pick.temp_server.dto.CheckResponse;


public interface PickService {
    void modifyTeacherName(String name);
    void checkStudent(String gcn, String isAttendance);
    CheckResponse getStudentList(String gubun);
}
