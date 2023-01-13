package com.wissen.service.impl;

import com.wissen.dto.AddressDTO;
import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import com.wissen.repository.AddressRepository;
import com.wissen.service.AddressService;
import com.wissen.utils.AddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for address related things.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> updateAddress(List<AddressDTO> addressDTOList) {

        List<Address> addressList = addressDTOList.stream()
                .map(dto -> AddressUtil.getAddress(dto))
                .collect(Collectors.toList());
        return this.addressRepository.saveAll(addressList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> saveAddresses(List<Address> addresses) {
        return this.addressRepository.saveAll(addresses);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> getAddressByEmployeeId(int empId) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        return this.addressRepository.getAddressByEmployee(emp);
    }
}
