package com.xworkz.company.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.company.entity.CompanyEntity;

public interface CompanyRepo {
	boolean save(List<CompanyEntity> list);

	Optional<CompanyEntity> findByName(String name);

}
