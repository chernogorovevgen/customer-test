package com.chernogorov.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonSerialize
@JsonDeserialize
public class AddressDto implements Serializable {

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
