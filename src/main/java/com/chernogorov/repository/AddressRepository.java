package com.chernogorov.repository;


import com.chernogorov.model.AddressModel;

import java.util.List;

public interface AddressRepository {

    AddressModel getById(Long id);

    void save(AddressModel address);

    List<AddressModel> getAll();

}
