package com.xworkz.human.repository;

import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;

public interface HumanRepository {
	boolean save(HumanEntity entity);

	Optional<HumanEntity> findById(int id);

}
