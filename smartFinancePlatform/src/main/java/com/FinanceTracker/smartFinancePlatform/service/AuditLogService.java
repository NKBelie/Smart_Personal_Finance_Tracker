package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.AuditLog;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface AuditLogService {
    List<AuditLog> findAll();
    Optional<AuditLog> findById(Long id);
    List<AuditLog> findByUser(Users user);
    AuditLog save(AuditLog auditLog);
    void deleteById(Long id);
}
