package com.chernogorov.converter;

import com.chernogorov.model.AddressModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.chernogorov.dto.AddressDto;
import com.chernogorov.model.CustomerModel;
import com.chernogorov.dto.CustomerDto;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerDtoConverterTest {

    @InjectMocks
    private CustomerDtoConverter converter;

    @Mock
    private AddressDtoConverter addressDtoConverter;

    @Test
    void checkConvert() {
        CustomerDto dto = genDto();
        CustomerModel model = converter.convert(dto);

        AddressModel actualAddressModel = new AddressModel();
    //    Mockito.when(addressDtoConverter.convert(dto.getActualAddress())).thenReturn(actualAddressModel);
//        assertEquals(actualAddressModel, model.getActualAddress());


        assertNotNull(model);
        assertEquals(dto.getFirstName(), model.getFirstName());
        assertEquals(dto.getLastName(), model.getLastName());
        assertEquals(dto.getMiddleName(), model.getMiddleName());
        assertEquals(dto.getSex(), model.getSex());
    }

    private CustomerDto genDto() {
        CustomerDto dto = new CustomerDto();
        dto.setFirstName("firstName");
        dto.setLastName("lastName");
        dto.setMiddleName("midlName");
        dto.setSex("m");
        dto.setActualAddress(new AddressDto());
        dto.setRegistredAddress(new AddressDto());

        return dto;

    }



}