package com.xworkz.stadium.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFUtil {
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("com.xworkz");
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}

}
