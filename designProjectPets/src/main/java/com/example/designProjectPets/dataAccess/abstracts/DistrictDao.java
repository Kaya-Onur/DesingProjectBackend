package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.District;



public interface DistrictDao extends JpaRepository<District, Integer> {

}
