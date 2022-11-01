package com.xworkz.krawardees;

import com.xworkz.krawardees.dto.KRAwardeesDTO;
import com.xworkz.krawardees.service.KRAwardeesServiceImpl;

public class KRAwardeesDisplay {

	public static void main(String[] args) {
		KRAwardeesDTO dto = new KRAwardeesDTO(1, "punit rajkumar", 2022, "film", false, 50, "Bangalore");

		KRAwardeesServiceImpl service = new KRAwardeesServiceImpl();
		service.validateAndSave(dto);
	}

}
