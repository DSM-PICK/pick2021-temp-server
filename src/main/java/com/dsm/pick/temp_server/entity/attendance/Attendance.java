package com.dsm.pick.temp_server.entity.attendance;

import com.dsm.pick.temp_server.entity.check.Check;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity(name = "tbl_attendance")
public class Attendance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4)
    private String teacher;

    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "attendance")
    private Set<Check> checkList = new HashSet<>();

    public void modifyTeacherName(String name) {
        this.teacher = name;
    }

    @Builder
    public Attendance(String teacher, LocalDate date) {
        this.teacher = teacher;
        this.date = date;
    }

}
