package com.chernogorov.repository.Impl;

import com.chernogorov.model.AddressModel;
import com.chernogorov.service.AddressService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
class AddressRepositoryImplTest {

    @Autowired
    private AddressService addressService;


    @Before
    public void setUp() {

    }

    @Test
    @Sql(value = {"/create-table-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/create-table-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void checkAddressMapper() {

        //AddressModel addressModel = addressModelMapper.getById(1L);
        //assertNotNull(addressModel);

        List<AddressModel> addressModels = addressService.getAll();
        assertNotNull(addressModels);

        addressService.save(getAddressModel());

        System.out.println("");
    }


    private AddressModel getAddressModel(){

        AddressModel model = new AddressModel();
        model.setId(3L);
        model.setCity("Барнаул>");
        model.setCountry("Россия");
        model.setRegion("22");
        model.setStreet("street");
        model.setFlat("flat");
        model.setHouse("10");

        return model;

    }

}