package com.FinanceTracker.smartFinancePlatform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Long id;
    private Long userId;
    private String reportType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private String status;
    private LocalDateTime generatedAt;
    private String downloadUrl;
}
