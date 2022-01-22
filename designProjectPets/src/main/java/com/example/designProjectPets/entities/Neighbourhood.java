package com.example.designProjectPets.entities;

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
@Table(name = "neigbourhoods")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Neighbourhood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@JsonView(Views.Base.class)
	@Column(name = "neighbourhoodId")
	private int neighbourhoodId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "neighbourhoodName")
	private String neighbourhoodName;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="neighbourhoodStatus")
	private boolean neighbourhoodStatus;
	

	// district ilişki
	@ManyToOne()
	@JoinColumn(name = "districtId", updatable = false, insertable = false)
	private District district;

	@JsonView(Views.Base.class)
	@Column(name = "districtId", updatable = false)
	private int districtId;

}
