package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.SavingsGoal;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface SavingsGoalService {
    List<SavingsGoal> findAll();
    Optional<SavingsGoal> findById(Long id);
    List<SavingsGoal> findByUser(Users user);
    SavingsGoal save(SavingsGoal savingsGoal);
    void deleteById(Long id);
}
