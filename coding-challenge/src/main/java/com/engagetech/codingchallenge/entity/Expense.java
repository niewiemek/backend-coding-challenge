package com.engagetech.codingchallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by niewiemek on 25.01.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private Long id;
    private Date date;
    private Double amount;
    private String reason;
}
