package com.lrs.Repository;

import com.lrs.Entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {

    @Query(value = """
            SELECT  sm.id AS id, 
                               s.studentId AS studentId,
                               s.FirstName AS firstName,
                               s.RollNumber AS rollNumber,
                sm.mark AS mark,
                sm.grade AS grade,
                sm.status AS status,
                CASE 
                    WHEN sm.id IS NOT NULL THEN 'UPDATE'
                    ELSE 'SUBMIT'
                END AS action
            FROM students s
            LEFT JOIN student_marks sm 
                ON s.StudentId = sm.student_id
                AND sm.class_id = :classId
                AND sm.section_id = :sectionId
                AND sm.exam_id = :examId
                AND sm.subject_id = :subjectId
            WHERE s.ClassId = :classId
              AND s.SectionId = :sectionId
            ORDER BY s.RollNumber
            """, nativeQuery = true)
    List<Object[]> getMarkEntryData(
            @Param("classId") Long classId,
            @Param("sectionId") Long sectionId,
            @Param("examId") Long examId,
            @Param("subjectId") Long subjectId
    );
}