package com.chernogorov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chernogorov.model.AddressModel;
import com.chernogorov.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public void save(AddressModel address) {
        addressRepository.save(address);
    }

    public List<AddressModel> getAll() {
        return addressRepository.getAll();
    }

}
