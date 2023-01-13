package com.wissen.service;

import com.wissen.entity.EmployeeAccount;

/**
 * Interface responsible for employee account related things.
 */
public interface EmployeeAccountService {

    /**
     * Method to save employee accounts.
     *
     * @param employeeAccount
     * @return employeeAccount
     */
    public EmployeeAccount saveEmployeeAccount(EmployeeAccount employeeAccount);
}
