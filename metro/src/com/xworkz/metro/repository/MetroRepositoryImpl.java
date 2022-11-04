package com.xworkz.metro.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.metro.entity.MetroEntity;

public class MetroRepositoryImpl implements MetroRepository {

	@Override
	public boolean save(MetroEntity entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return false;
	}

}
