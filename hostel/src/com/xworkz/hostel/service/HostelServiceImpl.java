package com.xworkz.hostel.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.hostel.dto.HostelDTO;
import com.xworkz.hostel.repository.HostelRepository;
import com.xworkz.hostel.repository.HostelRepositoryImpl;

public class HostelServiceImpl implements HostelService {

	HostelRepository repository = new HostelRepositoryImpl();
	@Override
	public boolean validateAndSave(HostelDTO dto) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<HostelDTO>> validate = validator.validate(dto);
		if(validate.size()>0) {
			System.out.println("data is invalid");
		}else {
			System.out.println("data is valid ");
			return repository.save(dto);
		}
		return true;
	}
	
	@Override
	public HostelDTO findByid(int id) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Integer>> validate = validator.validate(id);
		if(validate.size()>0) {
			System.out.println("data is invalid");
		}else {
			System.out.println("data is valid ");
			return repository.findByid(id);
		}
		return null;
	}

}
