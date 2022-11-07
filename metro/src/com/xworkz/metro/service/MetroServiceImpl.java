package com.xworkz.metro.service;

import java.util.Optional;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.repository.MetroRepository;
import com.xworkz.metro.repository.MetroRepositoryImpl;

public class MetroServiceImpl implements MetroService {

	private MetroRepository repo = new MetroRepositoryImpl();

	@Override
	public boolean validateAndSave(MetroEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		String area = entity.getArea();
		String city = entity.getCity();
		String state = entity.getState();
		String country = entity.getCountry();
		int pincode = entity.getPincode();
		int noOfEntryGate = entity.getNoOfEntryGate();
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			return false;
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			return false;
		}
		if (area != null && area.length() > 3 && area.length() < 50) {
			System.out.println("area is valid");
		} else {
			return false;
		}
		if (city != null && city.length() > 3 && city.length() < 50) {
			System.out.println("city is valid");
		} else {
			return false;
		}
		if (state != null && state.length() > 3 && state.length() < 50) {
			System.out.println("state is valid");
		} else {
			return false;
		}
		if (country != null && country.length() > 3 && country.length() < 50) {
			System.out.println("country is valid");
		} else {
			return false;
		}
		if (pincode > 0) {
			System.out.println("pincode is valid");
		} else {
			return false;
		}
		if (noOfEntryGate > 0) {
			System.out.println("noOfEntryGate is valid");
			this.repo.save(entity);
		} else {
			return false;
		}
		return false;
	}

	@Override
	public Optional<MetroEntity> validateAndFindById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			this.repo.findById(id);
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<MetroEntity> updateNameById(int id, String newName) {
		this.repo.updateNameById(id, newName);
		
		return Optional.empty();
	}

}
