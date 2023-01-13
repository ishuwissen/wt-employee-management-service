package com.wissen.entity;

import com.wissen.entity.key.EmployeeAccountId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_account")
public class EmployeeAccount {
    @EmbeddedId
    EmployeeAccountId employeeAccountId;
    String pan;
    String uan;
    @Column(name = "pf_no")
    String pfNo;
}
