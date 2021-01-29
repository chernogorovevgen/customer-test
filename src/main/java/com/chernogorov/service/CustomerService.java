package com.chernogorov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chernogorov.model.CustomerModel;
import com.chernogorov.repository.CustomerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void saveCustomer(CustomerModel Customer) {
        customerRepository.save(Customer);
    }

    public CustomerModel findById(Long id) {
        return customerRepository.findById(id);
    }


    public List<CustomerModel> findByFirstnameOrLastname(String firstname, String lastname) {
        return customerRepository.findCustomerByFirstnameOrLastname(firstname, lastname);
    }


    public List<CustomerModel> findByFirstname(String firstname){
        return customerRepository.findByFirstname(firstname);
    }
    public List<CustomerModel> findByLastname(String lastname){
        return customerRepository.findByLastname(lastname);
    }


}
