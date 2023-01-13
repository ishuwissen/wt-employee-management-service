package com.wissen.service.impl;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Client;
import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;
import com.wissen.exception.DataAlreadyExistException;
import com.wissen.repository.EmployeeProjectRepository;
import com.wissen.repository.ProjectRepository;
import com.wissen.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for project related things.
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> saveProjects(List<ProjectDTO> projects) throws DataAlreadyExistException {
        List<Project> projectEntities = projects.parallelStream()
                .map(project -> getProject(project))
                .collect(Collectors.toList());

        if(validateProjectSaveRequest(projectEntities)) {
            return this.projectRepository.saveAll(projectEntities);
        }
        return null;
    }

    /**
     * If request is for insert then check whether combination of projectName, projectLocation, projectType and clientId
     * is present then throw DataAlreadyExistException else return true. If request is for insert then check whether
     * combination of projectName, projectLocation, projectType, clientId and projectLead is present then throw
     * DataAlreadyExistException else return true.
     *
     * @param projects
     * @return validate
     * @throws DataAlreadyExistException
     * @autor Vishal Tomar
     */
    private boolean validateProjectSaveRequest(List<Project> projects) throws DataAlreadyExistException {
        projects.stream().forEach(project -> {
            if(project.getProjectId() == 0 && projectRepository.isExistsForInsert(project.getProjectName(),
                    project.getProjectLocation(), project.getProjectType(), project.getClient().getClientId())) {
                log.error("This Project details already present : " + project.toString());
                throw new DataAlreadyExistException("This Project details already present : " + project.toString());
            } else if(projectRepository.isExistsForUpdate(project.getProjectName(),
                    project.getProjectLocation(), project.getProjectType(), project.getClient().getClientId(),
                    project.getProjectLead())) {
                log.error("This Project details already present : " + project.toString());
                throw new DataAlreadyExistException("This Project details already present : " + project.toString());
            }
        });

        return Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeProject saveProjectEmployeeMapping(int projectId, int employeeId, final LocalDate doj, final LocalDate dor) {
        final EmployeeProject employeeProject = new EmployeeProject();

        Project project = new Project();
        project.setProjectId(projectId);
        Employee employee = new Employee();
        employee.setEmpId(employeeId);

        employeeProject.setProject(project);
        employeeProject.setEmployee(employee);

        employeeProject.setDojOnboarding(doj);
        employeeProject.setDorOnboarding(dor);
        return this.employeeProjectRepository.save(employeeProject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> searchProjectToClientDetails(String searchString) {
        return this.projectRepository.getProjectToClientDetails(searchString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProjectToClientDetailsByProjectId(int projectId) {
        return this.projectRepository.getProjectToClientDetailsByProjectId(projectId);
    }

    /**
     * @author Vishal Tomar
     * @description Method to fetch all projects.
     * @return List of project.
     */
    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeProject> getEmployeeProjectByEmployeeId(int empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        return this.employeeProjectRepository.getEmployeeProjectByEmployee(employee);
    }

    private Project getProject(final ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectId(projectDTO.getProjectId());
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectLocation(projectDTO.getProjectLocation());
        project.setProjectLead(projectDTO.getProjectLead());
        project.setProjectType(projectDTO.getProjectType());
        Client client = new Client();
        client.setClientId(projectDTO.getClientId());
        project.setClient(client);
        return project;
    }
}
