package com.xworkz.jewellery.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	public Optional<String> findShopNameByIds(int id) {
		EntityManager manager = factory.createEntityManager();
		GoldJewelleryEntity find = manager.find(GoldJewelleryEntity.class, id);
		if (find != null) {
			System.out.println("data is valid");
			Optional.of(find);
		} else {
			System.out.println("id is invalid" + id);
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

	public Collection<GoldJewelleryEntity> getAll() {
		EntityManager manager = factory.createEntityManager();
		try {
			return manager.createNamedQuery("getAll").getResultList();
		} finally {
			manager.close();
		}

	}

	@Override
	public Collection<String> getAllShopName() {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return createEntityManager.createNamedQuery("getAllShopName").getResultList();
		} finally {
			createEntityManager.close();
		}

	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return createEntityManager.createNamedQuery("getAllShopNameAndType").getResultList();
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {

		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager.createNamedQuery("findAllByMakingChargesGreaterThan")
					.setParameter("ch", charges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan(double charges) {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager.createNamedQuery("findAllByWasteageChargesLessThan")
					.setParameter("ch", charges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(
			double wasteAgecharges, double makingCharges) {

		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager
					.createNamedQuery("findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan")
					.setParameter("wa", wasteAgecharges).setParameter("mk", makingCharges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAll() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<GoldJewelleryEntity> query = manager.createNamedQuery("findAll", GoldJewelleryEntity.class);
		List<GoldJewelleryEntity> resultList = query.getResultList();
		if (resultList != null) {
			System.out.println("data is valid");
			return Optional.of(resultList);
		}
		return Optional.empty();
	}

	@Override
	public Optional<GoldJewelleryEntity> displayByShopName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("displayByShopName");
		query.setParameter("nm", name);
		Object singleResult = query.getSingleResult();
		if (singleResult != null) {
			System.out.println("data is valid");
			GoldJewelleryEntity ref = (GoldJewelleryEntity) singleResult;
			return Optional.of(ref);
		}
		return Optional.empty();
	}

	@Override
	public Collection<GoldJewelleryEntity> allItems() {
		EntityManager manager = factory.createEntityManager();
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<GoldJewelleryEntity> createQuery = criteriaBuilder.createQuery(GoldJewelleryEntity.class);
		Root<GoldJewelleryEntity> from = createQuery.from(GoldJewelleryEntity.class);
		createQuery.select(from);
		TypedQuery<GoldJewelleryEntity> createQuery2 = manager.createQuery(createQuery);
		List<GoldJewelleryEntity> resultList = createQuery2.getResultList();
		if (resultList != null) {
			System.out.println("data is valid");
			return resultList;
		}
		return null;
	}

}
