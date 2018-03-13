package fr.polytech.com.models;

import java.io.Serializable;

public class JobOffer implements Serializable{
	private int idCompany;
	private int idJob;
	
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public int getIdJob() {
		return idJob;
	}
	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}
	
	
}
