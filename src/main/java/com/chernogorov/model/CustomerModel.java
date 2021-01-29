package com.chernogorov.model;

import lombok.Data;

@Data
public class CustomerModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String sex;
    private AddressModel registredAddress;
    private AddressModel actualAddress;
    private Long registredAddressId;
    private Long actualAddressId;

}
