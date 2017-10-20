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
	private String expirationDate;//22
	private double xCoordinate;//12
	private double yCoordinate;//13

	/*private String id;
	private String name;
	private String description;*/

	public FoodFacility() {
	}

	public FoodFacility(String id, String name, String status, String address) {
		this(id, name, status, address, "", "0.0", "0.0");
	}

	public FoodFacility(String id, String name, String status, String address, String expDate) {
		this(id, name, status, address, expDate, "0.0", "0.0");
	}

	public FoodFacility(String id, String name, String status, String address, String string5, String x, String y) {
		this.locationId = id;
		this.applicant = name;
		this.status = status;
		this.address = address;
		this.expirationDate = string5;
		this.xCoordinate = Double.parseDouble(x);
		this.yCoordinate = Double.parseDouble(y);
	}

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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate() {
		this.expirationDate = "";
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	/*public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	*/
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
