package fr.polytech.com.models;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable{
	private Size size;
	private int rotation;
	
	public Rectangle(Pos pos,Size size,int rotation) {
		super(pos);
		this.type="rectangle";
		this.size=size;
		this.setRotation(rotation);
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

//	@Override
//	public String toString() {
//		return "Rectangle ["+"type:"+type+",size=" + size + ", rotation=" + rotation + "]";
//	}
	
}
