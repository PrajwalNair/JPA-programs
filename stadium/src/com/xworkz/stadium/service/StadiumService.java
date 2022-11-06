package com.xworkz.stadium.service;

import java.util.Optional;

import com.xworkz.stadium.entity.StadiumEntity;

public interface StadiumService {
	boolean validateAndSave(StadiumEntity entity);

	Optional<StadiumEntity> validateAndFindById(int id);

}
