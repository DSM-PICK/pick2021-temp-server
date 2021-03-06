package com.dsm.pick.temp_server.service;

import com.dsm.pick.temp_server.dto.CheckResponse;
import com.dsm.pick.temp_server.dto.StudentResponse;
import com.dsm.pick.temp_server.entity.attendance.Attendance;
import com.dsm.pick.temp_server.entity.attendance.AttendanceRepository;
import com.dsm.pick.temp_server.entity.check.Check;
import com.dsm.pick.temp_server.entity.check.CheckRepository;
import com.dsm.pick.temp_server.entity.check.CheckType;
import com.dsm.pick.temp_server.entity.gubun.Gubun;
import com.dsm.pick.temp_server.entity.student.Student;
import com.dsm.pick.temp_server.entity.student.StudentRepository;
import com.dsm.pick.temp_server.exception.AttendanceNotFoundException;
import com.dsm.pick.temp_server.exception.CheckNotFoundException;
import com.dsm.pick.temp_server.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PickServiceImpl implements PickService{

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CheckRepository checkRepository;

    @Override
    public void modifyTeacherName(String name) {
        Attendance attendance = attendanceRepository.findByDate(LocalDate.now())
                .orElseThrow(AttendanceNotFoundException::new);
        attendance.modifyTeacherName(name);
        attendanceRepository.save(attendance);
    }

    @Override
    public void checkStudent(String gcn, String isAttendance, String period) {
        Student student = studentRepository.findByGcn(gcn)
                .orElseThrow(StudentNotFoundException::new);
        Attendance attendance = attendanceRepository.findByDate(LocalDate.now())
                .orElseThrow(AttendanceNotFoundException::new);
        Check check = checkRepository.findByAttendanceAndStudentAndPeriodAndCreatedAt(attendance, student, period, LocalDate.now())
                .orElseThrow(CheckNotFoundException::new);
        check.modifyAttendance(CheckType.valueOf(isAttendance));
        checkRepository.save(check);
    }

    @Override
    public CheckResponse getStudentList(String gubun) {
        List<Check> checkList = checkRepository.findAllByGubunAndCreatedAt(gubun, LocalDate.now());
        Attendance attendance = attendanceRepository.findByDate(LocalDate.now())
                .orElseThrow(AttendanceNotFoundException::new);
        return new CheckResponse(checkList.stream().map(StudentResponse::new).collect(Collectors.toList()),
                attendance.getDate(), attendance.getTeacher());
    }

    @Scheduled(cron = "0 1 0 * * *", zone = "Asia/Seoul")
    public void setCheck() {
        Attendance attendance = Attendance.builder()
                .date(LocalDate.now())
                .teacher("????????????")
                .build();
        attendanceRepository.save(attendance);
        List<Student> students = studentRepository.findAll();
        for(Student student : students) {
            for(Gubun gubun : student.getGubunList()) {
                if(gubun.getGubun().equals("A")) {
                    for(int i = 0; i < 4; i++) {
                        checkRepository.save(
                                Check.builder()
                                        .attendance(attendance)
                                        .student(student)
                                        .gubun(gubun.getGubun())
                                        .isAttendance(CheckType.??????)
                                        .period(String.valueOf(i+1))
                                        .build()
                        );
                    }
                }
                if(gubun.getGubun().equals("B")) {
                    for(int i = 4; i < 6; i++) {
                        checkRepository.save(
                                Check.builder()
                                        .attendance(attendance)
                                        .student(student)
                                        .gubun(gubun.getGubun())
                                        .isAttendance(CheckType.??????)
                                        .period(String.valueOf(i+1))
                                        .build()
                        );
                    }
                }
                if(gubun.getGubun().equals("C")) {
                    for(int i = 6; i < 8; i++) {
                        checkRepository.save(
                                Check.builder()
                                        .attendance(attendance)
                                        .student(student)
                                        .gubun(gubun.getGubun())
                                        .isAttendance(CheckType.??????)
                                        .period(String.valueOf(i+1))
                                        .build()
                        );
                    }
                }
            }
        }
    }

}
