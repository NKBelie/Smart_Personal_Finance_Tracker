package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.IncomeDto;
import com.FinanceTracker.smartFinancePlatform.service.IncomeService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<IncomeDto> getAllIncomes() {
        return incomeService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDto> getIncomeById(@PathVariable Long id) {
        return incomeService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeDto>> getIncomesByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(incomeService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public IncomeDto createIncome(@RequestBody IncomeDto incomeDto) {
        return mapper.toDto(incomeService.save(mapper.toEntity(incomeDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDto> updateIncome(@PathVariable Long id, @RequestBody IncomeDto incomeDto) {
        return incomeService.findById(id)
                .map(existing -> {
                    IncomeDto updatedDto = incomeDto;
                    existing.setAmount(updatedDto.getAmount());
                    existing.setSource(updatedDto.getSource());
                    existing.setDescription(updatedDto.getDescription());
                    existing.setDate(updatedDto.getDate());
                    if (updatedDto.getCategoryId() != null || updatedDto.getUserId() != null) {
                        existing.setCategory(mapper.toEntity(updatedDto).getCategory());
                        existing.setUser(mapper.toEntity(updatedDto).getUser());
                    }
                    return mapper.toDto(incomeService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
