package fr.polytech.com.models;

public class Circle extends Shape {
	private int size;
	
	public Circle(Pos pos,int size) {
		super(pos);
		this.type="circle";
		this.size=size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

//	@Override
//	public String toString() {
//		return "Circle ["+"type:"+type+",size=" + size + "]";
//	}
	
}
