package com.sdp3.main.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Donate {
	@Id
	@GeneratedValue
	private int id;
	private String donatedBy;
	private String donatedTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonatedBy() {
		return donatedBy;
	}
	public void setDonatedBy(String donatedBy) {
		this.donatedBy = donatedBy;
	}
	public String getDonatedTo() {
		return donatedTo;
	}
	public void setDonatedTo(String donatedTo) {
		this.donatedTo = donatedTo;
	}
	public String getDonatedValue() {
		return donatedValue;
	}
	public void setDonatedValue(String donatedValue) {
		this.donatedValue = donatedValue;
	}
	public Date getDoantedDate() {
		return doantedDate;
	}
	public void setDoantedDate(Date doantedDate) {
		this.doantedDate = doantedDate;
	}
	private String donatedValue;
	private Date doantedDate;
	public Donate(int id, String donatedBy, String donatedTo, String donatedValue, Date doantedDate) {
		super();
		this.id = id;
		this.donatedBy = donatedBy;
		this.donatedTo = donatedTo;
		this.donatedValue = donatedValue;
		this.doantedDate = doantedDate;
	}
	public Donate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
