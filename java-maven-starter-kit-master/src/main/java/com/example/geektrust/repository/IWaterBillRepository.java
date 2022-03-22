package com.example.geektrust.repository;

import com.example.geektrust.entites.WaterBill;

public interface IWaterBillRepository {
	
	
	WaterBill getWaterBillByApartmentId(Integer id);

	void addWaterBill(WaterBill waterbill);

	void updateWaterBill(WaterBill waterbill);

}
