package com.xworkz.metro.service;

import java.util.Optional;

import com.xworkz.metro.entity.MetroEntity;

public interface MetroService {
	boolean validateAndSave(MetroEntity entity);

	Optional<MetroEntity> validateAndFindById(int id);

}
