package com.wissen.service;

import com.wissen.entity.Department;

import java.util.List;

/**
 * Interface responsible for department.
 */
public interface DepartmentService {

    /**
     * Method to save departments.
     *
     * @param departments
     * @return departments
     */
    public List<Department> saveDepartments(final List<String> departments);

    /**
     * Method to search departments.
     *
     * @param searchString
     * @return departments
     */
    public List<Department> searchDepartments(final String searchString);

    /**
     * Method to get all departments.
     *
     * @return departments
     */
    public List<Department> getAllDepartments();

    /**
     * Method to get department by id.
     *
     * @param id
     * @return department
     */
    public Department getDepartmentById(int id);

    /**
     * Method to get department by department name.
     *
     * @param name
     * @return department
     */
    public Department getDepartmentByDepName(String name);
}
