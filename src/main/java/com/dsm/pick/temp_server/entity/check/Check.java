package com.dsm.pick.temp_server.entity.check;

import com.dsm.pick.temp_server.entity.attendance.Attendance;
import com.dsm.pick.temp_server.entity.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_check")
public class Check {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CheckType isAttendance;

    @Column(length = 1)
    private String gubun;

    @Column(length = 1)
    private String period;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;

    public void modifyAttendance(CheckType isAttendance) {
        this.isAttendance = isAttendance;
    }

}
