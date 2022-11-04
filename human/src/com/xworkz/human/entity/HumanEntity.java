package com.xworkz.human.entity;

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
@Table (name = "human")
public class HumanEntity {
	@Id
	private int id;
	private String name;
	private char gender;
	private int age;
	private long aadharNo;
	private String panCardNo;
	private String passportNo;
	private boolean voterId;
	private boolean aadharCard;
	private boolean panCard;
	private boolean eyes;
	private boolean nose;
	private boolean emotion;
	private boolean pain;
	private boolean brain;

}
