package com.wissen.service;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.dto.EmployeeSearchDTO;
import com.wissen.entity.Employee;
import com.wissen.response.EmployeeSaveResponse;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

/**
 * Interface responsible for employee realted things.
 */
public interface EmployeeService {

    /**
     * Method to save/update employee.
     *
     * @param employeeDetailDTOList
     * @return employeeSaveResponse
     */
    public List<EmployeeSaveResponse> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList);

    /**
     * Method to get all employees.
     *
     * @return employees
     */
    public List<Employee> getEmployees();

    /**
     * @author Vishal Tomar
     * Method to search employee.
     * @return List of search employee.
     */
    public List<EmployeeSearchDTO> searchEmployee(String searchString);

    /**
     * Method to get employee by employeeId
     *
     * @param employeeId
     * @return employee
     */
    public Employee getEmployee(int employeeId);

}
