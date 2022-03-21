package com.watermanage.commands;

import com.watermanage.services.IAllotWaterService;

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
