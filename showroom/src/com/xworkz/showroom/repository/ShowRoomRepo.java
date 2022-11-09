package com.xworkz.showroom.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;

public interface ShowRoomRepo {
	boolean save(ShowroomEntity entity);

	boolean save(List<ShowroomEntity> list);

	Optional<ShowroomEntity> findById(int id);

	void updateNameById(int id, String name);

	void deleteById(int id);

}
