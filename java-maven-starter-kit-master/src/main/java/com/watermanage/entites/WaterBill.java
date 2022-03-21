package com.watermanage.entites;

public class WaterBill {
	
	private Integer id;
	private Integer apartmentid;
	private double corporationWaterCost;
	private double borewellWaterCost;
	private double tankerCost;
	private double totalCost;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getApartmentid() {
		return apartmentid;
	}
	public void setApartmentid(Integer apartmentid) {
		this.apartmentid = apartmentid;
	}
	public double getCorporationWaterCost() {
		return corporationWaterCost;
	}
	public void setCorporationWaterCost(double corporationWaterCost) {
		this.corporationWaterCost = corporationWaterCost;
	}
	public double getBorewellWaterCost() {
		return borewellWaterCost;
	}
	public void setBorewellWaterCost(double borewellWaterCost) {
		this.borewellWaterCost = borewellWaterCost;
	}
	public double getTankerCost() {
		return tankerCost;
	}
	public void setTankerCost(double tankerCost) {
		this.tankerCost = tankerCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "WaterBill [id=" + id + ", apartmentid=" + apartmentid + ", corporationWaterCost=" + corporationWaterCost
				+ ", borewellWaterCost=" + borewellWaterCost + ", tankerCost=" + tankerCost + ", totalCost=" + totalCost
				+ "]";
	}
	
	

}
