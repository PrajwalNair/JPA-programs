package com.xworkz.pub.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.pub.dto.PubDTO;

public class PubRepositoryImpl implements PubRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");

	@Override
	public boolean save(PubDTO dto) {
		System.out.println("data saved" + dto);

		EntityManager createEntityManager = factory.createEntityManager();
		try {
			// EntityManager createEntityManager = factory.createEntityManager();
			EntityTransaction transaction = createEntityManager.getTransaction();
			transaction.begin();
			createEntityManager.persist(dto);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			createEntityManager.close();
		}
		return false;
	}

	@Override
	public PubDTO findById(int id) {

		EntityManager manager = factory.createEntityManager();
		Query namedQuery = manager.createNamedQuery("findById");
		namedQuery.setParameter("id1", id);

		Object singleResult = namedQuery.getSingleResult();
		if (singleResult != null) {
			PubDTO dto = (PubDTO) singleResult;
			return dto;
		}
		return null;
	}

	@Override
	public void updateStateByName(String name, String newState) {
		EntityManager createEntityManager = factory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		Query createNamedQuery = createEntityManager.createNamedQuery("updateStateByName");
		createNamedQuery.setParameter("nm", name);
		createNamedQuery.setParameter("state1", newState);
		createNamedQuery.executeUpdate();
		transaction.commit();

	}

	@Override
	public void deleteByName(String name) {

		EntityManager createEntityManager = factory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		Query query = createEntityManager.createNamedQuery("deleteByName");
		query.setParameter("nm", name);
		query.executeUpdate();
		transaction.commit();
	}

}
