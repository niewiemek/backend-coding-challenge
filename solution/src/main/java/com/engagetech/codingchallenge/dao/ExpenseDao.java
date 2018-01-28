package com.engagetech.codingchallenge.dao;

import com.engagetech.codingchallenge.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {
}
