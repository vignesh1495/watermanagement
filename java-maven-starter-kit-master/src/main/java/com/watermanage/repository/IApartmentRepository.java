package com.watermanage.repository;

import com.watermanage.entites.Apartment;
import com.watermanage.entites.CostList;

public interface IApartmentRepository {
	
		
	Apartment getApartmentById(Integer id);

	void addApartment(Apartment apartment);

	void updateApartment(Apartment apartment);
}
