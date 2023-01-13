package com.wissen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    int empId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "gender")
    String gender;

    @Column(name = "dob")
    Date dob;

    @Column(name = "blood_group")
    String bloodGroup;

    @Column(name = "primary_phone_number")
    long primaryPhoneNumber;

    @Column(name = "secondary_phone_number")
    long secondaryPhoneNumber;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "work_phone")
    long workPhone;

    @Column(name = "primary_emergency_contact_number")
    long primaryEmergencyContactNumber;

    @Column(name = "secondary_emergency_contact_number")
    long secondaryEmergencyContactNumber;

    @Column(name = "marital_status_date")
    Date maritalStatusDate;

    @Column(name = "email")
    String email;

    @Column(name = "doj")
    Date doj;

    @Column(name = "exp_doj")
    String expDoj;

    @Column(name = "exit_date")
    Date exitDate;

    @Column(name = "type")
    String type;

    @Column(name = "joining_location")
    String joiningLocation;

    @Column(name = "status")
    String status;

    @Column(name = "manager")
    String manager;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="desg_id")
    Designation designation;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="dep_id")
    Department department;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="role_id")
    Role role;
}
