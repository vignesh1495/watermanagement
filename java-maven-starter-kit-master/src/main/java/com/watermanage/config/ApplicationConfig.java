package com.watermanage.config;

import com.watermanage.commands.AddGuestCommand;
import com.watermanage.commands.AllotWaterCommand;
import com.watermanage.commands.CommandInvoker;
import com.watermanage.commands.GenerateBillCommand;
import com.watermanage.data.CostListData;
import com.watermanage.data.DataLoader;
import com.watermanage.repository.ApartmentRepository;
import com.watermanage.repository.CostListRepository;
import com.watermanage.repository.IApartmentRepository;
import com.watermanage.repository.ICostListRepository;
import com.watermanage.services.AddGuestService;
import com.watermanage.services.AllotWaterService;
import com.watermanage.services.IAddGuestService;
import com.watermanage.services.IAllotWaterService;

public class ApplicationConfig {
	
	private final CommandInvoker commandInvoker = new CommandInvoker();
	private final ICostListRepository iCostListRepository = new CostListRepository();
	private final IApartmentRepository iapartmentRepository = new ApartmentRepository();

	private final IAllotWaterService allotWaterSerivce = new AllotWaterService(iapartmentRepository);
	private final IAddGuestService  addGuestSerivce = new AddGuestService();
	private final DataLoader dataLoader = new DataLoader();
	
	
	
	public CommandInvoker getCommandInvoker() {
        commandInvoker.register("ALLOT_WATER", new AllotWaterCommand(allotWaterSerivce));
        commandInvoker.register("ADD_GUESTS", new AddGuestCommand(addGuestSerivce));
        commandInvoker.register("BILL", new GenerateBillCommand());
        return commandInvoker;
    }
	
	public DataLoader getDataLoader() {
        dataLoader.register("INPUT_DATA", new CostListData(iCostListRepository));

        return dataLoader;
    }

}
