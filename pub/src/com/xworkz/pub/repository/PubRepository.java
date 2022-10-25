package com.xworkz.pub.repository;

import com.xworkz.pub.dto.PubDTO;

public interface PubRepository {
	boolean save(PubDTO dto);
	PubDTO findById(int id);
	void updateStateByName(String name,String newState);
	void deleteByName(String name);

}
