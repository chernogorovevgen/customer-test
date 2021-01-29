package com.chernogorov.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chernogorov.model.CustomerModel;
import com.chernogorov.dto.CustomerDto;

/**
 * Класс конвертер, который конвертирует CustomerDto в модельку и обратно
 */

@Service
@RequiredArgsConstructor
public class CustomerDtoConverter {

    private final AddressDtoConverter addressDtoConverter;

    public CustomerModel convert(CustomerDto dto) {
        CustomerModel customerModel = new CustomerModel();

        customerModel.setId(dto.getId());
        customerModel.setFirstName(dto.getFirstName());
        customerModel.setLastName(dto.getLastName());
        customerModel.setMiddleName(dto.getMiddleName());
        customerModel.setSex(dto.getSex());

        customerModel.setActualAddress(addressDtoConverter.convert(dto.getActualAddress()));
        customerModel.setRegistredAddress(addressDtoConverter.convert(dto.getRegistredAddress()));

        return customerModel;
    }

    public CustomerDto convert(CustomerModel customer) {

        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setMiddleName(customer.getMiddleName());
        dto.setSex(customer.getSex());

        dto.setActualAddress(addressDtoConverter.convert(customer.getActualAddress()));
        dto.setRegistredAddress(addressDtoConverter.convert(customer.getRegistredAddress()));

        return dto;

    }

}
