package com.chernogorov.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@JsonSerialize
@JsonDeserialize
public class CustomerDto implements Serializable {

    private Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String middleName;
    @NotEmpty
    private String sex;

    private AddressDto registredAddress;
    private AddressDto actualAddress;

}
