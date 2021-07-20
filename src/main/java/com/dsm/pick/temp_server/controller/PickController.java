package com.dsm.pick.temp_server.controller;

import com.dsm.pick.temp_server.dto.CheckResponse;
import com.dsm.pick.temp_server.service.PickService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class PickController {

    private final PickService pickService;

    @PatchMapping("/teacher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyTeacher(@RequestParam(name = "name") String name) {
        pickService.modifyTeacherName(name);
    }

    @PatchMapping("/check")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkStudent(@RequestParam(name = "gcn") String gcn, @RequestParam(name = "is_attendance") String isAttendance) {
        pickService.checkStudent(gcn, isAttendance);
    }

    @GetMapping("/student/{gubun}")
    public CheckResponse getStudentList(@PathVariable("gubun") String gubun) {
        return pickService.getStudentList(gubun);
    }

}
