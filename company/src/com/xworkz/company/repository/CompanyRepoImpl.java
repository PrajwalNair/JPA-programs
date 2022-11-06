package com.xworkz.company.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.company.entity.CompanyEntity;
import com.xworkz.company.util.EMFUtil;

public class CompanyRepoImpl implements CompanyRepo {

	EntityManagerFactory factory = EMFUtil.getFactory();
	EntityManager manager = null;

	@Override
	public boolean save(List<CompanyEntity> list) {

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
//			for (CompanyEntity companyEntity : list) {
//
//				manager.persist(companyEntity);
//
//				System.out.println(companyEntity);
//
//			}
			list.forEach(ref -> manager.persist(ref));
			System.out.println(list);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Optional<CompanyEntity> findByName(String name) {
		manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		Object singleResult = query.getSingleResult();
		if (singleResult != null) {
			System.out.println("running" + singleResult);
//			CompanyEntity entity = (CompanyEntity) singleResult;
			Optional.of(singleResult);
		}
		return Optional.empty();
	}

}
