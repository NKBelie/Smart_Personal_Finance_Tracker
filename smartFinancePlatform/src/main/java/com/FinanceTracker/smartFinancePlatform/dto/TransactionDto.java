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
public class TransactionDto {
    private Long id;
    private Long userId;
    private String transactionType;
    private Long relatedId;
    private String relatedType;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String description;
}
