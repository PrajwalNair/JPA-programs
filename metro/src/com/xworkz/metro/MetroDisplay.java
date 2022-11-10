package com.xworkz.metro;

import java.util.Optional;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.service.MetroService;
import com.xworkz.metro.service.MetroServiceImpl;

public class MetroDisplay {

	public static void main(String[] args) {
		MetroEntity entity = new MetroEntity(1, "namma metro", "jayanagar", "bangalore", "karnataka", "india", 580021,
				20, true, true);
		MetroEntity entity1 = new MetroEntity(2, "delhi metro", "chandani chawk", "delhi", "delhi", "india", 580025, 20,
				true, true);
		MetroEntity entity2 = new MetroEntity(3, "mumbai metro", "tane", "mumbai", "maharashtra", "india", 580028, 20,
				true, true);

		MetroService service = new MetroServiceImpl();
		service.validateAndSave(entity);
//		service.validateAndSave(entity1);
//		service.validateAndSave(entity2);

		Optional<MetroEntity> validateAndFindById = service.validateAndFindById(3);
		if (validateAndFindById.isPresent()) {
			System.out.println("id is present");
			validateAndFindById.get();
		} else {
			System.out.println("it is null");
		}
		
		Optional<MetroEntity> updateNameById = service.updateNameById(2, "ahmedabhad");
		if (updateNameById.isPresent()) {
			System.out.println("id is present");
			updateNameById.get();
		} else {
			System.out.println("it is null");
		}
		
	}

}
