package com.FinanceTracker.smartFinancePlatform.repository;

import com.FinanceTracker.smartFinancePlatform.model.SavingsGoal;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {
    List<SavingsGoal> findByUser(Users user);
}
