package com.xworkz.university.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.university.entity.UniversityEntity;
import com.xworkz.university.repo.UniversityRepoImpl;

public class UniversityServiceImpl implements UniversityService {

	private UniversityRepoImpl repo = new UniversityRepoImpl();

	public boolean validateAndSave(List<UniversityEntity> list) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<List<UniversityEntity>>> validate = validator.validate(list);
		if (validate.size() > 0) {
			System.out.println("errors are there please fix it");
		} else {
			repo.save(list);
		}

		return true;
	}

	public Optional<UniversityEntity> findNameById(int id) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Integer>> validate = validator.validate(id);
		if (validate.size() > 0) {
			System.out.println("id is not valid please enter the valid id");
		} else {
			return repo.findNameById(id);
		}
		return Optional.empty();
	}

}
