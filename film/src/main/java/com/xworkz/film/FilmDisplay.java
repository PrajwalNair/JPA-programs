package com.xworkz.film;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import com.xworkz.film.entity.FilmEntity;
import com.xworkz.film.service.FilmService;
import com.xworkz.film.service.FilmServiceImpl;

public class FilmDisplay {

	public static void main(String[] args) {
		FilmEntity entity = new FilmEntity("2 states", "hindi", "arjun kapoor", "Alia Bhat");
		FilmEntity entity1 = new FilmEntity("koi mil gaya", "hindi", "hrithik roshan", "preeti zinta");
		FilmEntity entity2 = new FilmEntity("KGF 2", "kannada", "Yash", "Shrinidhi Shetty");
		FilmEntity entity3 = new FilmEntity("Bramhastra", "hindi", "ranbir kapoor", "Alia Bhat");
		FilmEntity entity4 = new FilmEntity("Raabta", "hindi", "Sushant singh rajput", "Kriti senon");

		List<FilmEntity> list = new ArrayList<FilmEntity>();
		list.add(entity);
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		list.add(entity4);

		FilmService service = new FilmServiceImpl();
//		service.validateAndSave(list);
		Optional<FilmEntity> findNameById = service.findNameById(1);
		if (findNameById.isPresent()) {
			FilmEntity filmEntity = findNameById.get();
			System.out.println("main " + filmEntity);
		}

//		Optional<FilmEntity> findLangByName = service.findLangByName("2 states");
//		if (findLangByName.isPresent()) {
//			FilmEntity filmEntity = findLangByName.get();
//			System.out.println(filmEntity);
//		}

		Optional<FilmEntity> findHero = service.findHero("hrithik roshan");
		if (findHero.isPresent()) {
			FilmEntity filmEntity = findHero.get();
			System.out.println(filmEntity);
		}

	}

}
