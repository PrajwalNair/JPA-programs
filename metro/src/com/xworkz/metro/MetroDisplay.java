package com.xworkz.metro;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.service.MetroService;
import com.xworkz.metro.service.MetroServiceImpl;

public class MetroDisplay {

	public static void main(String[] args) {
		MetroEntity entity =new MetroEntity(1, "namma metro", "jayanagar", "bangalore", "karnataka", "india", 580021, 20, true, true);
		
		MetroService service = new MetroServiceImpl();
		service.validateAndSave(entity);
	}

}
