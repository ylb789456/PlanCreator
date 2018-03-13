package fr.polytech.com.models;

import java.io.Serializable;

public class Company implements Serializable{
	private int id;
	private String name;
	private String description;
	private String icon;
	
	public Company(int id, String name, String description, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
	}

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
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + "]";
	}
}
