package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.IncomeCategory;
import com.FinanceTracker.smartFinancePlatform.repository.IncomeCategoryRepository;
import com.FinanceTracker.smartFinancePlatform.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeCategoryServiceImpl implements IncomeCategoryService {

    private final IncomeCategoryRepository incomeCategoryRepository;

    @Override
    public List<IncomeCategory> findAll() {
        return incomeCategoryRepository.findAll();
    }

    @Override
    public Optional<IncomeCategory> findById(Long id) {
        return incomeCategoryRepository.findById(id);
    }

    @Override
    public Optional<IncomeCategory> findByName(String name) {
        return incomeCategoryRepository.findByName(name);
    }

    @Override
    public IncomeCategory save(IncomeCategory category) {
        return incomeCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        incomeCategoryRepository.deleteById(id);
    }
}
