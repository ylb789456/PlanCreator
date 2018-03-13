package fr.polytech.com.models;

import java.io.Serializable;

public class PossibleValue implements Serializable{
	private String name;
	private int value;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
