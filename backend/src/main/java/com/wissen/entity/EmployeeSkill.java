package com.wissen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_skill")
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_skill_id")
    int employeeSkillId;

    int levels;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "emp_id")
    Employee employee;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "skill_id")
    Skill skill;
}

