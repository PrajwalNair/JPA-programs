package com.xworkz.hostel.repository;

import com.xworkz.hostel.dto.HostelDTO;

public interface HostelRepository {
	boolean save(HostelDTO dto);
	
	HostelDTO findByid(int id);
	

}
