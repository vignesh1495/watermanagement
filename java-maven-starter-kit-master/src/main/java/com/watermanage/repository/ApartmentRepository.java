package com.watermanage.repository;

import java.util.HashMap;
import java.util.Map;

import com.watermanage.entites.Apartment;
import com.watermanage.entites.CostList;

public class ApartmentRepository implements IApartmentRepository {

	  private final Map<Integer, Apartment> apartmentMap;
	  
	
	  public ApartmentRepository() {
		  apartmentMap = new HashMap<>();
	}
	  
	@Override
	public Apartment getApartmentById(Integer id) {
	
		return apartmentMap.get(id);
	}

	@Override
	public void addApartment(Apartment apartment) {
		apartmentMap.put(apartment.getId(), apartment);
		
		
	}

	@Override
	public void updateApartment(Apartment apartment) {
		
		apartmentMap.put(apartment.getId(), apartment);
	}

}
