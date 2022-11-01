package com.xworkz.pub.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pub")
@NamedQueries({ @NamedQuery(name = "findById", query = "select p from PubDTO p where p.id=:id1"),
		@NamedQuery(name = "updateStateByName", query = "update PubDTO p set p.state =: state1 where p.name=:nm"),
		@NamedQuery(name = "deleteByName", query = "delete from PubDTO p where p.name=:nm") })
public class PubDTO implements Serializable {
	@Id
	private int id;
	@NotNull
	@Size(min = 5, message = "name should not be less than 5 letters")
	@Size(max = 10, message = "name should no be greater than 10 letters")
	private String name;
	@NotNull
	@Size(min = 5, message = "name should not be less than 5 letters")
	@Size(max = 10, message = "name should no be greater than 10 letters")
	private String location;
	@NotNull
	@Size(min = 5, message = "name should not be less than 5 letters")
	@Size(max = 10, message = "name should no be greater than 10 letters")
	private String state;
	@NotNull
	@Size(min = 5, message = "name should not be less than 5 letters")
	@Size(max = 10, message = "name should no be greater than 10 letters")
	private String country;
	@NotNull
	@Min(value = 500)
	@Max(value = 1000)
	private double entryFees;

}
