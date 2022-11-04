package com.xworkz.krawardees.service;

import com.xworkz.krawardees.dto.KRAwardeesDTO;
import com.xworkz.krawardees.repository.KRAwardeesRepository;
import com.xworkz.krawardees.repository.KRAwardeesRepositoryImpl;

public class KRAwardeesServiceImpl implements KRAwardeesService {

	KRAwardeesRepository repository;

	public KRAwardeesServiceImpl(KRAwardeesRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateAndSave(KRAwardeesDTO dto) {
		int id = dto.getId();
		String name = dto.getName();
		int year = dto.getYear();
		String achievement = dto.getAchievement();
		int age = dto.getAge();
		String place = dto.getPlace();
		if (id > 0) {
			System.out.println("id is valid");
			if (name != null && name.length() > 3 && name.length() < 30) {
				System.out.println("name is valid");
				if (year > 1950 && year <= 2022) {
					System.out.println("year is valid");
					if (achievement != null && achievement.length() > 3 && achievement.length() < 30) {
						System.out.println("achievement is valid");
						if (age > 0 && age <= 100) {
							System.out.println("age is valid");
							if (place != null && place.length() > 3 && place.length() < 30) {
								System.out.println("place is valid");
								
								this.repository.save(dto);
							} else {
								System.out.println("place is invalid");
							}
						} else {
							System.out.println("age is invalid");
						}
					} else {
						System.out.println("achievement is invalid");
					}
				} else {
					System.out.println("year is invalid");
				}
			} else {
				System.out.println("name is invalid");
			}
		} else {
			System.out.println("id is invalid");
		}
		return true;
	}

}
