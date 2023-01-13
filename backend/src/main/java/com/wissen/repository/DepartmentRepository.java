package com.wissen.repository;

import com.wissen.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Department repository class.
 *
 * @author Vishal Tomar
 */
public interface DepartmentRepository  extends JpaRepository<Department, Integer> {

    /**
     * Find department by name.
     *
     * @param name
     * @return department
     */
    public Department findByDepName(String name);

    /**
     * Find department by pattern.
     *
     * @param searchString
     * @return departments
     */
    @Query("SELECT c FROM Department c WHERE c.depName LIKE CONCAT('%',:searchString, '%')")
    public List<Department> getDepartmentByPattern(String searchString);

    /**
     * Find department by name.
     *
     * @param depName
     * @return department
     */
    public Department getDepartmentByDepName(String depName);
}
