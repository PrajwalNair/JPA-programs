package com.xworkz.company.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.company.entity.CompanyEntity;
import com.xworkz.company.repository.CompanyRepo;
import com.xworkz.company.repository.CompanyRepoImpl;

public class CompanyServiceImpl implements CompanyService {

	CompanyRepo repo = new CompanyRepoImpl();

	@Override
	public boolean validateAndSave(List<CompanyEntity> list) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<List<CompanyEntity>>> validate = validator.validate(list);
		if (validate.size() > 0) {
			System.out.println("please fix the validation");
		} else {
			System.out.println("Data is Valid");
		}
////			this.repo.save(list);
//		}

		return this.repo.save(list);
	}

	@Override
	public Optional<CompanyEntity> findByName(String name) {
		if (name != null) {
			System.out.println("name is valid");
			this.repo.findByName(name);
		}
		return Optional.empty();
	}

}
