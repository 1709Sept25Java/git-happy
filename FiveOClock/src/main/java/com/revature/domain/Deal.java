package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="DEALS")
public class Deal implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="dealSequence")
	@SequenceGenerator(allocationSize=1, name="dealSequence", sequenceName = "SQ_DEALS_PK")
	@Column(name="DEAL_ID")
	private int dealId;
	
	@Column(name= "TYPE")
	private String type;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private double price; //needs javascript validation
	
	@Column(name = "START_TIME")
	private int startTime;
	
	@Column(name = "END_TIME")
	private int endTime;

	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VENUE_ID")
	private Venue venue;

	public Deal(String type, String description, double price, int startTime, int endTime, Venue venue, String status) {
		super();
		this.type = type;
		this.description = description;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.venue = venue;
	}

	public Deal() {
		super();
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
}
