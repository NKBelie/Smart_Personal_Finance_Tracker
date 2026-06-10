package com.FinanceTracker.smartFinancePlatform.controller;

import com.FinanceTracker.smartFinancePlatform.dto.DtoMapper;
import com.FinanceTracker.smartFinancePlatform.dto.UsersDto;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.service.RoleService;
import com.FinanceTracker.smartFinancePlatform.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final RoleService roleService;
    private final DtoMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UsersDto> getAllUsers() {
        return usersService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable Long id) {
        return usersService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<UsersDto> searchUser(@RequestParam(required = false) String username,@RequestParam(required = false) String email) {
        if (username != null) {
            return usersService.findByUsername(username)
                    .map(mapper::toDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
        if (email != null) {
            return usersService.findByEmail(email)
                    .map(mapper::toDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public UsersDto createUser(@RequestBody UsersDto userDto) {
        Users user = mapper.toEntity(userDto);
        if (userDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        return mapper.toDto(usersService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable Long id, @RequestBody UsersDto userDto) {
        return usersService.findById(id)
                .map(existing -> {
                    existing.setFullName(userDto.getFullName());
                    existing.setUsername(userDto.getUsername());
                    existing.setEmail(userDto.getEmail());
                    if (userDto.getPassword() != null) {
                        existing.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    }
                    existing.setProfilePictureUrl(userDto.getProfilePictureUrl());
                    existing.setStatus(userDto.getStatus());
                    if (userDto.getRoleId() != null) {
                        roleService.findById(userDto.getRoleId())
                                .ifPresent(existing::setRole);
                    }
                    return mapper.toDto(usersService.save(existing));
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
