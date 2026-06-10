package com.FinanceTracker.smartFinancePlatform.repository;

import com.FinanceTracker.smartFinancePlatform.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
