package com.xworkz.hostel.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table (name = "hostel")
public class HostelDTO extends ParentHostelDTO {
	@Id
	@GenericGenerator(name = "nm",strategy = "increment")
	@GeneratedValue (generator = "nm")
	private int id;
	@NotNull @NotEmpty @Length(min = 3) @Length(max = 30)
	private String name;
	@NotNull @NotEmpty @Length(min = 3) @Length(max = 30)
	private String type;
	@NotNull @NotEmpty @Length(min = 3) @Length(max = 30)
	private String location;
	@NotNull @NotEmpty @Length(min = 3) @Length(max = 30)
	private String city;
	
	
	public HostelDTO(String createdBy, LocalDate createdDate, String updatedBy, LocalDate updateDate,
			String name, String type, String location, String city) {
		super(createdBy, createdDate, updatedBy, updateDate);	
		this.name = name;
		this.type = type;
		this.location = location;
		this.city = city;
	}
	
	

}
