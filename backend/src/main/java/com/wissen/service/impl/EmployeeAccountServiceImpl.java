package com.wissen.service.impl;

import com.wissen.entity.EmployeeAccount;
import com.wissen.repository.EmployeeAccountRepository;
import com.wissen.service.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation class for employee account related things.
 */
@Service
public class EmployeeAccountServiceImpl implements EmployeeAccountService {

    @Autowired
    private EmployeeAccountRepository employeeAccountRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeAccount saveEmployeeAccount(EmployeeAccount employeeAccount) {
        return this.employeeAccountRepository.save(employeeAccount);
    }
}
