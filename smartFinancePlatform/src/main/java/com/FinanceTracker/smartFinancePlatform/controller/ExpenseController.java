package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.ExpenseDto;
import com.FinanceTracker.smartFinancePlatform.service.ExpenseService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        return expenseService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseDto>> getExpensesByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(expenseService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExpenseDto createExpense(@RequestBody ExpenseDto expenseDto) {
        return mapper.toDto(expenseService.save(mapper.toEntity(expenseDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        return expenseService.findById(id)
                .map(existing -> {
                    existing.setAmount(expenseDto.getAmount());
                    existing.setPaymentMethod(expenseDto.getPaymentMethod());
                    existing.setDescription(expenseDto.getDescription());
                    existing.setDate(expenseDto.getDate());
                    if (expenseDto.getCategoryId() != null || expenseDto.getUserId() != null) {
                        existing.setCategory(mapper.toEntity(expenseDto).getCategory());
                        existing.setUser(mapper.toEntity(expenseDto).getUser());
                    }
                    return mapper.toDto(expenseService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
