package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.ReportDto;
import com.FinanceTracker.smartFinancePlatform.service.ReportService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<ReportDto> getAllReports() {
        return reportService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable Long id) {
        return reportService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportDto>> getReportsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(reportService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReportDto createReport(@RequestBody ReportDto dto) {
        return mapper.toDto(reportService.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportDto> updateReport(@PathVariable Long id, @RequestBody ReportDto dto) {
        return reportService.findById(id)
                .map(existing -> {
                    existing.setReportType(dto.getReportType());
                    existing.setPeriodStart(dto.getPeriodStart());
                    existing.setPeriodEnd(dto.getPeriodEnd());
                    existing.setStatus(dto.getStatus());
                    existing.setDownloadUrl(dto.getDownloadUrl());
                    if (dto.getUserId() != null) {
                        existing.setUser(mapper.toEntity(dto).getUser());
                    }
                    return mapper.toDto(reportService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
