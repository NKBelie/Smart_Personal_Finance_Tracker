package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.TransactionDto;
import com.FinanceTracker.smartFinancePlatform.service.TransactionService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<TransactionDto> getAllTransactions() {
        return transactionService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        return transactionService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(transactionService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransactionDto createTransaction(@RequestBody TransactionDto dto) {
        return mapper.toDto(transactionService.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable Long id, @RequestBody TransactionDto dto) {
        return transactionService.findById(id)
                .map(existing -> {
                    existing.setTransactionType(dto.getTransactionType());
                    existing.setRelatedId(dto.getRelatedId());
                    existing.setRelatedType(dto.getRelatedType());
                    existing.setAmount(dto.getAmount());
                    existing.setCategory(dto.getCategory());
                    existing.setDate(dto.getDate());
                    existing.setDescription(dto.getDescription());
                    if (dto.getUserId() != null) {
                        existing.setUser(mapper.toEntity(dto).getUser());
                    }
                    return mapper.toDto(transactionService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
