package com.chernogorov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.chernogorov.converter.CustomerDtoConverter;
import com.chernogorov.dto.CustomerDto;
import com.chernogorov.model.CustomerModel;
import com.chernogorov.service.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер Rest запросов для Customer
 */

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDtoConverter customerDtoConverter;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable("id") Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CustomerModel customerModel = customerService.findById(id);

        if (customerModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerDtoConverter.convert(customerModel), HttpStatus.OK);
    }

    @GetMapping(value = "", params = {"firstname"})
    public ResponseEntity<List<CustomerDto>> findByFirstname(@RequestParam(required = false) String firstname) {

        HttpHeaders headers = new HttpHeaders();

        if (firstname == null || firstname.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<CustomerModel> customerModelList = customerService.findByFirstname(firstname);
        List<CustomerDto> customerDtoList = new ArrayList<>(customerModelList.size());

        customerModelList.forEach(customerModel -> {
            customerDtoList.add(customerDtoConverter.convert(customerModel));
        });

        return new ResponseEntity<>(customerDtoList, headers, HttpStatus.OK);

    }

    @GetMapping(value = "", params = {"lastname"})
    public ResponseEntity<List<CustomerDto>> findByLastname(@RequestParam(required = false) String lastname) {

        if (lastname == null || lastname.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<CustomerModel> customerModelList = customerService.findByLastname(lastname);
        List<CustomerDto> customerDtoList = new ArrayList<>(customerModelList.size());

        customerModelList.forEach(customerModel -> {
            customerDtoList.add(customerDtoConverter.convert(customerModel));
        });

        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);

    }


    @GetMapping(value = "", params = {"firstname", "lastname"})
    public ResponseEntity<List<CustomerDto>> findByFirstnameOrLastname(@RequestParam(required = false) String firstname,
                                                                       @RequestParam(required = false) String lastname) {

        if (firstname == null || lastname == null
                || firstname.isEmpty() || lastname.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<CustomerModel> customerModelList = customerService.findByFirstnameOrLastname(firstname, lastname);
        List<CustomerDto> customerDtoList = new ArrayList<>(customerModelList.size());

        customerModelList.forEach(customerModel -> {
            customerDtoList.add(customerDtoConverter.convert(customerModel));
        });

        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public void createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerModel customerModel = customerDtoConverter.convert(customerDto);
        customerService.saveCustomer(customerModel);
    }

    @PutMapping()
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto, UriComponentsBuilder builder) {

        HttpHeaders headers = new HttpHeaders();

        if (customerDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CustomerModel customerModel = customerDtoConverter.convert(customerDto);
        customerService.saveCustomer(customerModel);

        return new ResponseEntity<>(customerDto, headers, HttpStatus.OK);

    }

}
