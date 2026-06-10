package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.SavingsGoal;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.repository.SavingsGoalRepository;
import com.FinanceTracker.smartFinancePlatform.service.SavingsGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SavingsGoalServiceImpl implements SavingsGoalService {

    private final SavingsGoalRepository savingsGoalRepository;

    @Override
    public List<SavingsGoal> findAll() {
        return savingsGoalRepository.findAll();
    }

    @Override
    public Optional<SavingsGoal> findById(Long id) {
        return savingsGoalRepository.findById(id);
    }

    @Override
    public List<SavingsGoal> findByUser(Users user) {
        return savingsGoalRepository.findByUser(user);
    }

    @Override
    public SavingsGoal save(SavingsGoal savingsGoal) {
        return savingsGoalRepository.save(savingsGoal);
    }

    @Override
    public void deleteById(Long id) {
        savingsGoalRepository.deleteById(id);
    }
}
