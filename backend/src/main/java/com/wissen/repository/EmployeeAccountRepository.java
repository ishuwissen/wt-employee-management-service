package com.wissen.repository;

import com.wissen.entity.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee account repository class.
 */
@Repository
public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Integer> {
}
