package com.xworkz.krawardees.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.krawardees.dto.KRAwardeesDTO;

public class KRAwardeesRepositoryImpl implements KRAwardeesRepository {

	@Override
	public boolean save(KRAwardeesDTO dto) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			manager.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return true;
	}

}
