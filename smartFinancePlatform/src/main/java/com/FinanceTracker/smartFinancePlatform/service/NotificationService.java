package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Notification;
import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> findAll();
    Optional<Notification> findById(Long id);
    List<Notification> findByUser(Users user);
    Notification save(Notification notification);
    void deleteById(Long id);
}
