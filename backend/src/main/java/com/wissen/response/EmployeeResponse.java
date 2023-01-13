package com.wissen.response;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Employee response class.
 *
 * @author Vishal Tomar
 */
@Data
@NoArgsConstructor
public class EmployeeResponse {

    int empId;
    String firstName;
    String gender;
    Date dob;
    String bloodGroup;
    long primaryPhoneNumber;
    long secondaryPhoneNumber;
    String lastName;
    long workPhone;
    long primaryEmergencyContactNumber;
    long secondaryEmergencyContactNumber;
    Date maritalStatusDate;
    String email;
    Date doj;
    String expDoj;
    Date exitDate;
    String type;
    String joiningLocation;
    String status;
    String manager;
    Designation designation;
    Department department;
    Role role;
}
