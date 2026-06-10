package com.FinanceTracker.smartFinancePlatform.repository;

import com.FinanceTracker.smartFinancePlatform.model.AuditLog;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUser(Users user);
}
