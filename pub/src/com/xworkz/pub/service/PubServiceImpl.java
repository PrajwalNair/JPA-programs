package com.xworkz.pub.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.pub.dto.PubDTO;
import com.xworkz.pub.repository.PubRepository;
import com.xworkz.pub.repository.PubRepositoryImpl;

public class PubServiceImpl implements PubService {
	PubRepository repository = new PubRepositoryImpl();

	@Override
	public Boolean validateAndSave(PubDTO dto) {

		ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PubDTO>> voilation = validator.validate(dto);
		if (voilation.size() > 0) {
			System.out.println("invalid details");
			for (ConstraintViolation<PubDTO> constraintViolation : voilation) {
				System.out.println(constraintViolation.getMessage());
				
			}
		} else {
			repository.save(dto);
		}

		return null;
	}

}
