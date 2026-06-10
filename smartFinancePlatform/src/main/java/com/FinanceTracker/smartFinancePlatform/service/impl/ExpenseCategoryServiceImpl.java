package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.ExpenseCategory;
import com.FinanceTracker.smartFinancePlatform.repository.ExpenseCategoryRepository;
import com.FinanceTracker.smartFinancePlatform.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public List<ExpenseCategory> findAll() {
        return expenseCategoryRepository.findAll();
    }

    @Override
    public Optional<ExpenseCategory> findById(Long id) {
        return expenseCategoryRepository.findById(id);
    }

    @Override
    public Optional<ExpenseCategory> findByName(String name) {
        return expenseCategoryRepository.findByName(name);
    }

    @Override
    public ExpenseCategory save(ExpenseCategory category) {
        return expenseCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        expenseCategoryRepository.deleteById(id);
    }
}
