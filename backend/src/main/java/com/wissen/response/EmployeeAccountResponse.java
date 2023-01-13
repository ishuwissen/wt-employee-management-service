package com.wissen.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee account response class.
 *
 * @author Vishal Tomar
 */
@Data
@NoArgsConstructor
public class EmployeeAccountResponse {

    String pan;
    String uan;
    String pfNo;
    int empId;
}
