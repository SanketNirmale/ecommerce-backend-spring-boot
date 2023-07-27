package com.backend.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.Address;
import com.backend.main.repo.AddressRepository;

@RestController
@RequestMapping("/addr")
public class AddressController {

    @Autowired
    private AddressRepository repo;

    // Get all addresses
    @GetMapping("/get")
    public List<Address> getAllAddresses() {
        return repo.findAll();
    }

    // Get a specific address by ID
    @GetMapping("/get/{id}")
    public Address getAddressById(@PathVariable("id") Long id) {
        return repo.findById(id).orElse(null);
    }

    // Create a new address
    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address) {
        return repo.save(address);
    }

    // Update an existing address
    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address updatedAddress) {
        Address address = repo.findById(id).orElse(null);
        if (address != null) {
        	address.setArea(updatedAddress.getArea());
            address.setCity(updatedAddress.getCity());
            address.setPincode(updatedAddress.getPincode());
            address.setCountry(updatedAddress.getCountry());
            return repo.save(address);
        }
        return null;
    }

    // Delete an address
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        Address address = repo.findById(id).orElse(null);
        if (address != null) {
            repo.delete(address);
        }
    }
}