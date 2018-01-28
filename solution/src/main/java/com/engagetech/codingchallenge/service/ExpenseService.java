package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.dao.ExpenseDao;
import com.engagetech.codingchallenge.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ExpenseService {


    @Autowired
    private VatService vatService;

    @Autowired
    private ExpenseDao expenseDao;

    public void save(Expense expense) {

        BigDecimal vat = vatService.calculateFromGross(expense.getAmount());
        expense.setVat(vat);

        expenseDao.save(expense);
    }

    @Transactional(readOnly = true)
    public List<Expense> findAll() {
        return expenseDao.findAll();
    }
}
