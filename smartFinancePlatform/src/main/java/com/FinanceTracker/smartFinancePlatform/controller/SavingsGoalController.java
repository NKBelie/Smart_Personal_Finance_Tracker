package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.SavingsGoalDto;
import com.FinanceTracker.smartFinancePlatform.service.SavingsGoalService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/savings-goals")
@RequiredArgsConstructor
public class SavingsGoalController {

    private final SavingsGoalService savingsGoalService;
    private final UsersService usersService;
    private final DtoMapper mapper;

    @GetMapping
    public List<SavingsGoalDto> getAllSavingsGoals() {
        return savingsGoalService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoalDto> getSavingsGoalById(@PathVariable Long id) {
        return savingsGoalService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavingsGoalDto>> getSavingsGoalsByUser(@PathVariable Long userId) {
        return usersService.findById(userId)
                .map(user -> ResponseEntity.ok(savingsGoalService.findByUser(user).stream().map(mapper::toDto).collect(Collectors.toList())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SavingsGoalDto createSavingsGoal(@RequestBody SavingsGoalDto dto) {
        return mapper.toDto(savingsGoalService.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsGoalDto> updateSavingsGoal(@PathVariable Long id, @RequestBody SavingsGoalDto dto) {
        return savingsGoalService.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setTargetAmount(dto.getTargetAmount());
                    existing.setCurrentAmount(dto.getCurrentAmount());
                    existing.setTargetDate(dto.getTargetDate());
                    existing.setStatus(dto.getStatus());
                    if (dto.getUserId() != null) {
                        existing.setUser(mapper.toEntity(dto).getUser());
                    }
                    return mapper.toDto(savingsGoalService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable Long id) {
        savingsGoalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
