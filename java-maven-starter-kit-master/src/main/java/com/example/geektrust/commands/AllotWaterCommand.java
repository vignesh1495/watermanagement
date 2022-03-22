package com.example.geektrust.commands;

import com.example.geektrust.services.IAllotWaterService;

public class AllotWaterCommand implements ICommand{
	
	public IAllotWaterService allotWaterService;
	
	  public AllotWaterCommand(IAllotWaterService allotWaterService) {
	        this.allotWaterService = allotWaterService;
	    }

	@Override
	public void execute(String line) {
		allotWaterService.execute(line);
	}

}
