package fr.polytech.com.models;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;


public class Level implements Serializable{
	private String name;
	private String background;
	private ArrayList<Stand> stands;
	private Size size;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public ArrayList<Stand> getStands() {
		return stands;
	}
	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	
	
}
