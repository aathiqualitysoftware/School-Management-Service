package com.lrs.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data

public class ExpenseUpdate {
    private Long id;
    private String name;
    private Integer expenseHeadId;
    private String invoiceNumber;
    private Date date;
    private BigDecimal amount;
    private String description;
}
