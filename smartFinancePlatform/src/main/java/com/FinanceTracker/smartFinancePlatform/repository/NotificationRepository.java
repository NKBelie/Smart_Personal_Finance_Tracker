package com.FinanceTracker.smartFinancePlatform.repository;

import com.FinanceTracker.smartFinancePlatform.model.Notification;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(Users user);
}
