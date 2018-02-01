package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.Application;
import com.engagetech.codingchallenge.common.entity.Expense;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ExpenseServiceIntegrationTest {

    @Autowired
    private ExpenseService expenseService;

    @Test
    public void saveAndFindExpense() {
        Expense expense = new Expense(null, new Date(1), BigDecimal.valueOf(100.00), BigDecimal.valueOf(20.00), "Test expense");
        expenseService.save(expense);

        Expense expense2 = new Expense(null, new Date(1), BigDecimal.valueOf(120.00), BigDecimal.valueOf(24.00), "Test expense 2");
        expenseService.save(expense2);

        List<Expense> expenses = expenseService.findAll();
        assertThat(expenses).isNotEmpty().hasSize(2).containsExactlyInAnyOrder(expense, expense2);
    }
}
