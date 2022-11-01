package com.xworkz.krawardees.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "krawardees")
public class KRAwardeesDTO {
	@Id
	private int id;
	private String name;
	private int year;
	private String achievement;
	private boolean alive;
	private int age;
	private String place;

}
