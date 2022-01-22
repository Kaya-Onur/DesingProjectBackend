package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.Neighbourhood;



public interface NeighbourhoodDao extends JpaRepository<Neighbourhood, Integer> {

}
