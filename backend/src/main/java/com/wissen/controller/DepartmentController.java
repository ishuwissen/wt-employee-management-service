package com.wissen.controller;

import com.wissen.entity.Department;
import com.wissen.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<List<Department> > saveDepartment(@RequestBody @NotEmpty(message = "Department list is empty") final List<String> departments){
        log.info("Starting to save the departments");
        List<Department> savedDepartments = this.departmentService.saveDepartments(departments);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedDepartments);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Department>> searchDepartments(@RequestParam final String department) {
        log.info("START: Getting departments");
        List<Department> departments = this.departmentService.searchDepartments(department);
        log.info("START: Getting departments");
        return ResponseEntity.status(HttpStatus.OK)
                .body(departments);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        log.info("Starting to fetch the departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id){
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }
}
