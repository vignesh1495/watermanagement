package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entites.Apartment;



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
