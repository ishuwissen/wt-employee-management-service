package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class EmployeeSkillDTO {

    @NotNull(message = "Skill Id can not be null.")
    int skillId;

    @NotNull(message = "Skill name can not be null.")
    @NotEmpty(message = "Skill name can not be empty.")
    String skillName;

    int levels;
}
