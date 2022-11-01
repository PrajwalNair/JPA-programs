package com.xworkz.hostel.repository;

import com.xworkz.hostel.dto.HostelDTO;
import static com.xworkz.hostel.util.EMFUtil.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;import javax.persistence.PersistenceException;
import javax.validation.Validation;
import javax.validation.Validator;

public class HostelRepositoryImpl implements HostelRepository {

	EntityManagerFactory factory = getFactory();
	EntityManager manager = null;
	
	@Override
	public boolean save(HostelDTO dto) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
		}
		
		return true;
	}
	
	@Override
	public HostelDTO findByid(int id) {
		
		try {
			manager = factory.createEntityManager();
			HostelDTO find = manager.find(HostelDTO.class, id);
			if(find!= null) {
				System.out.println("it is valid"+id);
				return find;
			}else {
				System.out.println("it is invalid");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return null;
	}

}
