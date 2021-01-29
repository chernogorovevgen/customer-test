package com.chernogorov.model;


import lombok.Data;

import java.util.Date;

@Data
public class AddressModel {

    private Long id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
    private Date created;
    private Date modified;

}
