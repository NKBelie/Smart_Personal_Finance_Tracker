package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.Budget;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.repository.BudgetRepository;
import com.FinanceTracker.smartFinancePlatform.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public List<Budget> findByUser(Users user) {
        return budgetRepository.findByUser(user);
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public void deleteById(Long id) {
        budgetRepository.deleteById(id);
    }
}
