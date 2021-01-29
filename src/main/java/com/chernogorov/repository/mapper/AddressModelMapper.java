package com.chernogorov.repository.mapper;

import org.apache.ibatis.annotations.Param;
import com.chernogorov.model.AddressModel;

import java.util.List;

public interface AddressModelMapper {

    AddressModel getById(@Param("id") Long id);

    List<AddressModel> getAll();

    void save(@Param("addressModel") AddressModel address);

}
