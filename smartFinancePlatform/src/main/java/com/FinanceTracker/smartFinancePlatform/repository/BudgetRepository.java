package com.FinanceTracker.smartFinancePlatform.repository;

import com.FinanceTracker.smartFinancePlatform.model.Budget;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUser(Users user);
}
