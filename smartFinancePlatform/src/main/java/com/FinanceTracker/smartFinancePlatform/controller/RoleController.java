package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.RoleDto;
import com.FinanceTracker.smartFinancePlatform.model.Role;
import com.FinanceTracker.smartFinancePlatform.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final DtoMapper mapper;

    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
        return roleService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        return mapper.toDto(roleService.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        return roleService.findById(id)
                .map(existing -> {
                    existing.setName(roleDto.getName());
                    existing.setDescription(roleDto.getDescription());
                    return mapper.toDto(roleService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
