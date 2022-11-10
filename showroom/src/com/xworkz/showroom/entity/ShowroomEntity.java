package com.xworkz.showroom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "showroom")
public class ShowroomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String location;
	private String country;

	public ShowroomEntity(String name, String type, String location, String country) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.country = country;
	}

}
