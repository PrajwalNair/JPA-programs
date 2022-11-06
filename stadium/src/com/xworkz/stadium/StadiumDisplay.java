package com.xworkz.stadium;

import java.util.Optional;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.enums.StadiumType;
import com.xworkz.stadium.service.StadiumService;
import com.xworkz.stadium.service.StadiumServiceImpl;

public class StadiumDisplay {

	public static void main(String[] args) {
		StadiumEntity entity = new StadiumEntity(1, "chinnaswamy", 1969, 40000, 800.0, StadiumType.OUTDOOR);
		StadiumEntity entity1 = new StadiumEntity(2, "kantirava", 1975, 20000, 700.0, StadiumType.OUTDOOR);
		StadiumEntity entity2 = new StadiumEntity(3, "Narendra Modi", 2019, 100000, 1000.0, StadiumType.OUTDOOR);

		StadiumService service = new StadiumServiceImpl();
//		service.validateAndSave(entity);
//		service.validateAndSave(entity1);
//		service.validateAndSave(entity2);

		Optional<StadiumEntity> validateAndFindById = service.validateAndFindById(2);
		if (validateAndFindById.isPresent()) {
			System.out.println("id is present");
			validateAndFindById.isPresent();
		} else {
			System.out.println("id is null");
		}

	}

}
