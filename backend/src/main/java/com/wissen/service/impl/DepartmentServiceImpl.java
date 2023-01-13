package com.wissen.service.impl;

import com.wissen.entity.Department;
import com.wissen.repository.DepartmentRepository;
import com.wissen.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for department related things.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Department> saveDepartments (final List<String> departments){
        List<Department> departmentEntities = departments.stream()
                .map(department -> getDepartment(department))
                .collect(Collectors.toList());

        return this.departmentRepository.saveAll(departmentEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Department> searchDepartments(String searchString) {
        List<Department> departments = new ArrayList<>();
        departments.addAll(this.departmentRepository.getDepartmentByPattern(searchString));
        return departments;
    }

    private Department getDepartment(final String department) {
        Department departmentEntity = new Department();
        departmentEntity.setDepName(department);

        return departmentEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department getDepartmentByDepName(String name) {
        return departmentRepository.getDepartmentByDepName(name);
    }
}
