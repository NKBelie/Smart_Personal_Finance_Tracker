package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.AuditLogDto;
import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.service.AuditLogService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<AuditLogDto> getAllAuditLogs() {
        return auditLogService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDto> getAuditLogById(@PathVariable Long id) {
        return auditLogService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLogDto>> getAuditLogsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(auditLogService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AuditLogDto createAuditLog(@RequestBody AuditLogDto dto) {
        return mapper.toDto(auditLogService.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLogDto> updateAuditLog(@PathVariable Long id, @RequestBody AuditLogDto dto) {
        return auditLogService.findById(id)
                .map(existing -> {
                    existing.setEventType(dto.getEventType());
                    existing.setEventDetails(dto.getEventDetails());
                    existing.setIpAddress(dto.getIpAddress());
                    if (dto.getUserId() != null) {
                        existing.setUser(mapper.toEntity(dto).getUser());
                    }
                    return mapper.toDto(auditLogService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLog(@PathVariable Long id) {
        auditLogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
