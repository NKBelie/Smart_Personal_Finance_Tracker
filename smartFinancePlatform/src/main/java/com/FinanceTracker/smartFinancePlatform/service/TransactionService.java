package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Transaction;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> findAll();
    Optional<Transaction> findById(Long id);
    List<Transaction> findByUser(Users user);
    Transaction save(Transaction transaction);
    void deleteById(Long id);
}
