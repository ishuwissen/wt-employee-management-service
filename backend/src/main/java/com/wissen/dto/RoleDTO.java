package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RoleDTO {

    @NotNull(message = "Role Id can not be null.")
    int roleId;

    @NotNull(message = "Role name can not be null.")
    @NotNull(message = "Role name not be empty.")
    String roleName;
}
