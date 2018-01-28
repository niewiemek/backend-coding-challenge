package com.engagetech.codingchallenge.web;

import com.engagetech.codingchallenge.entity.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by niewiemek on 25.01.2018.
 */
@RestController
@RequestMapping("/app/expenses")
public class ExpensesEndpoint {


    private static List<Expense> expenses = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {

        expense.setId(new Date().getTime());
        expenses.add(expense);

        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> findAll() {

        return expenses;
    }

}
