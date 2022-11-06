package com.xworkz.human;

import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.service.HumanService;
import com.xworkz.human.service.HumanServiceImpl;

public class HumanDisplay {

	public static void main(String[] args) {
		HumanEntity entity = new HumanEntity(1, "Suhas", 'M', 27, 1234258912542563l, "cv515sdvh", "v1465464", true,
				true, true, true, true, true, true, true);
		HumanEntity entity1 = new HumanEntity(2, "hanamant", 'M', 26, 1234258912542564l, "cv515sdvi", "v1465465", true,
				true, true, true, true, true, true, true);
		HumanEntity entity2 = new HumanEntity(3, "sharat", 'M', 24, 1234258912542562l, "cv515sdvk", "v1465468", true,
				true, true, true, true, true, true, true);

		HumanService service = new HumanServiceImpl();
//		service.validateAndSave(entity);
		service.validateAndSave(entity1);
		service.validateAndSave(entity2);

		Optional<HumanEntity> validateAndFindById = service.validateAndFindById(3);
		if (validateAndFindById.isPresent()) {
			System.out.println("id is present");
			validateAndFindById.isPresent();
		} else {
			System.out.println("entry is null");
		}

	}

}
