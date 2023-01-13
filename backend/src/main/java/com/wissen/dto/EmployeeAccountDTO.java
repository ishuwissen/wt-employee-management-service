package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class EmployeeAccountDTO {

    @NotEmpty(message = "Pan can not be empty.")
    String pan;

    @NotEmpty(message = "Pan can not be empty.")
    String uan;

    @NotEmpty(message = "Pan can not be empty.")
    String pfNo;
}
