package com.wissen.repository;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for address.
 *
 * @author Vishal Tomar
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    /**
     * Get address by employee.
     *
     * @param employee
     * @return
     */
    List<Address> getAddressByEmployee(Employee employee);
}
