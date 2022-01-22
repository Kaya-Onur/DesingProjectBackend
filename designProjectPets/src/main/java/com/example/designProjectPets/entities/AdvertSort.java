package com.example.designProjectPets.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "advertSorts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdvertSort {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonView(Views.Base.class)
	@Column(name = "advertSortId")
	private int advertSortId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "advertSortName")
	private String advertSortName;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="advertSortStatus")
	private boolean advertSortStatus;
	
	



}
