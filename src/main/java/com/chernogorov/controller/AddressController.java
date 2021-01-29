package com.chernogorov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chernogorov.converter.AddressDtoConverter;
import com.chernogorov.dto.AddressDto;
import com.chernogorov.model.AddressModel;
import com.chernogorov.service.AddressService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер Rest запросов для Address
 */

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressDtoConverter addressDtoConverter;

    @PostMapping("/save")
    public ResponseEntity<AddressDto> createCustomer(@Valid @RequestBody AddressDto addressDto) {

        HttpHeaders headers = new HttpHeaders();

        if (addressDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AddressModel address = addressDtoConverter.convert(addressDto);
        addressService.save(address);

        return new ResponseEntity<>(addressDto, headers, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDto>> getAll(){

        HttpHeaders headers = new HttpHeaders();

        List<AddressModel> addressModellList = addressService.getAll();
        List<AddressDto> addressDtoList = new ArrayList<>(addressModellList.size());

        for (AddressModel address : addressModellList) {
            addressDtoList.add(addressDtoConverter.convert(address));
        }

        return new ResponseEntity<>(addressDtoList, headers, HttpStatus.OK);
    }



}
