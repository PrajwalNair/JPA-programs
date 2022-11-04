package com.xworkz.metro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "metro")
public class MetroEntity {
	@Id
	private int id;
	private String name;
	private String area;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private int noOfEntryGate;
	private boolean escalator;
	private boolean lift;
	
	

}
