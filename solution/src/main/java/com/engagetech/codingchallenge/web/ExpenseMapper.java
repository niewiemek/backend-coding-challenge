package com.engagetech.codingchallenge.web;

import com.engagetech.codingchallenge.common.entity.Expense;
import com.engagetech.codingchallenge.service.CurrencyCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ExpenseMapper {

    @Autowired
    private CurrencyCalculatorService currencyCalculatorService;

    public Expense createExpense(ExpenseRequest expenseRequest) {
        BigDecimal gbpAmount = currencyCalculatorService.convertToGBP(expenseRequest.getAmount(), expenseRequest.getCurrency());
        BigDecimal gbpVat = currencyCalculatorService.convertToGBP(expenseRequest.getVat(), expenseRequest.getCurrency());

        Expense expense = new Expense();
        expense.setDate(expenseRequest.getDate());
        expense.setAmount(gbpAmount);
        expense.setVat(gbpVat);
        expense.setReason(expenseRequest.getReason());

        return expense;
    }
}
