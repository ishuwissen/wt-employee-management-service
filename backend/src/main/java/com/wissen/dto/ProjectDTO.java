package com.wissen.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProjectDTO {

    @NotNull(message = "Client id is null")
    @Min(value = 1, message = "Please provide valid clientId")
    private int clientId;

    @NotNull(message = "Project name is null")
    @NotEmpty(message = "Project name is empty")
    private String projectName;

    @NotNull(message = "Project location is null")
    @NotEmpty(message = "Project Location is empty")
    private String projectLocation;

    @NotNull(message = "Project lead is null")
    @NotEmpty(message = "Project lead is empty")
    private String projectLead;

    @NotNull(message = "Project type is null")
    @NotEmpty(message = "Project type is empty")
    private String projectType;

    private int projectId;
}
