package com.xworkz.company;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.company.entity.CompanyEntity;
import com.xworkz.company.enums.Designation;
import com.xworkz.company.service.CompanyService;
import com.xworkz.company.service.CompanyServiceImpl;

public class CompanyDisplay {

	public static void main(String[] args) {

		CompanyEntity entity = new CompanyEntity(1, "jp morgan", Designation.ARCHITECT, 5, 6, "belendur", "india");
		CompanyEntity entity1 = new CompanyEntity(2, "wells fergo", Designation.MANAGER, 10, 8, "marathahalli",
				"india");

		CompanyEntity entity2 = new CompanyEntity(3, "microsoft", Designation.SRDEVELOPER, 15, 12, "itpl", "india");

		List<CompanyEntity> entities = new ArrayList<CompanyEntity>();
		entities.add(entity);
		entities.add(entity1);
		entities.add(entity2);
		CompanyService service = new CompanyServiceImpl();
		// entities.forEach(ref ->
		// System.out.println(service.validateAndSave(entities)));
//		service.validateAndSave(entities);
		
		service.findByName("wells fergo");

	}

}
