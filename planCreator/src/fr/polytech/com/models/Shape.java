package fr.polytech.com.models;

import java.io.Serializable;

public abstract class Shape implements Serializable{
	protected String type;
	protected Pos pos;
	
	public Shape(Pos pos) {
		super();
		this.pos=pos;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Pos getPos() {
		return pos;
	}
	public void setPos(Pos pos) {
		this.pos = pos;
	}

//	@Override
//	public String toString() {
//		return "Shape [type=" + type + ", pos=" + pos + "]";
//	}
	
	
	
}
