package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.dao.ExpenseDao;
import com.engagetech.codingchallenge.entity.Expense;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseServiceTest {

    @InjectMocks
    private ExpenseService expenseService;

    @Mock
    private VatService vatService;

    @Mock
    private ExpenseDao dao;

    @Test
    public void saveExpense() {

        // Given
        BigDecimal grossAmount = BigDecimal.valueOf(100.00);
        Expense expense = new Expense(null, new Date(1), grossAmount, null, "Expense reason");

        BigDecimal vatValue = new BigDecimal(20.00);
        when(vatService.calculateFromGross(grossAmount)).thenReturn(vatValue);

        when(dao.save(expense)).thenReturn(expense);

        // When
        expenseService.save(expense);

        // Then
        assertThat(expense.getVat()).isEqualTo(vatValue);
        verify(vatService).calculateFromGross(grossAmount);
        verify(dao).save(expense);
    }

    @Test
    public void findAll() {

        List<Expense> expenses = new ArrayList<>();
        when(dao.findAll()).thenReturn(expenses);

        List<Expense> result = expenseService.findAll();

        assertThat(result).isSameAs(expenses);
    }
}