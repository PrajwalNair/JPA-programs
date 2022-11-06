package com.xworkz.company.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.company.entity.CompanyEntity;

public interface CompanyService {
	boolean validateAndSave(List<CompanyEntity> list);

	Optional<CompanyEntity> findByName(String name);

}
