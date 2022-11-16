package com.xworkz.university.repo;

import java.util.List;
import java.util.Optional;

import com.xworkz.university.entity.UniversityEntity;

public interface UniversityRepo {
	boolean save(List<UniversityEntity> list);
	
	Optional<UniversityEntity> findNameById(int id);

}
