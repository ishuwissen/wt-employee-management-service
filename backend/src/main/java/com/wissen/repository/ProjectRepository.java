package com.wissen.repository;

import com.wissen.entity.Client;
import com.wissen.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project repository class.
 */
@Repository
public interface ProjectRepository  extends JpaRepository<Project, Integer> {

    @Query("select p from Project p inner join Client c on(p.client.clientId=c.clientId) where "
            + "p.projectName LIKE CONCAT('%',:projectName,'%')")
    public List<Project>  getProjectToClientDetails(final String projectName);

    @Query("select p from Project p inner join Client c on(p.client.clientId=c.clientId) where "
            + "p.projectId=:projectId")
    public Project getProjectToClientDetailsByProjectId(final int projectId);

    @Query("SELECT CASE WHEN count(p) > 0 THEN true ELSE false END FROM Project p where UPPER(p.projectName) = UPPER(:projectName) AND "
            + "UPPER(p.projectLocation) = UPPER(:projectLocation) AND UPPER(p.projectType) = UPPER(:projectType) AND p.client.clientId = :clientId")
    public boolean isExistsForInsert(String projectName, String projectLocation, String projectType, int clientId);

    @Query("SELECT CASE WHEN count(p) > 0 THEN true ELSE false END FROM Project p where UPPER(p.projectName) = UPPER(:projectName) AND "
            + "UPPER(p.projectLocation) = UPPER(:projectLocation) AND UPPER(p.projectType) = UPPER(:projectType) AND p.client.clientId = :clientId "
    + "AND UPPER(p.projectLead) = UPPER(:projectLead)")
    public boolean isExistsForUpdate(String projectName, String projectLocation, String projectType, int clientId, String projectLead);
}
