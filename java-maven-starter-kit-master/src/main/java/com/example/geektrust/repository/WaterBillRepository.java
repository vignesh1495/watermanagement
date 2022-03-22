package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entites.WaterBill;


public class WaterBillRepository implements  IWaterBillRepository{
	
	private  Map<Integer,WaterBill> billmap = new HashMap<Integer,WaterBill>();

	@Override
	public WaterBill getWaterBillByApartmentId(Integer id) {
		
		Optional<WaterBill> bill=billmap.values().stream().filter(e->e.getApartmentid().equals(id)).findAny();
		if (bill.isPresent()) {
			return bill.get();
		}else {
			return null;
		}
	}

	@Override
	public void addWaterBill(WaterBill waterbill) {
	
		billmap.put(waterbill.getId(), waterbill);
	}

	@Override
	public void updateWaterBill(WaterBill waterbill) {
		
		billmap.put(waterbill.getId(), waterbill);
	}

}
