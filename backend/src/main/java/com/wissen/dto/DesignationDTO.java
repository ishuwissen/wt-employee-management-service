package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class DesignationDTO {

    @NotNull(message = "Designation Id can not be null.")
    int desgId;

    @NotNull(message = "Designation name can not be null.")
    @NotEmpty(message = "Designation name can not be empty.")
    String desgName;
}
