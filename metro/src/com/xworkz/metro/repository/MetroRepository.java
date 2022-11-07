package com.xworkz.metro.repository;

import java.util.Optional;

import com.xworkz.metro.entity.MetroEntity;

public interface MetroRepository {
	boolean save(MetroEntity entity);

	Optional<MetroEntity> findById(int id);
	
	Optional<MetroEntity> updateNameById(int id,String newName);

}
