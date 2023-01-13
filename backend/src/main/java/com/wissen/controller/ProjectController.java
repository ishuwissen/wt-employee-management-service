package com.wissen.controller;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;
import com.wissen.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<List<Project>> saveProject(@RequestBody @NotEmpty(message = "Input client list cannot be empty.") final List<@Valid ProjectDTO> projects) {
        log.info("START: Saving projects : {}", projects);
        List<Project> savedData = this.projectService.saveProjects(projects);
        log.info("END: Saving projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedData);
    }

    @PostMapping("/projectEmployeeMapping")
    public ResponseEntity<EmployeeProject> saveProjectEmployeeMapping(@RequestParam @NotNull(message = "Project id is null") final int projectId,
                                                                             @RequestParam @NotNull(message = "Project id is null") final int employeeId,
                                                                             @RequestParam @NotNull(message = "DOJ id is null") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate doj,
                                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate dor) {
        log.info("START: Saving projects employee mapping");
        log.info("Project id : {}, Employee id : {}, DOJ : {}, DOR : {} ", projectId, employeeId, doj, dor);
        EmployeeProject savedData = this.projectService.saveProjectEmployeeMapping(projectId, employeeId, doj, dor);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedData);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProject(@RequestParam final String searchString) {
        log.info("START :  Searching project");
        List<Project> projects = this.projectService.searchProjectToClientDetails(searchString);
        log.info("START :  Searching project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(projects);
    }

    @GetMapping
    public ResponseEntity<Project> getProjectById(@RequestParam @NotNull(message = "Project id is null") final int id) {
        log.info("START :  Getting project");
        Project project = this.projectService.getProjectToClientDetailsByProjectId(id);
        log.info("START :  Getting project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(project);
    }

    @GetMapping("/allProjects")
    public ResponseEntity<List<Project>> getAllProject() {
        log.info("START :  Getting all project");
        List<Project> projects = this.projectService.getAllProjects();
        log.info("END :  Getting all project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(projects);
    }

    @GetMapping("/employee")
    @ApiOperation("Get employee's projects")
    public ResponseEntity<List<EmployeeProject>> getEmployeeProjectByEmployee(
            @RequestParam @NotNull(message = "Employee id is null") int empId
    ) {
        log.info("START : Getting employee's projects");
        List<EmployeeProject> employeeProjects = this.projectService.getEmployeeProjectByEmployeeId(empId);
        log.info("END : Getting employee's projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeProjects);
    }
}
