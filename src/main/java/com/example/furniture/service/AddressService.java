package com.example.furniture.service;

import com.example.furniture.model.Address;
import com.example.furniture.model.Cart;
import com.example.furniture.repository.AddressRepository;
import com.example.furniture.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address addAndUpdateAddress(Address address){
        Address newAddress = address;
        if(newAddress.getAddressId() != null) {
            Optional<Address> addressOptional = addressRepository.findById(address.getAddressId());
            if (addressOptional.isPresent()) {
                newAddress = addressOptional.get();
                newAddress.setFullName(address.getFullName());
                newAddress.setCity(address.getCity());
                newAddress.setAddress(address.getAddress());
                newAddress.setZipcode(address.getZipcode());
                newAddress.setState(address.getState());
                newAddress.setCity(address.getCity());
            }
        }
        return addressRepository.save(newAddress);
    }

    public Address findAddressById(Long addressId){
        return addressRepository.findById(addressId).get();
    }

    public List<Address> findAddressUserId(Long userId){
        return addressRepository.findByUserId(userId);
    }

    public void deleteAddress(Long addressId){
        addressRepository.deleteById(addressId);
    }
}