package com.dsm.pick.temp_server.entity.check;

import com.dsm.pick.temp_server.entity.attendance.Attendance;
import com.dsm.pick.temp_server.entity.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CheckRepository extends CrudRepository<Check, Long> {
    Optional<Check> findByAttendanceAndStudentAndPeriodAndCreatedAt(Attendance attendance, Student student, String period, LocalDate createdAt);
    List<Check> findAllByGubunAndCreatedAt(String gubun, LocalDate createdAt);
}
