package com.wissen.service.impl;

import com.wissen.dto.EmployeeDetailDTO;
import com.wissen.dto.EmployeeSearchDTO;
import com.wissen.entity.*;
import com.wissen.exception.EmployeeNotFoundException;
import com.wissen.repository.*;
import com.wissen.response.*;
import com.wissen.service.AddressService;
import com.wissen.service.EmployeeAccountService;
import com.wissen.service.EmployeeService;
import com.wissen.service.EmployeeSkillService;
import com.wissen.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation class for employee related things.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @Autowired
    private EmployeeAccountService employeeAccountService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeSaveResponse> saveEmployeeDetails(List<EmployeeDetailDTO> employeeDetailDTOList){

        List<EmployeeSaveResponse> employeeSaveResponses = new ArrayList<>();
        employeeDetailDTOList.stream().filter(dto -> Objects.nonNull(dto))
                .forEach(dto -> {
                    EmployeeSaveResponse employeeSaveResponse = new EmployeeSaveResponse();

                    //Saving Employee
                    Employee employee = this.employeeRepository.save(EmployeeUtil.getEmployeeEntity(dto));
                    EmployeeResponse employeeResponse = EmployeeUtil.getEmployeeResponse(employee);
                    employeeSaveResponse.setEmployeeResponse(employeeResponse);

                    //Saving Employee Address
                    if(Objects.nonNull(dto.getAddressDTOList()) && !dto.getAddressDTOList().isEmpty()) {
                        List<Address> addressList = dto.getAddressDTOList().parallelStream().map(addressDTO ->
                                EmployeeUtil.getAddressEntity(addressDTO, employee)).collect(Collectors.toList());
                        List<Address> saveAddresses = this.addressService.saveAddresses(addressList);
                        List<AddressResponse> addressResponseList = EmployeeUtil.getAddressResponseList(saveAddresses);
                        employeeSaveResponse.setAddressResponse(addressResponseList);
                    }

                    //Saving Employee Skill
                    if(Objects.nonNull(dto.getEmployeeSkillDTOList()) && !dto.getEmployeeSkillDTOList().isEmpty()) {
                        List<EmployeeSkill> employeeSkillList = dto.getEmployeeSkillDTOList().parallelStream().map(employeeSkillDTO ->
                                EmployeeUtil.getEmployeeSkillEntity(employeeSkillDTO, employee)).collect(Collectors.toList());
                        List<EmployeeSkill> employeeSkill = this.employeeSkillService
                                .saveEmployeeSkills(employeeSkillList);
                        List<EmployeeSkillResponse> employeeSkillResponseList = EmployeeUtil.getEmployeeSkillResponse(employeeSkill);
                        employeeSaveResponse.setEmployeeSkillResponse(employeeSkillResponseList);
                    }

                    //Saving Employee Account
                    EmployeeAccount employeeAccount = this.employeeAccountService
                            .saveEmployeeAccount(EmployeeUtil.getEmployeeAccountEntity(dto.getEmployeeAccountDTO(), employee));
                    EmployeeAccountResponse employeeAccountResponse = EmployeeUtil.getEmployeeAccountResponse(employeeAccount);
                    employeeSaveResponse.setEmployeeAccountResponse(employeeAccountResponse);

                    employeeSaveResponses.add(employeeSaveResponse);

                });
        return employeeSaveResponses;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeSearchDTO> searchEmployee(String searchString) {
        List<Employee> employees = this.employeeRepository.searchEmployee(searchString);
        return employees.parallelStream().map(employee -> {
            return EmployeeSearchDTO.builder()
                .Name(employee.getFirstName() + " " + employee.getLastName())
                .id(employee.getEmpId())
                .build();})
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getEmployee(int employeeId) {
        return this.employeeRepository.findById(employeeId).get();
    }

}
