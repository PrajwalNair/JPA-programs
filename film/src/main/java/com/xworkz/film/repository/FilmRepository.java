package com.xworkz.film.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.film.entity.FilmEntity;

public interface FilmRepository {
	boolean save(List<FilmEntity> list);

	Optional<FilmEntity> findNameById(int id);

	Optional<FilmEntity> findLangByName(String name);
	
	Optional<FilmEntity> findHero(String name);

}
