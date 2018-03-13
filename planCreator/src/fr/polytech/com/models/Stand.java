package fr.polytech.com.models;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JButton;

import fr.polytech.com.tools.CircleJButton;

public class Stand implements Serializable {
	private int idCompany;
	private Shape shape;
	
	public Stand() {
		
	}
	
	public Stand(int idCompany, Shape shape) {
		super();
		this.idCompany = idCompany;
		this.shape = shape;
	}
	
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public void setShape(JButton btn) {
		Pos position=new Pos(btn.getLocation().x,btn.getLocation().y);
		double width=btn.getSize().getWidth();
		double height=btn.getSize().getHeight();
		if(btn.getClass().equals(CircleJButton.class)) {
			this.shape= new Circle(position, new Double(width).intValue());
		}
		else {
			Size size=new Size((new Double(width)).intValue(),(new Double(height)).intValue());
			this.shape=new fr.polytech.com.models.Rectangle(position, size, 0);
		}
	}

	@Override
	public String toString() {
		return "Stand [idCompany=" + idCompany + ", shape=" + shape + "]";
	}
	
	
	
}
