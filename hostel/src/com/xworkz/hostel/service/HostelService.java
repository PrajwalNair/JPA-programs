package com.xworkz.hostel.service;

import com.xworkz.hostel.dto.HostelDTO;

public interface HostelService {
	boolean validateAndSave(HostelDTO dto);
	HostelDTO findByid(int id);

}
