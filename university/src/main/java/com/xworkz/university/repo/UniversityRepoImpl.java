package com.xworkz.university.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.university.entity.UniversityEntity;
import com.xworkz.university.util.EMFUtil;

public class UniversityRepoImpl implements UniversityRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	public boolean save(List<UniversityEntity> list) {
		EntityManager manager = factory.createEntityManager();
		int count = 0;
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (UniversityEntity universityEntity : list) {
				manager.persist(universityEntity);
				count++;
				if (count == 20) {
					manager.flush();
					System.out.println("flushed");
					count = 0;
				}

			}
//			System.out.println(list);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return false;
	}

	public Optional<UniversityEntity> findNameById(int id) {
		EntityManager manager = factory.createEntityManager();
		UniversityEntity find = manager.find(UniversityEntity.class, id);
		if (find != null) {
			System.out.println("data is valid");
			return Optional.of(find);
		} else {
			System.out.println("id is invalid " + id);
		}
		return Optional.empty();
	}

}
