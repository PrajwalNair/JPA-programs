package com.xworkz.showroom.repository;

import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;

public interface ShowRoomRepo {
	boolean save(ShowroomEntity entity);

	Optional<ShowroomEntity> findById(int id);

	void updateNameById(int id, String name);

	void deleteById(int id);

}
