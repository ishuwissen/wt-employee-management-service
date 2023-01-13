package com.wissen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addr_id")
    int addrId;
    @Column(name = "flat_no")
    String flatNo;
    String street;
    String pincode;
    @Column(name = "address_type")
    String addressType;
    String city;
    String country;
    String state;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;
}
