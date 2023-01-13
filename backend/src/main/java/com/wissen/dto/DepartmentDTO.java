package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class DepartmentDTO {

    @NotNull(message = "Department Id can not be null.")
    int depId;

    @NotNull(message = "Department name can not be null.")
    @NotEmpty(message = "Department name can not be null.")
    String depName;

}
