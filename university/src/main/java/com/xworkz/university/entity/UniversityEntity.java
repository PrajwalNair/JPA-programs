package com.xworkz.university.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")
public class UniversityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 50, message = "length of the string is not matching")
	private String name;
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 50, message = "length of the string is not matching")
	private String state;
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 50, message = "length of the string is not matching")
	private String country;

	private double rating;

	public UniversityEntity(String name, String state, String country, double rating) {
		super();
		this.name = name;
		this.state = state;
		this.country = country;
		this.rating = rating;
	}
	
	

}
