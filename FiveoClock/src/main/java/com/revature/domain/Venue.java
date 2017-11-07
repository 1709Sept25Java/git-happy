package com.revature.domain;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

@Entity

@Table(name = "VENUES")

public class Venue implements Serializable {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venueSequence")

	@SequenceGenerator(allocationSize = 1, name = "venueSequence", sequenceName = "SQ_VENUE_PK")

	@Column(name = "VENUE_ID")

	private int venueId;

	@Column(name = "NAME")

	private String venueName;

	@Column(name = "ADDRESS")

	private String address;

	@Column(name = "PHONE")

	private String phone;

	@OneToMany(mappedBy = "venue", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private List<Deal> deals;

	public Venue(String venueName, String address, String phone) {

		super();
		this.venueName = venueName;
		this.address = address;
		this.phone = phone;
	}

	public Venue() {

		super();

	}

	public int getVenueId() {

		return venueId;

	}

	public void setVenueId(int venueId) {

		this.venueId = venueId;

	}

	public String getVenueName() {

		return venueName;

	}

	public void setVenueName(String venueName) {

		this.venueName = venueName;

	}

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public List<Deal> getDeals() {

		return deals;

	}

	public void setDeals(List<Deal> deals) {

		this.deals = deals;

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String toStringWithDeals() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", address=" + address + ", phone=" + phone
				+ ", deals=" + deals + "]";
	}
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", address=" + address + ", phone=" + phone
				+ "]";
	}


	

}