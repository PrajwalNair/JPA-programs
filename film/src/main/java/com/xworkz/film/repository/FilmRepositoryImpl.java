package com.xworkz.film.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.film.entity.FilmEntity;
import com.xworkz.film.util.EMFUtil;

public class FilmRepositoryImpl implements FilmRepository {

	EntityManagerFactory factory = EMFUtil.getFactory();

	public boolean save(List<FilmEntity> list) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			list.forEach(ref -> manager.persist(ref));
			System.out.println(list);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return true;
	}

	@Override
	public Optional<FilmEntity> findNameById(int id) {
		EntityManager manager = factory.createEntityManager();
		FilmEntity find = manager.find(FilmEntity.class, id);
		if (find != null) {
			System.out.println("id is valid (repo) " + find);
			return Optional.of(find);
		} else {
			System.out.println("id is invalid (repo) " + id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<FilmEntity> findLangByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query createNamedQuery = manager.createNamedQuery("findLangByName");
		createNamedQuery.setParameter("lg", name);
		Object singleResult = createNamedQuery.getResultList();
		if (singleResult != null) {
			FilmEntity ref = (FilmEntity) singleResult;
			return Optional.of(ref);
		}
		return null;
	}

	@Override
	public Optional<FilmEntity> findHero(String name) {
		EntityManager manager = factory.createEntityManager();
		Query createNamedQuery = manager.createNamedQuery("findHero");
		createNamedQuery.setParameter("h", name);
		Object singleResult = createNamedQuery.getSingleResult();
		if (singleResult != null) {
			FilmEntity ref = (FilmEntity) singleResult;
			return Optional.of(ref);
		}
		return null;
	}

}
