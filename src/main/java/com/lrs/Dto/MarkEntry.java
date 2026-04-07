package com.lrs.Dto;
import lombok.Data;
@Data
public class MarkEntry {
    private Long id;
    private Long studentId;
    private String firstName;
    private Integer rollNumber;

    private Integer mark;
    private String grade;
    private String status;

    private String action; // SAVE / UPDATE
}