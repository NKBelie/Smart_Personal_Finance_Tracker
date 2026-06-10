package com.FinanceTracker.smartFinancePlatform.service;

import com.FinanceTracker.smartFinancePlatform.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Users save(Users user);
    void deleteById(Long id);
}
