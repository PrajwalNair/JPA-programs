package com.xworkz.krawardees;

import com.xworkz.krawardees.dto.KRAwardeesDTO;
import com.xworkz.krawardees.service.KRAwardeesServiceImpl;

public class KRAwardeesDisplay {

	public static void main(String[] args) {
		KRAwardeesDTO dto = new KRAwardeesDTO(1, "punit rajkumar", 2022, "film", false, 50, "Bangalore");
		KRAwardeesDTO dto1 = new KRAwardeesDTO(2, "kuvempu", 1992, "poet", false, 89, "mysore");
		KRAwardeesDTO dto2 = new KRAwardeesDTO(3, "Dr. Rajkumar", 1992, "actor", false, 76, "Bangalore");
		KRAwardeesDTO dto3 = new KRAwardeesDTO(4, "Bhimsen jhoshi", 2005, "hindustani classical vocalist", false, 88, "gadag");

		KRAwardeesServiceImpl service = new KRAwardeesServiceImpl();
		service.validateAndSave(dto);
		service.validateAndSave(dto1);
		service.validateAndSave(dto2);
		service.validateAndSave(dto3);
	}

}
