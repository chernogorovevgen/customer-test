package com.chernogorov.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.chernogorov.model.AddressModel;
import com.chernogorov.repository.AddressRepository;
import com.chernogorov.repository.mapper.AddressModelMapper;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressModelMapper addressModelMapper;


    @Override
    public AddressModel getById(Long id) {
        return addressModelMapper.getById(id);
    }

    @Transactional
    @Override
    public void save(AddressModel address) {

        if (address.getCreated() == null) {
            address.setCreated(new Date());
        }

        address.setModified(new Date());

        addressModelMapper.save(address);
    }

    @Override
    public List<AddressModel> getAll() {
        return addressModelMapper.getAll();
    }


}
