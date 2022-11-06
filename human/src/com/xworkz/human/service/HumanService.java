package com.xworkz.human.service;

import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;

public interface HumanService {
	boolean validateAndSave(HumanEntity entity);

	Optional<HumanEntity> validateAndFindById(int id);

}
