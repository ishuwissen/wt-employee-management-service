package com.wissen.utils;

import com.wissen.dto.AddressDTO;
import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import com.wissen.service.EmployeeService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Util class for address.
 *
 * @author Anushka Saxena
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressUtil {

    /**
     * @author Anushka Saxena
     * @description Method to get Address entity
     * @param addressDTO
     * @return Address Entity
     */
    public static Address getAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setAddrId(addressDTO.getAddressId());
        address.setFlatNo(addressDTO.getFlatNo());
        address.setAddressType(addressDTO.getAddressType());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setPincode(addressDTO.getPincode());
        address.setStreet(addressDTO.getStreet());
        Employee emp = new Employee();
        emp.setEmpId(addressDTO.getEmployeeId());
        address.setEmployee(emp);
        return address;
    }
}
