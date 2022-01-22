package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.City;



public interface CityDao extends JpaRepository<City, Integer> {
	City getBycityId(int cityId);
}
