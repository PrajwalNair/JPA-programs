package com.xworkz.showroom.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;

public interface ShowRoomService {
	boolean validateAndSave(ShowroomEntity entity);

	boolean validateAndSave(List<ShowroomEntity> list);

	Optional<ShowroomEntity> valiadateAndFindById(int id);

	void validateAndUpdateNameById(int id, String name);

	void deleteById(int id);

}
