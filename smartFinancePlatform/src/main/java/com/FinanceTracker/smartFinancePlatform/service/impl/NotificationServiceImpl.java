package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.Notification;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.repository.NotificationRepository;
import com.FinanceTracker.smartFinancePlatform.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> findByUser(Users user) {
        return notificationRepository.findByUser(user);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
