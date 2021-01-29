package com.chernogorov.repository;


import com.chernogorov.model.CustomerModel;

import java.util.List;


public interface CustomerRepository {

    void save(CustomerModel customer);

    CustomerModel findById(Long id);

    List<CustomerModel> findByFirstname(String firstname);

    List<CustomerModel> findByLastname(String lastname);

    List<CustomerModel> findCustomerByFirstnameOrLastname(String firstname, String lastname);


}
