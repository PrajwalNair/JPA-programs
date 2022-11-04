package com.xworkz.stadium.enums;

public enum StadiumType {
	
	OUTDOOR("outdoor"),INDOOR("indoor");
	
	private String value;
	
	private StadiumType(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
