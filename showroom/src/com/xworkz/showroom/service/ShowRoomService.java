package com.xworkz.showroom.service;

import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;

public interface ShowRoomService {
	boolean validateAndSave(ShowroomEntity entity);

	Optional<ShowroomEntity> valiadateAndFindById(int id);

	void validateAndUpdateNameById(int id, String name);

	void deleteById(int id);

}
