package com.wissen.entity.key;

import com.wissen.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class EmployeeAccountId implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    Employee employee;
}
