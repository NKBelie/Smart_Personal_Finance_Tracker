package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Income;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface IncomeService {
    List<Income> findAll();
    Optional<Income> findById(Long id);
    List<Income> findByUser(Users user);
    Income save(Income income);
    void deleteById(Long id);
}
