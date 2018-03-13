package fr.polytech.com.models;

import java.io.Serializable;

public class Size implements Serializable {
	private int width;
	private int height;
	
	public Size(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
//	@Override
//	public String toString() {
//		return "{\"width\":" + width + ",\"height\":" + height + "}";
//	}
//	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
