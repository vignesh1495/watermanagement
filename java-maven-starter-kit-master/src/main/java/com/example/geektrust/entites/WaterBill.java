package com.example.geektrust.entites;

public class WaterBill {
	
	private Integer id;
	private Integer apartmentid;
	private Integer tenantlitre;
	private Integer tankerlitre;
	private Integer totallitre;
	private double corporationWaterCost;
	private double borewellWaterCost;
	private double tankerCost;
	private Integer totalCost;
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
	public Integer getTenantlitre() {
		return tenantlitre;
	}
	public void setTenantlitre(Integer tenantlitre) {
		this.tenantlitre = tenantlitre;
	}
	public Integer getTankerlitre() {
		return tankerlitre;
	}
	public void setTankerlitre(Integer tankerlitre) {
		this.tankerlitre = tankerlitre;
	}
	public Integer getTotallitre() {
		return totallitre;
	}
	public void setTotallitre(Integer totallitre) {
		this.totallitre = totallitre;
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
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "WaterBill [id=" + id + ", apartmentid=" + apartmentid + ", tenantlitre=" + tenantlitre
				+ ", tankerlitre=" + tankerlitre + ", totallitre=" + totallitre + ", corporationWaterCost="
				+ corporationWaterCost + ", borewellWaterCost=" + borewellWaterCost + ", tankerCost=" + tankerCost
				+ ", totalCost=" + totalCost + "]";
	}
	
	

	

	
	

}
