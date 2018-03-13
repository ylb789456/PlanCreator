package fr.polytech.com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.tools.JavaCompiler;

import org.apache.commons.lang.math.Fraction;

public class Data implements Serializable{
	private String id;
	private Address address ;
	private String name;
	private String start;   //time format later
	private String end;
	private String icon;
	private String comments;
	private ArrayList<fr.polytech.com.models.Level> levels;
	private ArrayList<Job> jobs;
	private ArrayList<Company> companies;
	private ArrayList<JobCategory> jobCategories;
	private ArrayList<EndingForm> endingForm;
	private ArrayList<Beacon> beacons;
	private ArrayList<JobOffer> jobOffers;
	
	
//	@Override
//	public String toString() {
//		return "{\"id\":" + id + ",\"address\":" + address + ",\"name\":" + name + ",\"start\":" + start + ",\"end\":"
//				+ end + ",\"icon\":" + icon + ",\"comments\":" + comments + ",\"levels\":" + levels + ",\"jobs\":" + jobs
//				+ ",\"companies\":" + companies + ",\"jobCategories\":" + jobCategories + ",\"endingForm\":" + endingForm
//				+ ",\"beacons\":" + beacons + ",\"jobOffers\":" + jobOffers + "}";
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ArrayList<fr.polytech.com.models.Level> getLevels() {
		return levels;
	}
	public void setLevels(ArrayList<fr.polytech.com.models.Level> levels) {
		this.levels = levels;
	}
	public ArrayList<Job> getJobs() {
		return jobs;
	}
	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	public ArrayList<JobCategory> getJobCategories() {
		return jobCategories;
	}
	public void setJobCategories(ArrayList<JobCategory> jobCategories) {
		this.jobCategories = jobCategories;
	}
	public ArrayList<EndingForm> getEndingForm() {
		return endingForm;
	}
	public void setEndingForm(ArrayList<EndingForm> endingForm) {
		this.endingForm = endingForm;
	}
	public ArrayList<Beacon> getBeacons() {
		return beacons;
	}
	public void setBeacons(ArrayList<Beacon> beacons) {
		this.beacons = beacons;
	}
	public ArrayList<JobOffer> getJobOffers() {
		return jobOffers;
	}
	public void setJobOffers(ArrayList<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	
	
}
