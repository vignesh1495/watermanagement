package com.example.geektrust.entites;

import java.util.HashMap;

public class CostList {
	
	
	private Integer id;
	private Double corporationPrice;
	private Double borewellPrice;
	HashMap<String,Double>slabmap = new HashMap<String,Double>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCorporationPrice() {
		return corporationPrice;
	}
	public void setCorporationPrice(Double corporationPrice) {
		this.corporationPrice = corporationPrice;
	}
	public Double getBorewellPrice() {
		return borewellPrice;
	}
	public void setBorewellPrice(Double borewellPrice) {
		this.borewellPrice = borewellPrice;
	}
	public HashMap<String, Double> getSlabmap() {
		return slabmap;
	}
	public void setSlabmap(HashMap<String, Double> slabmap) {
		this.slabmap = slabmap;
	}
	
	@Override
	public String toString() {
		return "CostList [corporationPrice=" + corporationPrice + ", borewellPrice=" + borewellPrice + ", slabmap="
				+ slabmap + "]";
	}

	
	
}
