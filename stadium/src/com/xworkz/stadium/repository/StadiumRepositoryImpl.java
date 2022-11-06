package com.xworkz.stadium.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.util.EMFUtil;

public class StadiumRepositoryImpl implements StadiumRepository {
	EntityManagerFactory factory = EMFUtil.getFactory();

	@Override
	public boolean save(StadiumEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();

		return false;
	}

	@Override
	public Optional<StadiumEntity> findById(int id) {
		EntityManager manager = factory.createEntityManager();
		StadiumEntity find = manager.find(StadiumEntity.class, id);
		if (find != null) {
			System.out.println("id is found" + find);
			Optional.of(find);
		} else {
			System.out.println("id is not found" + id);
		}
		return Optional.empty();
	}

}
