package com.xworkz.human.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.util.EMFUtil;

public class HumanRepositoryImpl implements HumanRepository {
	EntityManagerFactory factory = EMFUtil.getFactory();
	EntityManager manager = null;

	@Override
	public boolean save(HumanEntity entity) {

		try {
			factory = Persistence.createEntityManagerFactory("com.xworkz");
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (PersistenceException e) {
			manager.close();
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Optional<HumanEntity> findById(int id) {
		manager = factory.createEntityManager();
		HumanEntity find = manager.find(HumanEntity.class, id);
		if (find != null) {
			System.out.println("id is found :" + find);
			Optional.of(find);
		} else {
			System.out.println("id is not stored in the table :" + id);
		}
		return Optional.empty();
	}

}
