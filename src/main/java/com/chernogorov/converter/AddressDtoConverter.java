package com.chernogorov.converter;

import org.springframework.stereotype.Component;
import com.chernogorov.dto.AddressDto;
import com.chernogorov.model.AddressModel;

/**
 * Класс конвертер, который конвертирует AddressDto в модельку и обратно
 */

@Component
public class AddressDtoConverter {

    public AddressModel convert(AddressDto dto) {

        AddressModel address = new AddressModel();
        address.setId(dto.getId());
        address.setCountry(dto.getCountry());
        address.setRegion(dto.getRegion());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouse(dto.getHouse());
        address.setFlat(dto.getFlat());
        address.setCreated(dto.getCreated());
        address.setModified(dto.getModified());

        return address;
    }

    public AddressDto convert(AddressModel address){

        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setCountry(address.getCountry());
        dto.setRegion(address.getRegion());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setHouse(address.getHouse());
        dto.setFlat(address.getFlat());
        dto.setCreated(address.getCreated());
        dto.setModified(address.getModified());

        return  dto;
    }

}
