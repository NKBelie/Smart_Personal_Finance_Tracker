package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.NotificationDto;
import com.FinanceTracker.smartFinancePlatform.service.NotificationService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<NotificationDto> getAllNotifications() {
        return notificationService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable Long id) {
        return notificationService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDto>> getNotificationsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(notificationService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotificationDto createNotification(@RequestBody NotificationDto dto) {
        return mapper.toDto(notificationService.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDto> updateNotification(@PathVariable Long id, @RequestBody NotificationDto dto) {
        return notificationService.findById(id)
                .map(existing -> {
                    existing.setTitle(dto.getTitle());
                    existing.setMessage(dto.getMessage());
                    existing.setNotificationType(dto.getNotificationType());
                    existing.setIsRead(dto.getIsRead());
                    if (dto.getUserId() != null) {
                        existing.setUser(mapper.toEntity(dto).getUser());
                    }
                    return mapper.toDto(notificationService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
