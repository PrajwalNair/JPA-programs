package com.xworkz.hotel.service;

import com.xworkz.hotel.dto.HotelDTO;
import com.xworkz.hotel.repository.HotelRepository;
import com.xworkz.hotel.repository.HotelRepositoryImpl;

public class HotelServiceImpl implements HotelService {
	HotelRepository repository = new HotelRepositoryImpl();

	@Override
	public boolean validateAndSave(HotelDTO dto) {
		int id = dto.getId();
		String name = dto.getName();
		String city = dto.getCity();
		if (id > 0) {
			System.out.println("id is valid");
			if (name != null && name.length() > 3 && name.length() < 25) {
				System.out.println("name is valid");
				if (city != null && city.length() > 3 && city.length() < 25) {
					System.out.println("city is valid");
					this.repository.save(dto);

				} else {
					System.err.println("city is invalid");
				}
			} else {
				System.err.println("name is invalid");
			}
		} else {
			System.err.println("id is invalid");
		}
		return false;
	}

}
