package com.watermanage.commands;

import com.watermanage.services.IAddGuestService;
import com.watermanage.services.IAllotWaterService;

public class AddGuestCommand implements ICommand{
	
	
	public IAddGuestService addGuestService;
	
	  public AddGuestCommand(IAddGuestService addGuestService) {
	        this.addGuestService = addGuestService;
	    }

	@Override
	public void execute(String line) {
	
		
	}

}
