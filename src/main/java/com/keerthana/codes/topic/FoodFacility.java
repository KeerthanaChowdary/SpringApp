package com.keerthana.codes.topic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodFacility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String locationId; //0
	private String applicant; //1
	private String status;//10
	private String address; //5
	
	/*private String id;
	private String name;
	private String description;*/
	
	public FoodFacility() {
	}
	
	public FoodFacility(String id, String name, String status, String address) {
		this.locationId = id;
		this.applicant = name;
		this.status = status;
		this.address = address;
	}
	/*public FoodFacility(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}*/
}
