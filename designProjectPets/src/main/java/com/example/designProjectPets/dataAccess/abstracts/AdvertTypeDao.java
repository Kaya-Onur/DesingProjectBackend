package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.designProjectPets.entities.AdvertType;


public interface AdvertTypeDao extends JpaRepository<AdvertType, Integer>  {
	AdvertType getByadvertTypeId(int advertTypeId);
}
