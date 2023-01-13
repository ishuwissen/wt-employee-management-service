package com.wissen.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "Please provide valid skillId")
    @Column(name = "skill_id")
    int skillId;
    @NotBlank(message = "Skill name cannot be empty")
    @Column(name = "skill_name")
    String skillName;
}
