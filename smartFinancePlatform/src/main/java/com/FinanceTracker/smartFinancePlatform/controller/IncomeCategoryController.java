package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.IncomeCategoryDto;
import com.FinanceTracker.smartFinancePlatform.model.IncomeCategory;
import com.FinanceTracker.smartFinancePlatform.service.IncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/income-categories")
@RequiredArgsConstructor
public class IncomeCategoryController {

    private final IncomeCategoryService incomeCategoryService;
    private final DtoMapper mapper;

    @GetMapping
    public List<IncomeCategoryDto> getAllCategories() {
        return incomeCategoryService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeCategoryDto> getCategoryById(@PathVariable Long id) {
        return incomeCategoryService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public IncomeCategoryDto createCategory(@RequestBody IncomeCategoryDto dto) {
        IncomeCategory category = new IncomeCategory();
        category.setName(dto.getName());
        return mapper.toDto(incomeCategoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeCategoryDto> updateCategory(@PathVariable Long id, @RequestBody IncomeCategoryDto dto) {
        return incomeCategoryService.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    return mapper.toDto(incomeCategoryService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        incomeCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
