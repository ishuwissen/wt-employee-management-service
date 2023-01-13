package com.wissen.repository;

import com.wissen.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Employee repository class.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT('%',:searchString, '%') OR e.lastName LIKE CONCAT('%',:searchString, '%')")
    public List<Employee> searchEmployee(String searchString);
}
