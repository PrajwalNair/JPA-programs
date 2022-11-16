package com.xworkz.jewellery.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.jewellery.entity.GoldJewelleryEntity;
import com.xworkz.jewellery.util.EMFUtil;

public class GoldJewelleryRepoImpl implements GoldJewelleryRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	public boolean save(GoldJewelleryEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return true;
	}

	public boolean save(List<GoldJewelleryEntity> list) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (GoldJewelleryEntity goldJewelleryEntity : list) {
				manager.persist(goldJewelleryEntity);
			}
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return false;
	}

	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByShopNameAndId");

			query.setParameter("tag", id);
			query.setParameter("sh", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				GoldJewelleryEntity ref = (GoldJewelleryEntity) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("data is not present for " + id + shopName);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();
	}

	public Optional<String> findShopNameById(int id) {

		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findShopNameById");

			query.setParameter("tag", id);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				String ref = (String) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("data is not present for " + id);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();
	}

	public Optional<Double> findMakingChargesByShopName(String shopName) {

		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findMakingChargesByShopName");

			query.setParameter("sh", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Double ref = (Double) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("data is not present for " + shopName);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();
	}

	public Optional<Object[]> findWasteAgeChargesAndMakingChargesByShopName(String shopName) {

		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findWasteAgeChargesAndMakingChargesByShopName");

			query.setParameter("sh", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {

				Object[] ref = (Object[]) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("data is not present for " + shopName);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();
	}

	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {

		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findTotalPriceByGramAndShopName");

			query.setParameter("gm", gram);
			query.setParameter("sh", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {

				Double ref = (Double) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("data is not present for " + shopName);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();
	}

	public Optional<List<GoldJewelleryEntity>> findMakingChargesByShopNames(String shopName) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findMakingChargesByShopNames");

			query.setParameter("sh", shopName);
			List<GoldJewelleryEntity> resultList = query.getResultList();
			if (resultList != null) {
				System.out.println("data is valid");
				return Optional.of(resultList);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

}
