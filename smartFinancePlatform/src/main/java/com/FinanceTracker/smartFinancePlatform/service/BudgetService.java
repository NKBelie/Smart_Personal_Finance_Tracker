package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Budget;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    List<Budget> findAll();
    Optional<Budget> findById(Long id);
    List<Budget> findByUser(Users user);
    Budget save(Budget budget);
    void deleteById(Long id);
}
