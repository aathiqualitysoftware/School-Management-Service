package com.lrs.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "exams")
@Data
public class Exams {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamId")
    private Long id;
    @Column(name = "UniqueExamCode")
    private String uniqueExamCode;
    @Column(name = "AcademicYearId")
    private Long academicYearId;
    @Column(name = "ExamTypeId")
    private Long examTypeId;
    @Column(name = "ClassSubjectId")
    private Long classSubjectId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "StartDate")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EndDate")
    private Date endDate;
}
