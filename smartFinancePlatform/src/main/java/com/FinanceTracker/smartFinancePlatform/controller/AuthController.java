package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.UsersDto;
import com.FinanceTracker.smartFinancePlatform.model.Role;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.service.RoleService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final DtoMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> register(@RequestBody UsersDto userDto) {
        if (usersService.existsByUsername(userDto.getUsername()) || usersService.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        Users user = mapper.toEntity(userDto);
        if (userDto.getRoleId() != null) {
            Role role = roleService.findById(userDto.getRoleId())
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + userDto.getRoleId()));
            user.setRole(role);
        } else {
            Role defaultRole = roleService.findByName("USER")
                    .orElseGet(() -> roleService.findAll().stream().findFirst()
                            .orElseThrow(() -> new IllegalStateException("No roles are configured in the system")));
            user.setRole(defaultRole);
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users saved = usersService.save(user);
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @GetMapping("/me")
    public ResponseEntity<UsersDto> currentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }
        return usersService.findByUsername(authentication.getName())
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
