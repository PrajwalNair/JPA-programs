package com.xworkz.film.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "film")

@NamedQueries({
	@NamedQuery(name="findLangByName",query="select alia.language from FilmEntity alia where alia.name =:lg"),
	@NamedQuery(name = "findUniqueLanguage" ,query = "select distinct alia.language from FilmEntity")
})
public class FilmEntity {
	@Id
	@GenericGenerator(name = "nm", strategy = "increment")
	@GeneratedValue(generator = "nm")
	private int id;
	@NotNull
	@Length(min = 3, max = 50)
	@Length(min = 3, max = 50)
	private String name;
	@NotNull
	@Length(min = 3, max = 50)
	@Length(min = 3, max = 50)
	private String language;
	@NotNull
	@Length(min = 3, max = 50)
	@Length(min = 3, max = 50)
	private String hero;
	@NotNull
	@Length(min = 3, max = 50)
	@Length(min = 3, max = 50)
	private String heroine;

	public FilmEntity(@NotNull @Length(min = 3, max = 50) @Length(min = 3, max = 50) String name,
			@NotNull @Length(min = 3, max = 50) @Length(min = 3, max = 50) String language,
			@NotNull @Length(min = 3, max = 50) @Length(min = 3, max = 50) String hero,
			@NotNull @Length(min = 3, max = 50) @Length(min = 3, max = 50) String heroine) {
		super();
		this.name = name;
		this.language = language;
		this.hero = hero;
		this.heroine = heroine;
	}

}
