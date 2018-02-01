package com.engagetech.codingchallenge.web;

import com.engagetech.codingchallenge.common.entity.Expense;
import com.engagetech.codingchallenge.service.CurrencyCalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseMapperTest {

    @InjectMocks
    private ExpenseMapper mapper;

    @Mock
    private CurrencyCalculatorService currencyCalculatorService;

    @Test
    public void createExpense() throws Exception {

        ExpenseRequest expenseRequest = new ExpenseRequest();
        expenseRequest.setReason("Test reason...");
        expenseRequest.setAmount(BigDecimal.TEN);
        expenseRequest.setVat(BigDecimal.ONE);
        expenseRequest.setCurrency("EUR");
        expenseRequest.setDate(new Date());

        when(currencyCalculatorService.convertToGBP(BigDecimal.TEN, "EUR")).thenReturn(BigDecimal.valueOf(20));
        when(currencyCalculatorService.convertToGBP(BigDecimal.ONE, "EUR")).thenReturn(BigDecimal.valueOf(2));

        Expense expense = mapper.createExpense(expenseRequest);

        assertThat(expense).isNotNull();
        assertThat(expense.getDate()).isInSameDayAs(expenseRequest.getDate());
        assertThat(expense.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(20));
        assertThat(expense.getReason()).isEqualTo(expenseRequest.getReason());
    }
}