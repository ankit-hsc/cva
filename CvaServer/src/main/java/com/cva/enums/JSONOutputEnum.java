package com.cva.enums;

public enum JSONOutputEnum {

	FAILURE(0),SUCCESS(1);
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	JSONOutputEnum(int s){
		value=s;
	}

}
