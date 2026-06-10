package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Report;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    List<Report> findAll();
    Optional<Report> findById(Long id);
    List<Report> findByUser(Users user);
    Report save(Report report);
    void deleteById(Long id);
}
