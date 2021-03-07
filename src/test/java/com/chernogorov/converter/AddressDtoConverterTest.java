package com.chernogorov.converter;

import com.chernogorov.dto.AddressDto;
import com.chernogorov.model.AddressModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class AddressDtoConverterTest {


    @InjectMocks
    private AddressDtoConverter converter;

    @Test
    void checkConvert() {

        AddressDto addressDto = getAddressDto();
        AddressModel addressModel = converter.convert(addressDto);

        assertNotNull(addressModel);
        assertEquals(addressDto.getId(), addressModel.getId());
        assertEquals(addressDto.getCity(), addressModel.getCity());
        assertEquals(addressDto.getCountry(), addressModel.getCountry());
        assertEquals(addressDto.getRegion(), addressModel.getRegion());
        assertEquals(addressDto.getStreet(), addressModel.getStreet());
        assertEquals(addressDto.getFlat(), addressModel.getFlat());
        assertEquals(addressDto.getHouse(), addressModel.getHouse());

    }


    private AddressDto getAddressDto() {

        AddressDto dto = new AddressDto();
        dto.setId(1L);
        dto.setCity("Новосибирск");
        dto.setCountry("Россия");
        dto.setRegion("54");
        dto.setStreet("street");
        dto.setFlat("flat");
        dto.setHouse("50");

        return dto;

    }

}