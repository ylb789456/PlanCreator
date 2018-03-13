package fr.polytech.com.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Job implements Serializable{
	private int id;
	private String name;
	private String description;
	private String icon;
	private ArrayList<Integer> categories;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public ArrayList<Integer> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Integer> categories) {
		this.categories = categories;
	}
	
	
	
	
}
