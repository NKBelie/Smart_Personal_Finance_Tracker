package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.ExpenseCategoryDto;
import com.FinanceTracker.smartFinancePlatform.model.ExpenseCategory;
import com.FinanceTracker.smartFinancePlatform.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expense-categories")
@RequiredArgsConstructor
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;
    private final DtoMapper mapper;

    @GetMapping
    public List<ExpenseCategoryDto> getAllCategories() {
        return expenseCategoryService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDto> getCategoryById(@PathVariable Long id) {
        return expenseCategoryService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExpenseCategoryDto createCategory(@RequestBody ExpenseCategoryDto dto) {
        ExpenseCategory category = new ExpenseCategory();
        category.setName(dto.getName());
        return mapper.toDto(expenseCategoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDto> updateCategory(@PathVariable Long id, @RequestBody ExpenseCategoryDto dto) {
        return expenseCategoryService.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    return mapper.toDto(expenseCategoryService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        expenseCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
