package com.xworkz.human;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.service.HumanService;
import com.xworkz.human.service.HumanServiceImpl;

public class HumanDisplay {

	public static void main(String[] args) {
		HumanEntity entity = new HumanEntity(1, "Suhas", 'M', 27, 1234258912542563l, "cv515sdvh", "v1465464", true, true, true, true, true, true, true, true);

		HumanService service = new HumanServiceImpl();
		service.validateAndSave(entity);
	}

}
