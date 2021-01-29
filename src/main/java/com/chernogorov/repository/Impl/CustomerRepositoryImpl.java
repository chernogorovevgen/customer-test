package com.chernogorov.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.chernogorov.model.CustomerModel;
import com.chernogorov.repository.AddressRepository;
import com.chernogorov.repository.CustomerRepository;
import com.chernogorov.repository.mapper.CustomerModelMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {


    private final CustomerModelMapper customerModelMapper;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public void save(@NonNull CustomerModel customer) {
        Optional.ofNullable(customer.getActualAddress())
                .ifPresent(address -> {
                    addressRepository.save(address);
                    customer.setActualAddressId(address.getId());
                });

        Optional.ofNullable(customer.getRegistredAddress())
                .ifPresent(address -> {
                    addressRepository.save(address);
                    customer.setRegistredAddressId(address.getId());
                });

        customerModelMapper.save(customer);
    }


    @Override
    public CustomerModel findById(Long id) {
        return customerModelMapper.findById(id);
    }


    @Override
    public List<CustomerModel> findByFirstname(String firstname) {
        return customerModelMapper.findByFirstname(firstname);
    }

    @Override
    public List<CustomerModel> findByLastname(String lastname) {
        return customerModelMapper.findByLastname(lastname);
    }

    @Override
    public List<CustomerModel> findCustomerByFirstnameOrLastname(String firstname, String lastname) {
        return customerModelMapper.findByFirstnameOrLastname(firstname, lastname);
    }


}

