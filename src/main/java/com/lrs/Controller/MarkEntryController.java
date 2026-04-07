package com.lrs.Controller;

import com.lrs.Dto.MarkEntry;
import com.lrs.Dto.MarkSubmitRequest;
import com.lrs.Service.ExpenseService;
import com.lrs.Service.StudentsMarksService;
import com.lrs.ServiceImpl.ExpenseServiceImpl;
import com.lrs.ServiceImpl.MarkEntryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/mark-entry")
@RestController
@Slf4j
public class MarkEntryController {
    private StudentsMarksService studentsMarksService;
    private ModelMapper modelMapper;
    MarkEntryServiceImpl service;

    @Autowired
    public MarkEntryController(StudentsMarksService studentsMarksService,
                               ModelMapper modelMapper,
                               MarkEntryServiceImpl service) {
        this.studentsMarksService = studentsMarksService;
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @GetMapping
    public List<MarkEntry> getMarkEntry(
            @RequestParam Long classId,
            @RequestParam Long sectionId,
            @RequestParam Long examId,
            @RequestParam Long subjectId) {

        return service.getMarkEntry(classId, sectionId, examId, subjectId);
    }

    @PostMapping
    public ResponseEntity<?> submitMarks(@RequestBody MarkSubmitRequest request) {
        service.submitMarks(request);
        return ResponseEntity.ok().build();
    }
}
