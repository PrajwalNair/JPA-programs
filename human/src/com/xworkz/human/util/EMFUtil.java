package com.xworkz.human.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Data;


public class EMFUtil {
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("com.xworkz");
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}

}
