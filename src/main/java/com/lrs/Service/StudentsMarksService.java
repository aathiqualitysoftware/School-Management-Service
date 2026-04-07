package com.lrs.Service;

import com.lrs.Dto.MarkEntry;
import com.lrs.Dto.MarkSubmitRequest;
import com.lrs.Entity.Exams;
import com.lrs.exception.ServiceException;

import java.util.List;

public interface StudentsMarksService {
    List<MarkEntry> getMarkEntry(Long classId, Long sectionId, Long examId, Long subjectId) throws ServiceException;
    void submitMarks(MarkSubmitRequest request);

}
