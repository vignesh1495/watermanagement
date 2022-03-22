package com.example.geektrust.commands;

import com.example.geektrust.services.IGenerateBillService;

public class GenerateBillCommand implements ICommand{

	
	
	private IGenerateBillService GenerateBillService;
	
	 public GenerateBillCommand(IGenerateBillService GenerateBillService) {
	        this.GenerateBillService = GenerateBillService;
	    }
	
	
	@Override
	public void execute(String line) {
		GenerateBillService.execute(line);
	}

}
