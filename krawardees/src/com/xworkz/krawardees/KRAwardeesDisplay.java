package com.xworkz.krawardees;

import com.xworkz.krawardees.dto.KRAwardeesDTO;
import com.xworkz.krawardees.repository.KRAwardeesRepository;
import com.xworkz.krawardees.repository.KRAwardeesRepositoryImpl;
import com.xworkz.krawardees.service.KRAwardeesServiceImpl;

public class KRAwardeesDisplay {

	public static void main(String[] args) {
		KRAwardeesDTO dto = new KRAwardeesDTO(1, "punit rajkumar", 2022, "film", false, 50, "Bangalore");
		KRAwardeesDTO dto1 = new KRAwardeesDTO(2, "kuvempu", 1992, "poet", false, 89, "mysore");
		KRAwardeesDTO dto2 = new KRAwardeesDTO(3, "Dr. Rajkumar", 1992, "actor", false, 76, "Bangalore");
		KRAwardeesDTO dto3 = new KRAwardeesDTO(4, "Bhimsen jhoshi", 2005, "hindustani classical vocalist", false, 88, "gadag");
		KRAwardeesDTO dto4 = new KRAwardeesDTO(5, "Bhimsen jhoshi", 2005, "hindustani classical vocalist", false, 88, "gadag");
		KRAwardeesDTO dto5 = new KRAwardeesDTO(6, "Bhimsen jhoshi", 2005, "hindustani classical vocalist", false, 88, "gadag");

		KRAwardeesRepository repository = new KRAwardeesRepositoryImpl();
				
		KRAwardeesServiceImpl service = new KRAwardeesServiceImpl(repository);
//		service.validateAndSave(dto);
//		service.validateAndSave(dto1);
//		service.validateAndSave(dto2);
//		service.validateAndSave(dto3);
		
//		service.validateAndSave(dto4);
		service.validateAndSave(dto5);
	}

}
