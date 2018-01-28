package com.engagetech.codingchallenge.web;

import com.engagetech.codingchallenge.entity.Expense;
import com.engagetech.codingchallenge.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/expenses")
public class ExpensesEndpoint {

    @Autowired
    private ExpenseService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {

        service.save(expense);

        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> findAll() {

        return service.findAll();
    }

}
