package com.xworkz.showroom.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;
import com.xworkz.showroom.repository.ShowRoomRepo;
import com.xworkz.showroom.repository.ShowRoomRepoImpl;

public class ShowRoomServiceImpl implements ShowRoomService {

	private ShowRoomRepo repo = new ShowRoomRepoImpl();

	@Override
	public boolean validateAndSave(ShowroomEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		String type = entity.getType();
		String location = entity.getLocation();
		String country = entity.getCountry();
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.out.println("id is not valid");
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			System.out.println("name is not valid");
		}
		if (type != null && type.length() > 3 && type.length() < 50) {
			System.out.println("type is valid");
		} else {
			System.out.println("type is not valid");
		}
		if (location != null && location.length() > 3 && location.length() < 50) {
			System.out.println("location is valid");
		} else {
			System.out.println("location is not valid");
		}
		if (country != null && country.length() > 3 && country.length() < 50) {
			System.out.println("country is valid");
			repo.save(entity);
		} else {
			System.out.println("country is not valid");

		}
		return false;
	}

	@Override
	public boolean validateAndSave(List<ShowroomEntity> list) {
		ShowroomEntity entity = new ShowroomEntity();
		int id = entity.getId();
		String name = entity.getName();
		String type = entity.getType();
		String location = entity.getLocation();
		String country = entity.getCountry();
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.out.println("id is not valid");
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			System.out.println("name is not valid");
		}
		if (type != null && type.length() > 3 && type.length() < 50) {
			System.out.println("type is valid");
		} else {
			System.out.println("type is not valid");
		}
		if (location != null && location.length() > 3 && location.length() < 50) {
			System.out.println("location is valid");
		} else {
			System.out.println("location is not valid");
		}
		if (country != null && country.length() > 3 && country.length() < 50) {
			System.out.println("country is valid");
			this.repo.save(list);
		} else {
			System.out.println("country is not valid");

		}
		return false;
	}

	@Override
	public Optional<ShowroomEntity> valiadateAndFindById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			repo.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public void validateAndUpdateNameById(int id, String name) {
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.err.println("entered id is not valid");
		}
		if (name != null && name.length() > 2 && name.length() < 50) {
			System.out.println("id is valid");
			repo.updateNameById(id, name);
		} else {
			System.err.println("entered id is not valid");
		}

	}

	@Override
	public void deleteById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			repo.deleteById(id);
		} else {
			System.err.println("id is not valid");
		}

	}

}
