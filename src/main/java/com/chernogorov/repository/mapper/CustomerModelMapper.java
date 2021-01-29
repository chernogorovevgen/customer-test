package com.chernogorov.repository.mapper;

import org.apache.ibatis.annotations.Param;
import com.chernogorov.model.CustomerModel;

import java.util.List;

public interface CustomerModelMapper {

    void save(@Param("customerModel") CustomerModel customer);

    CustomerModel findById(@Param("id") Long id);

    List<CustomerModel> findByFirstname(@Param("firstname") String firstname);

    List<CustomerModel> findByLastname(@Param("lastname") String lastname);

    List<CustomerModel> findByFirstnameOrLastname(@Param("firstname") String firstname,
                                                  @Param("lastname") String lastname);



}
