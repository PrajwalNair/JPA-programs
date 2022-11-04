package com.xworkz.stadium;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.enums.StadiumType;
import com.xworkz.stadium.service.StadiumService;
import com.xworkz.stadium.service.StadiumServiceImpl;

public class StadiumDisplay {

	public static void main(String[] args) {
		StadiumEntity entity = new StadiumEntity(1, "chinnaswamy", 1969, 40000, 800.0, StadiumType.OUTDOOR);
		
		StadiumService service = new StadiumServiceImpl();
		service.validateAndSave(entity);

	}

}
