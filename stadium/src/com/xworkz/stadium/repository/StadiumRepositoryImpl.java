package com.xworkz.stadium.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.stadium.entity.StadiumEntity;

public class StadiumRepositoryImpl implements StadiumRepository {

	@Override
	public boolean save(StadiumEntity entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		
		return false;
	}

}
