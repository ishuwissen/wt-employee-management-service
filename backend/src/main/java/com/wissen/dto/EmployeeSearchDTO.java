package com.wissen.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeSearchDTO {

    private String Name;
    private int id;
}
