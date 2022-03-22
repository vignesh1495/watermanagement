package com.example.geektrust.config;

import com.example.geektrust.commands.AddGuestCommand;
import com.example.geektrust.commands.AllotWaterCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.GenerateBillCommand;
import com.example.geektrust.data.CostListData;
import com.example.geektrust.data.DataLoader;
import com.example.geektrust.repository.ApartmentRepository;
import com.example.geektrust.repository.CostListRepository;
import com.example.geektrust.repository.IApartmentRepository;
import com.example.geektrust.repository.ICostListRepository;
import com.example.geektrust.repository.IWaterBillRepository;
import com.example.geektrust.repository.WaterBillRepository;
import com.example.geektrust.services.AddGuestService;
import com.example.geektrust.services.AllotWaterService;
import com.example.geektrust.services.GenerateBillService;
import com.example.geektrust.services.IAddGuestService;
import com.example.geektrust.services.IAllotWaterService;
import com.example.geektrust.services.IGenerateBillService;

public class ApplicationConfig {
	
	private final CommandInvoker commandInvoker = new CommandInvoker();
	private final ICostListRepository icostListRepository = new CostListRepository();
	private final IApartmentRepository iapartmentRepository = new ApartmentRepository();
	private final IWaterBillRepository iwaterBillRepository = new WaterBillRepository();

	private final IAllotWaterService allotWaterSerivce = new AllotWaterService(iapartmentRepository,iwaterBillRepository);
	private final IAddGuestService  addGuestSerivce = new AddGuestService(iapartmentRepository);
	private final IGenerateBillService  generateBillService = new GenerateBillService(iapartmentRepository,iwaterBillRepository);

	private final DataLoader dataLoader = new DataLoader();
	
	
	
	public CommandInvoker getCommandInvoker() {
        commandInvoker.register("ALLOT_WATER", new AllotWaterCommand(allotWaterSerivce));
        commandInvoker.register("ADD_GUESTS", new AddGuestCommand(addGuestSerivce));
        commandInvoker.register("BILL", new GenerateBillCommand(generateBillService));
        return commandInvoker;
    }
	
	public DataLoader getDataLoader() {
        dataLoader.register("INPUT_DATA", new CostListData(icostListRepository));

        return dataLoader;
    }

}
