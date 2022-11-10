package com.xworkz.film.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.film.entity.FilmEntity;

public interface FilmService {
	boolean validateAndSave(List<FilmEntity> list);

	Optional<FilmEntity> findNameById(int id);

	Optional<FilmEntity> findLangByName(String name);

	Optional<FilmEntity> findHero(String name);

}
