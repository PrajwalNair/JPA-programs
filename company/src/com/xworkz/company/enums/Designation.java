package com.xworkz.company.enums;

public enum Designation {
	MANAGER("manager"), ARCHITECT("architect"), SRDEVELOPER("sr.developer"), JRDEVELOPER("jr.developer");

	private String value;

	private Designation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static Designation getByValue(String name) {
		Designation[] designations=Designation.values();
		for(Designation designation1:designations) {
			if(designation1.value.equals(name)) {
				System.out.println("Is comparing");
				return designation1;
			}
		}
		return null;
		
	}

}
