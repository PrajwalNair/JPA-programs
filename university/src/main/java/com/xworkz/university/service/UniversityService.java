package com.xworkz.university.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.university.entity.UniversityEntity;

public interface UniversityService {
	boolean validateAndSave(List<UniversityEntity> list);

	Optional<UniversityEntity> findNameById(int id);

}
