package com.xworkz.university;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.xworkz.university.entity.UniversityEntity;
import com.xworkz.university.service.UniversityService;
import com.xworkz.university.service.UniversityServiceImpl;

public class UniversityDisplay {

	public static void main(String[] args) {
		UniversityEntity entity = new UniversityEntity("vtu university", "karnataka", "india", 4.2);
		UniversityEntity entity1 = new UniversityEntity("KLE university", "karnataka", "india", 4.6);
		UniversityEntity entity2 = new UniversityEntity("reva university", "karnataka", "india", 3.8);

		List<UniversityEntity> entities = new ArrayList<UniversityEntity>();
		for (int i = 0; i < 2000; i++) {
			entities.add(entity);
			entities.add(entity1);

			System.out.println(entities.size());
		}
		UniversityService service = new UniversityServiceImpl();
//		boolean validateAndSave = service.validateAndSave(entities);
//		System.out.println(validateAndSave);

		Optional<UniversityEntity> findNameById = service.findNameById(1);
		if (findNameById.isPresent()) {
			UniversityEntity universityEntity = findNameById.get();
			System.out.println(universityEntity);
		}

	}

}
