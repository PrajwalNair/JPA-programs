package com.xworkz.stadium.service;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.enums.StadiumType;
import com.xworkz.stadium.repository.StadiumRepository;
import com.xworkz.stadium.repository.StadiumRepositoryImpl;

public class StadiumServiceImpl implements StadiumService {

	private StadiumRepository repo = new StadiumRepositoryImpl();
	
	@Override
	public boolean validateAndSave(StadiumEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		int foundedYear = entity.getFoundedYear();
		int capacity = entity.getCapacity();
		double entryFees = entity.getEntryFees();
		StadiumType type = entity.getType();
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
		if(foundedYear>1800 && foundedYear<2023) {
			System.out.println("foundedYear is valid");
		}else {
			return false;
		}
		if(capacity>0) {
			System.out.println("capacity is valid");
		}else {
			return false;
		}
		if(entryFees>0) {
			System.out.println("entryFees is valid");
		}else {
			return false;
		}
		if(type!=null && type == type.OUTDOOR ||type == type.INDOOR) {
			System.out.println("type is valid");
			this.repo.save(entity);
		}else {
			return false;
		}
		
		return false;
	}

}
