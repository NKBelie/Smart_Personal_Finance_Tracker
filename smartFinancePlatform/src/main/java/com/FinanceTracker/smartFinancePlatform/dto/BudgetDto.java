package com.FinanceTracker.smartFinancePlatform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {
    private Long id;
    private Long userId;
    private String budgetType;
    private Long categoryId;
    private BigDecimal amount;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private String status;
}
