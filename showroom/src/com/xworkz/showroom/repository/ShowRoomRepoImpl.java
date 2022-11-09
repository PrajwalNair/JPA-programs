package com.xworkz.showroom.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.showroom.entity.ShowroomEntity;
import com.xworkz.showroom.util.EMFUtil;

public class ShowRoomRepoImpl implements ShowRoomRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	@Override
	public boolean save(ShowroomEntity entity) {
		EntityManager manager = factory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} finally {
			manager.close();
		}

		return true;

	}

	@Override
	public boolean save(List<ShowroomEntity> list) {
		EntityManager manager = factory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			for (ShowroomEntity showroomEntity : list) {
				manager.persist(showroomEntity);
			}
			transaction.commit();
			System.out.println(list);
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Optional<ShowroomEntity> findById(int id) {
		EntityManager manager = factory.createEntityManager();
		try {
			ShowroomEntity find = manager.find(ShowroomEntity.class, id);
			if (find != null) {
				System.out.println("id is valid" + find);
				Optional.of(find);
			} else {
				System.out.println("id is not valid" + id);
			}
		} finally {
			manager.close();
		}

		return Optional.empty();

	}

	@Override
	public void updateNameById(int id, String name) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ShowroomEntity find = manager.find(ShowroomEntity.class, id);
			if (find != null) {
				find.setName(name);
				manager.persist(find);
				transaction.commit();
				System.out.println("name is updated");

			} else {
				System.out.println("id is not valid" + id);
			}
		} finally {
			manager.close();
		}

	}

	@Override
	public void deleteById(int id) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ShowroomEntity find = manager.find(ShowroomEntity.class, id);
			if (find != null) {

				manager.remove(find);
				transaction.commit();
				System.out.println("name is deleted");

			} else {
				System.out.println("id is not valid" + id);
			}
		} finally {
			manager.close();
		}

	}

}
