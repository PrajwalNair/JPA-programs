package com.xworkz.hotel.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.hotel.dto.HotelDTO;

public class HotelRepositoryImpl implements HotelRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager = null;

	@Override
	public boolean save(HotelDTO dto) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}

		return false;
	}

}
