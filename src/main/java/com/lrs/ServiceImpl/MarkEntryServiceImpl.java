package com.lrs.ServiceImpl;

import com.lrs.Dto.MarkEntry;
import com.lrs.Dto.MarkSubmitRequest;
import com.lrs.Entity.StudentMarks;
import com.lrs.Repository.ExpenseRepository;
import com.lrs.Repository.StudentMarksRepository;
import com.lrs.Service.StudentsMarksService;
import com.lrs.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MarkEntryServiceImpl implements StudentsMarksService {
    StudentMarksRepository studentMarksRepository;
    @Autowired
    public MarkEntryServiceImpl(StudentMarksRepository studentMarksRepository){
        this.studentMarksRepository = studentMarksRepository;
    }

    @Override
    public List<MarkEntry> getMarkEntry(Long classId, Long sectionId, Long examId, Long subjectId) {

        List<Object[]> rows = studentMarksRepository.getMarkEntryData(classId, sectionId, examId, subjectId);

        return rows.stream().map(row -> {
            MarkEntry dto = new MarkEntry();

            dto.setId(
                    row[0] != null ? Long.parseLong(row[0].toString()) : null
            );

            dto.setStudentId(
                    row[1] != null ? Long.parseLong(row[1].toString()) : null
            );

            dto.setFirstName(
                    row[2] != null ? row[2].toString() : null
            );

            dto.setRollNumber(
                    row[3] != null ? Integer.parseInt(row[3].toString()) : null
            );

            dto.setMark(
                    row[4] != null ? Integer.parseInt(row[4].toString()) : null
            );

            dto.setGrade(
                    row[5] != null ? row[5].toString() : null
            );

            dto.setStatus(
                    row[6] != null ? row[6].toString() : null
            );

            dto.setAction(
                    row[7] != null ? row[7].toString() : null
            );

            return dto;
        }).toList();
    }

    @Override
    public void submitMarks(MarkSubmitRequest request) {
        List<StudentMarks> list = new ArrayList<>();
        for (MarkEntry m : request.getMarks()) {
            StudentMarks sm;
            // UPDATE
            if (m.getId() != null) {
                sm = studentMarksRepository.findById(m.getId())
                        .orElse(new StudentMarks());
                sm.setUpdatedAt(new Date());
            }
            // SAVE
            else {
                sm = new StudentMarks();
                sm.setCreatedAt(new Date());
            }
            sm.setStudentId(m.getStudentId());
            sm.setClassId(request.getClassId());
            sm.setSectionId(request.getSectionId());
            sm.setExamId(request.getExamId());
            sm.setSubjectId(request.getSubjectId());

            sm.setMark(m.getMark());
            sm.setGrade(m.getGrade());
            sm.setStatus(m.getStatus());
            list.add(sm);
        }
        studentMarksRepository.saveAll(list);
    }
}
