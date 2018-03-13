package fr.polytech.com.models;

import java.io.Serializable;

public class Address implements Serializable{
	private String line1;
	private String city;
	
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	
//	@Override
//	public String toString() {
//		return "{\"line1\":" + line1 + ",\"city\":" + city + "}";
//	}
}
