package com.example.geektrust.services;

import com.example.geektrust.entites.Apartment;
import com.example.geektrust.entites.WaterBill;
import com.example.geektrust.repository.IApartmentRepository;
import com.example.geektrust.repository.IWaterBillRepository;

public class GenerateBillService implements IGenerateBillService {
	
	
	private final IApartmentRepository iapartmentRepository;
	private final IWaterBillRepository iWaterBillRepository;
	public GenerateBillService(IApartmentRepository iapartmentRepository,IWaterBillRepository iwaterRepository) {
		this.iapartmentRepository=iapartmentRepository;
		this.iWaterBillRepository=iwaterRepository;
	}

	@Override
	public void execute(String commandline) {
		
	Apartment apartment=iapartmentRepository.getApartmentById(1);
	Integer guests = apartment.getGuest();	
	
	Integer tankerlitre=guests*30*10;
	WaterBill bill=iWaterBillRepository.getWaterBillByApartmentId(1);
	bill.setTankerlitre(tankerlitre);
	
	
	getCostForTankerWater(tankerlitre,bill);

	

	
	iWaterBillRepository.updateWaterBill(bill);
	
	String totalcost = String.valueOf((int) bill.getTotalCost());
		
	System.out.println(bill.getTotallitre()+" "+totalcost);
	}

	
	 public static void getCostForTankerWater(double tankerlitre,WaterBill bill) {
			
	    	double tankerprice =0;
				
	    	if(tankerlitre<=500) {
	    		tankerprice+=tankerlitre*2;
	    	}else {
	    		tankerprice+=500*2;
	    	}
	    	
	    	if(tankerlitre<=1500 && tankerlitre>500) {
	    		tankerprice+=(tankerlitre-500)*3;
	    	}else if (tankerlitre>1500) {
	    		tankerprice+=1000*3;
	    	}
	    	
	    	if(tankerlitre<=3000 && tankerlitre>1500) {
	    		tankerprice+=(tankerlitre-1500)*5;
	    	}else if (tankerlitre>3000) {
	    		tankerprice+=1500*5;
	    	}
	    	
	    	if(tankerlitre>3000) {
	    		tankerprice+=(tankerlitre-3000)*8;
	    	}
	    	
	    	bill.setTankerCost(tankerprice);
	    	bill.setTotallitre(bill.getTenantlitre()+bill.getTankerlitre());
	    	Double  totalcost= Math.ceil((bill.getBorewellWaterCost()+bill.getCorporationWaterCost()+bill.getTankerCost()));
	    	bill.setTotalCost(totalcost.intValue());
	  
	    }
	    

	
}
