package com.xworkz.film.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.film.entity.FilmEntity;
import com.xworkz.film.repository.FilmRepository;
import com.xworkz.film.repository.FilmRepositoryImpl;

public class FilmServiceImpl implements FilmService {

	FilmRepository repository = new FilmRepositoryImpl();

	public boolean validateAndSave(List<FilmEntity> list) {

//		for (FilmEntity filmEntity : list) {
//			int id = filmEntity.getId();
//			String name = filmEntity.getName();
//			String language = filmEntity.getLanguage();
//			String hero = filmEntity.getHero();
//			String heroine = filmEntity.getHeroine();
//			if (id > 0) {
//				System.out.println("id is valid");
//			} else {
//				System.err.println("id is invalid");
//			}
//			if (name != null && name.length() > 3 && name.length() < 50) {
//				System.out.println("name is valid");
//			} else {
//				System.err.println("name is invalid");
//			}
//			if (language != null && language.length() > 3 && language.length() < 50) {
//				System.out.println("language is valid");
//			} else {
//				System.err.println("language is invalid");
//			}
//			if (hero != null && hero.length() > 3 && hero.length() < 50) {
//				System.out.println("hero is valid");
//			} else {
//				System.err.println("hero is invalid");
//			}
//			if (heroine != null && heroine.length() > 3 && heroine.length() < 50) {
//				System.out.println("heroine is valid");
//			} else {
//				System.err.println("heroine is invalid");
//			}
//		}
//		repository.save(list);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<List<FilmEntity>>> validate = validator.validate(list);
		if (validate.size() > 0) {
			System.out.println("fix the bugs");
		} else {
			System.out.println("data is valid");
			repository.save(list);
		}
		return true;

	}

	@Override
	public Optional<FilmEntity> findNameById(int id) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Integer>> validate = validator.validate(id);
		if (validate.size() > 0) {
			System.out.println("fix the bugs (ser)");
		} else {
			System.out.println("id is valid (ser)");
			return repository.findNameById(id);
		}

		return Optional.empty();
	}

	@Override
	public Optional<FilmEntity> findLangByName(String name) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<String>> validate = validator.validate(name);
		if (validate.size() > 0) {
			System.out.println("fix the bugs (ser)");
		} else {
			System.out.println("name is valid (ser) " + name);
		}

		return repository.findLangByName(name);
	}

	@Override
	public Optional<FilmEntity> findUniqueLanguage() {
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		Validator validator = validatorFactory.getValidator();
//		validator.validate();
		return repository.findUniqueLanguage();

	}

//	@Override
//	public Optional<FilmEntity> findHero(String name) {
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		Validator validator = validatorFactory.getValidator();
//		Set<ConstraintViolation<String>> validate = validator.validate(name);
//		if (validate.size() > 0) {
//			System.out.println("fix the bugs (ser)");
//		} else {
//			System.out.println("name is valid (ser) " + name);
//			return repository.findHero(name);
//		}
//		return null;
//	}

}
