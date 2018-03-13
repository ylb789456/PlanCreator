package fr.polytech.com.models;

import java.io.Serializable;
import java.util.ArrayList;

public class EndingForm implements Serializable{
	private String uniq;
	private String type;
	private String title;
	private ArrayList<PossibleValue> possibleValues;
	
	public String getUniq() {
		return uniq;
	}
	public void setUniq(String uniq) {
		this.uniq = uniq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<PossibleValue> getPossibleValues() {
		return possibleValues;
	}
	public void setPossibleValues(ArrayList<PossibleValue> possibleValues) {
		this.possibleValues = possibleValues;
	}
	

}
