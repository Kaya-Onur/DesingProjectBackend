package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.Address;



public interface AddressDao extends JpaRepository<Address, Integer> {

}
