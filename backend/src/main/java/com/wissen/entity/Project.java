package com.wissen.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    int projectId;
    @Column(name = "project_name")
    String projectName;
    @Column(name = "project_location")
    String projectLocation;
    @Column(name = "project_lead")
    String projectLead;
    @Column(name = "project_type")
    String projectType;
    @OneToOne
    @JoinColumn(name="client_id")
    Client client;
}