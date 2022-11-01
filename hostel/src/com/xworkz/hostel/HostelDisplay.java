package com.xworkz.hostel;

import java.time.LocalDate;

import com.xworkz.hostel.dto.HostelDTO;
import com.xworkz.hostel.service.HostelService;
import com.xworkz.hostel.service.HostelServiceImpl;

public class HostelDisplay {

	public static void main(String[] args) {
		HostelDTO dto = new HostelDTO("Prajwal", LocalDate.now(), "Sharat", LocalDate.now(), "AGMR Hostel", "Male", "varur", "Hubli");
		HostelDTO dto1 = new HostelDTO("hanamant", LocalDate.now(), "prajwal", LocalDate.now(), "suhas Hostel", "Male", "btm", "bangalore");
		HostelDTO dto2 = new HostelDTO("Suhas", LocalDate.now(), "hanamant", LocalDate.now(), "hanamant Hostel", "Female", "dombivili", "mumbai");
		
		
		HostelService service = new HostelServiceImpl();
//		service.validateAndSave(dto);
//		service.validateAndSave(dto1);
//		service.validateAndSave(dto2);
		
		HostelDTO findByid = service.findByid(3);
		System.out.println(findByid);
		
	}

}
