package com.example.designProjectPets.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "advertTypes")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdvertType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonView(Views.Base.class)
	@Column(name = "advertTypeId")
	private int advertTypeId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "advertTypeName")
	private String advertTypeName;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="advertTypeStatus")
	private boolean advertTypeStatus;
	
	

}
