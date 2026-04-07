package com.lrs.Dto;

import lombok.Data;

import java.util.List;

@Data
public class MarkSubmitRequest {
    private Long classId;
    private Long sectionId;
    private Long examId;
    private Long subjectId;
    private List<MarkEntry> marks;
}
