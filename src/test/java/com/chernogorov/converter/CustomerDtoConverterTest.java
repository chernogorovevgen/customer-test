package com.chernogorov.converter;

import com.chernogorov.dto.AddressDto;
import com.chernogorov.dto.CustomerDto;
import com.chernogorov.model.AddressModel;
import com.chernogorov.model.CustomerModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CustomerDtoConverterTest {

    @InjectMocks
    private CustomerDtoConverter converter;

    @Spy
    private AddressDtoConverter addressDtoConverter;


    @Before
    public void setUp() {

    }

    @Test
    void checkConvert() {

        CustomerDto customerDto = getCustomerDto();
        CustomerModel customerModel = converter.convert(customerDto);

        AddressModel actualAddressModel = new AddressModel();
        Mockito.when(addressDtoConverter.convert(customerDto.getActualAddress())).thenReturn(actualAddressModel);
        assertNotNull(addressDtoConverter.convert(customerDto.getActualAddress()));
        assertEquals(actualAddressModel, customerModel.getActualAddress());
        assertEquals(actualAddressModel, addressDtoConverter.convert(customerDto.getActualAddress()));

        assertNotNull(customerModel);
        assertEquals(customerDto.getFirstName(), customerModel.getFirstName());
        assertEquals(customerDto.getLastName(), customerModel.getLastName());
        assertEquals(customerDto.getMiddleName(), customerModel.getMiddleName());
        assertEquals(customerDto.getSex(), customerModel.getSex());
    }

    private CustomerDto getCustomerDto() {
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