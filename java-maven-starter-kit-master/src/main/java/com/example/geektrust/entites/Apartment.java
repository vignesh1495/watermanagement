package com.example.geektrust.entites;

public class Apartment {
	
	private Integer id;
	private String apartmenttype;
	private String waterrateratio;
	private Integer guest;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApartmenttype() {
		return apartmenttype;
	}
	public void setApartmenttype(String apartmenttype) {
		this.apartmenttype = apartmenttype;
	}
	public String getWaterrateratio() {
		return waterrateratio;
	}
	public void setWaterrateratio(String waterrateratio) {
		this.waterrateratio = waterrateratio;
	}
	public Integer getGuest() {
		return guest;
	}
	public void setGuest(Integer guest) {
		this.guest = guest;
	}
	
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", apartmenttype=" + apartmenttype + ", waterrateratio=" + waterrateratio
				+ ", guest=" + guest + "]";
	}
	
	
	

}
