package com.xworkz.jewellery.enums;

public enum JewelleryType {
	EARRINGS("Ear rings"), NECKLESS("neckless"), BRACELETT("Bracelett"), RING("ring");

	private String value;

	private JewelleryType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
