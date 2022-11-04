package com.xworkz.stadium.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.stadium.enums.StadiumType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "stadium")
public class StadiumEntity {
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "foundedYear")
	private int foundedYear;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "entryFees")
	private double entryFees;
	@Column(name = "type")
	private StadiumType type;
	

}
