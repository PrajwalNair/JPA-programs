package com.xworkz.metro.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.util.EMFUtil;

public class MetroRepositoryImpl implements MetroRepository {

	EntityManagerFactory factory = EMFUtil.getFactory();
	EntityManager manager = null;

	@Override
	public boolean save(MetroEntity entity) {

		try {

			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	@Override
	public Optional<MetroEntity> findById(int id) {
		manager = factory.createEntityManager();
		MetroEntity find = manager.find(MetroEntity.class, id);
		if (find != null) {
			System.out.println("id is valid " + find);
			Optional.of(find);
		} else {
			System.out.println("id is not valid " + id);
		}
		return Optional.empty();
	}

}
