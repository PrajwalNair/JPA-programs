package com.xworkz.pub;

import com.xworkz.pub.dto.PubDTO;
import com.xworkz.pub.repository.PubRepository;
import com.xworkz.pub.repository.PubRepositoryImpl;
import com.xworkz.pub.service.PubService;
import com.xworkz.pub.service.PubServiceImpl;

public class PubDisplay {

	public static void main(String[] args) {
		PubDTO dto = new PubDTO(3, "icecubeskhhglyf", "akshaygfjt", "karnataka", "india", 1600.0);
		PubRepository repository =new PubRepositoryImpl();
		
//		PubService impl = new PubServiceImpl();
//		Boolean save = impl.validateAndSave(dto);
//		System.out.println(save);
		//PubDTO findById = repository.findById(1);
		//System.out.println(findById);
		//repository.updateStateByName("icecubes", "Kerala");
		repository.deleteByName("ice cubes");
	}

}
