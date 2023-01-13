package com.wissen.dto;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeAccount;
import com.wissen.entity.EmployeeSkill;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDetailDTO {

    int employeeId;

    @NotNull(message = "First name is null")
    @NotEmpty(message = "first name cannot be empty.")
    private String firstName;

    @NotNull(message = "gender is null")
    @NotEmpty(message = "Gender cannot be empty.")
    private String gender;

    @NotNull(message = "Date of birth is null")
    private Date dob;

    @NotNull(message = "Blood group is null")
    @NotEmpty(message = "Blood group cannot be empty.")
    private String bloodGroup;

    @NotNull(message = "primary phone number is null")
    private long primaryPhoneNumber;

    private long secondaryPhoneNumber;

    @NotNull(message = "Last name is null")
    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;

    private long workPhone;

    @NotNull(message = "primary emergency number is null")
    private long primaryEmergencyContactNumber;

    private long secondaryEmergencyContactNumber;

    private Date maritalStatusDate;

    @NotNull(message = "Email is null")
    @NotEmpty(message = "Email cannot be empty.")
    private String email;

    @NotNull(message = "Date of joining is null")
    private Date doj;

    @NotNull(message = "Experience till date if joining is null")
    @NotEmpty(message = "Experience till date if joining cannot be empty.")
    private String expDoj;

    private Date exitDate;

    @NotNull(message = "Type  is null")
    @NotEmpty(message = "Type cannot be empty.")
    private String type;

    @NotNull(message = "Joining location is null")
    @NotEmpty(message = "Joining location cannot be empty.")
    private String joiningLocation;

    @NotNull(message = "Status is null")
    @NotEmpty(message = "Status cannot be empty.")
    private String status;

    @NotNull(message = "Manager is null")
    @NotEmpty(message = "Manager cannot be empty.")
    private String manager;

    private DepartmentDTO departmentDTO;
    private DesignationDTO designationDTO;
    private RoleDTO roleDTO;
    private List<AddressDTO> addressDTOList;
    private List<EmployeeSkillDTO> employeeSkillDTOList;
    private EmployeeAccountDTO employeeAccountDTO;

}
