package com.example.designProjectPets.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "districts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@JsonView(Views.Base.class)
	@Column(name = "districtId")
	private int districtId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "districtName")
	private String districtName;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="districtStatus")
	private boolean districtStatus;
	

	// city ilişki

	@ManyToOne()
	@JoinColumn(name = "cityId", updatable = false, insertable = false)
	private City city;

	@JsonView(Views.Base.class)
	@Column(name = "cityId", updatable = false)
	private int cityId;

	// neighbourhood ilişki

	@JsonIgnore
	@OneToMany(mappedBy = "district")
	private List<Neighbourhood> neighbourhoods;

	// address ilişki
	
	@JsonIgnore
	@OneToMany(mappedBy = "district")
	private List<Address> addresses;

}
