package com.dsm.pick.temp_server.entity.student;

import com.dsm.pick.temp_server.entity.check.Check;
import com.dsm.pick.temp_server.entity.gubun.Gubun;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity(name = "tbl_student")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4)
    private String gcn;

    @Column(length = 4)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private Set<Check> checkList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private Set<Gubun> gubunList = new HashSet<>();

    @Builder
    public Student(String gcn, String name) {
        this.gcn = gcn;
        this.name = name;
    }

}
