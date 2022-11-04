package com.xworkz.human.service;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.repository.HumanRepository;
import com.xworkz.human.repository.HumanRepositoryImpl;

public class HumanServiceImpl implements HumanService {

	private HumanRepository repo = new HumanRepositoryImpl();
	
	@Override
	public boolean validateAndSave(HumanEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		char gender = entity.getGender();
		int age = entity.getAge();
		long aadharNo = entity.getAadharNo();
		String panCardNo = entity.getPanCardNo();
		String passportNo = entity.getPassportNo();
		if(id>0) {
			System.out.println("id is valid");
		}else {
			return false;
		}
		if(name!=null && name.length()>3 && name.length()<50) {
			System.out.println("name is valid");
		}else {
			return false;
		}
		if(gender== 'M' || gender == 'F' || gender=='O') {
			System.out.println("name is valid");
		}else {
			return false;
		}
		if(age>0) {
			System.out.println("id is valid");
		}else {
			return false;
		}
		if(aadharNo>0) {
			System.out.println("id is valid");
		}else {
			return false;
		}
		if(panCardNo!=null && panCardNo.length()>3 && panCardNo.length()<50) {
			System.out.println("name is valid");
		}else {
			return false;
		}
		if(passportNo!=null && passportNo.length()>3 && passportNo.length()<50) {
			System.out.println("name is valid");
			this.repo.save(entity);
		}else {
			return false;
		}
		return false;
	}

}
