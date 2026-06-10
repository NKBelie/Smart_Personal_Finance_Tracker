package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.BudgetDto;
import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.service.BudgetService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<BudgetDto> getAllBudgets() {
        return budgetService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDto> getBudgetById(@PathVariable Long id) {
        return budgetService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BudgetDto>> getBudgetsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(budgetService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BudgetDto createBudget(@RequestBody BudgetDto budgetDto) {
        return mapper.toDto(budgetService.save(mapper.toEntity(budgetDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetDto> updateBudget(@PathVariable Long id, @RequestBody BudgetDto budgetDto) {
        return budgetService.findById(id)
                .map(existing -> {
                    existing.setBudgetType(budgetDto.getBudgetType());
                    existing.setAmount(budgetDto.getAmount());
                    existing.setPeriodStart(budgetDto.getPeriodStart());
                    existing.setPeriodEnd(budgetDto.getPeriodEnd());
                    existing.setStatus(budgetDto.getStatus());
                    if (budgetDto.getUserId() != null || budgetDto.getCategoryId() != null) {
                        existing.setUser(mapper.toEntity(budgetDto).getUser());
                        existing.setCategory(mapper.toEntity(budgetDto).getCategory());
                    }
                    return mapper.toDto(budgetService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
