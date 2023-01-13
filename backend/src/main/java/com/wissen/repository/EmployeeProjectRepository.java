package com.wissen.repository;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Employee project repository class.
 */
@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer> {

    /**
     * Find employee project by employee.
     *
     * @param employee
     * @return employeeProjects
     */
    List<EmployeeProject> getEmployeeProjectByEmployee(Employee employee);
}
