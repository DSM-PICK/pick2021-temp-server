package com.dsm.pick.temp_server.entity.attendance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    Optional<Attendance> findByDate(LocalDate date);
}
