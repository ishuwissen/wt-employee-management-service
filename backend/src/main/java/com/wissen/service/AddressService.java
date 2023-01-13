package com.wissen.service;

import com.wissen.dto.AddressDTO;
import com.wissen.entity.Address;
import com.wissen.entity.Employee;

import java.util.List;

/**
 * Interface for address service.
 */
public interface AddressService {

    public List<Address> saveAddresses(List<Address> address);

    public List<Address> getAddressByEmployeeId(int empId);

    /**
     * @author Anushka Saxena
     * @description Method to update Address.
     * @param addressDTOList
     * @return List of Address
     */
    public List<Address> updateAddress(List<AddressDTO> addressDTOList);
}
