package com.example.geektrust.commands;

import com.example.geektrust.services.IAddGuestService;

public class AddGuestCommand implements ICommand{
	
	
	public IAddGuestService addGuestService;
	
	  public AddGuestCommand(IAddGuestService addGuestService) {
	        this.addGuestService = addGuestService;
	    }

	@Override
	public void execute(String line) {
	
		addGuestService.execute(line);
	}

}
