package com.example.geektrust.services;

import com.example.geektrust.entites.Apartment;
import com.example.geektrust.repository.IApartmentRepository;

public class AddGuestService implements IAddGuestService{

	private final IApartmentRepository iapartmentRepository;

	public AddGuestService(IApartmentRepository iapartmentRepository) {
		this.iapartmentRepository=iapartmentRepository;
	}
	
	
	@Override
	public void execute(String commandline) {
	
		String guestcommand = commandline.split(" ", 2)[1];
    	String guestcount=guestcommand.split(" ")[0];
    	Apartment apartment=iapartmentRepository.getApartmentById(1);
    	apartment.setGuest(apartment.getGuest()+Integer.parseInt(guestcount));
    	iapartmentRepository.updateApartment(apartment);
    	
    	
	}

}
