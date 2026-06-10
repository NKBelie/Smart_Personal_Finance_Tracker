package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.IncomeCategory;

import java.util.List;
import java.util.Optional;

public interface IncomeCategoryService {
    List<IncomeCategory> findAll();
    Optional<IncomeCategory> findById(Long id);
    Optional<IncomeCategory> findByName(String name);
    IncomeCategory save(IncomeCategory category);
    void deleteById(Long id);
}
