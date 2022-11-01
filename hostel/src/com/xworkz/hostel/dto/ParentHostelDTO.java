package com.xworkz.hostel.dto;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class ParentHostelDTO {
	
	@NotNull @NotEmpty @Length(min = 3) @Length(max = 30)
	private String createdBy;
	@NotNull @PastOrPresent
	private LocalDate createdDate;
	@NotNull @Length(min = 3) @Length(max = 30)
	private String updatedBy;
	
	private LocalDate updateDate;

}
