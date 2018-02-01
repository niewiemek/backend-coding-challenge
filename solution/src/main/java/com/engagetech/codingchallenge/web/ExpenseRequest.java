package com.engagetech.codingchallenge.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date date;
    private String reason;
    private BigDecimal amount;
    private BigDecimal vat;
    private String currency;

}
