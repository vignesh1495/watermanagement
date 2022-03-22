package com.example.geektrust.repository;

import com.example.geektrust.entites.Apartment;

public interface IApartmentRepository {
	
		
	Apartment getApartmentById(Integer id);

	void addApartment(Apartment apartment);

	void updateApartment(Apartment apartment);
}
