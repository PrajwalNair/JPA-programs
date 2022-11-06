package com.xworkz.stadium.repository;

import java.util.Optional;

import com.xworkz.stadium.entity.StadiumEntity;

public interface StadiumRepository {
	boolean save(StadiumEntity entity);

	Optional<StadiumEntity> findById(int id);

}
