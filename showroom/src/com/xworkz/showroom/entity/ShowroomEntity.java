package com.xworkz.showroom.entity;

import javax.persistence.Entity;
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
	private int id;
	private String name;
	private String type;
	private String location;
	private String country;

}
