package com.wissen.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wissen.entity.*;
import com.wissen.entity.Employee;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int emp_id;
    String first_name;
    String gender;
    Date dob;
    String blood_group;
    long primary_phone_number;
    long secondary_phone_number;
    String last_name;
    long work_phone;
    long primary_emergency_contact_number;
    long secondary_emergency_contact_number;
    Date marital_status_date;
    String email;
    Date doj;
    String exp_doj;
    Date exit_date;
    String type;
    String joining_location;
    String status;
    String manager;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="desg_id")
    Designation designation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dep_id")
    Department department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    Role role;
    public EmployeeDTO(Employee employee){

    }
}
