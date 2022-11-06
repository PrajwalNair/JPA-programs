package com.xworkz.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Length;

import com.xworkz.company.enums.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compaany")
@NamedQueries({@NamedQuery(name = "findByName",query = "select com from CompanyEntity com where com.name=:nm")})
public class CompanyEntity {
	@Id
	private int id;
	@Column(name = "company")
	@NotNull
	@Length(min = 3)
	@Length(max = 30)
	private String name;
	@Enumerated(EnumType.STRING)
	private Designation type;
	@NotNull
	private int noOfEmployees;
	@NotNull
	private int noOfworkers;
	@Column(name = "place")
	@NotNull
	@Length(min = 3)
	@Length(max = 30)
	private String location;
	@NotNull
	@Length(min = 3)
	@Length(max = 30)
	private String country;

}
