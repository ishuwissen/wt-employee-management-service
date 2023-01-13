package com.wissen.controller;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.dto.EmployeeSearchDTO;
import com.wissen.entity.Employee;
import com.wissen.helper.ExcelHelper;
import com.wissen.response.EmployeeSaveResponse;
import com.wissen.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/saveEmployeeDetails")
    @ApiOperation("Saves the details of an Employee")
    public ResponseEntity<List<EmployeeSaveResponse>> saveEmployeeDetails(@RequestBody @NotEmpty(message = "Details list is empty") final List<EmployeeDetailDTO> employeeDetails){
        List<EmployeeSaveResponse> employeeSaveResponses = this.service.saveEmployeeDetails(employeeDetails);

        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeSaveResponses);
    }

    @GetMapping("/employees")
    @ApiOperation("Get all employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        log.info("START : Getting all employees");
        List<Employee> employees = this.service.getEmployees();
        log.info("END : Getting all employees");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employees);
    }

    /**
     * @autor Vishal Tomar
     * @description Method to search employee.
     * @param searchString
     * @return list of employeeSearch dto
     */
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeSearchDTO> > searchEmployee(@RequestParam final String searchString) {
        log.info("START : Searching all employees");
        List<EmployeeSearchDTO> employeesSearchDTOs = this.service.searchEmployee(searchString);
        log.info("END : Searching all employees");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeesSearchDTOs);
    }
}