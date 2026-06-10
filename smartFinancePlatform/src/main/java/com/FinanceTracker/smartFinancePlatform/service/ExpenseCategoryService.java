package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.ExpenseCategory;

import java.util.List;
import java.util.Optional;

public interface ExpenseCategoryService {
    List<ExpenseCategory> findAll();
    Optional<ExpenseCategory> findById(Long id);
    Optional<ExpenseCategory> findByName(String name);
    ExpenseCategory save(ExpenseCategory category);
    void deleteById(Long id);
}
