package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.AdvertSort;



public interface AdvertSortDao extends JpaRepository<AdvertSort, Integer> {
	
	AdvertSort getByadvertSortId(int advertSortId);

}
