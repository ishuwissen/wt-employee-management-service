package com.wissen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddressDTO {

    int addressId;

    @NotNull(message = "Flat number is null")
    @NotEmpty(message = "Flat number cannot be empty.")
    String flatNo;

    @NotNull(message = "Street is null")
    @NotEmpty(message = "Street cannot be empty.")
    String street;

    @NotNull(message = "Pincode is null")
    @NotEmpty(message = "Pincode cannot be empty.")
    String pincode;

    @NotNull(message = "Employee id is null")
    int employeeId;

    @NotNull(message = "Address Type is null")
    @NotEmpty(message = "Address Type cannot be empty.")
    String addressType;

    @NotNull(message = "City is null")
    @NotEmpty(message = "City cannot be empty.")
    String city;

    @NotNull(message = "Country is null")
    @NotEmpty(message = "Country cannot be empty.")
    String country;

    @NotNull(message = "State is null")
    @NotEmpty(message = "State cannot be empty.")
    String state;
}
