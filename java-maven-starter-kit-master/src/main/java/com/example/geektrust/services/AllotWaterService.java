package com.example.geektrust.services;

import com.example.geektrust.entites.Apartment;
import com.example.geektrust.entites.WaterBill;
import com.example.geektrust.repository.IApartmentRepository;
import com.example.geektrust.repository.IWaterBillRepository;

public class AllotWaterService implements IAllotWaterService{
	
	
	private final IApartmentRepository iapartmentRepository;
	private final IWaterBillRepository iWaterBillRepository;
	
	public AllotWaterService(IApartmentRepository iapartmentRepository,IWaterBillRepository iwaterRepository) {
		this.iapartmentRepository=iapartmentRepository;
		this.iWaterBillRepository=iwaterRepository;
	}

	@Override
	public void execute(String commandline) {
		
		Apartment apartment  = new Apartment();
		WaterBill bill = new WaterBill();
	
    	String allotwater = commandline.split(" ", 2)[1];
    	String apartmenttype=allotwater.split(" ")[0];
    
   
    	String waterratio = allotwater.split(" ")[1];
  
    	Integer corporationWaterRatio =  Integer.parseInt(waterratio.split(":")[0]);
    	Integer BorewellWaterRatio =  Integer.parseInt(waterratio.split(":")[1]);
    	
    	
    	apartment.setId(1);
    	apartment.setGuest(0);
    	apartment.setApartmenttype(apartmenttype);
    	apartment.setWaterrateratio(waterratio);
      	
    	bill.setId(1);
    	bill.setApartmentid(apartment.getId());
    	
    	int tenantlitre = 0;
    	int totallitre = 0;
    	
    	if(apartmenttype.equalsIgnoreCase("3")) {
    	
    		tenantlitre=1500;
    		bill.setTenantlitre(tenantlitre);
    	}
    	
    	if(apartmenttype.equalsIgnoreCase("2")) {
    		
    		tenantlitre=900;
    		bill.setTenantlitre(tenantlitre);
    	}

    	
    	double costForCorporationandBorewellWater = getCostForCorporationandBorewellWater
    						(tenantlitre,corporationWaterRatio,BorewellWaterRatio,bill);			
		
 
    	iapartmentRepository.addApartment(apartment);
    	iWaterBillRepository.addWaterBill(bill);
  
	}
	
	
	  public static double getCostForCorporationandBorewellWater(double tenantlitre, Integer corporationWaterRatio,
	    		Integer BorewellWaterRatio,WaterBill bill) {
				
	    	
	    	
	    	double totalRatio = corporationWaterRatio+BorewellWaterRatio;
	    	
	    	double corporationprice=tenantlitre*(corporationWaterRatio/totalRatio);
	    	
	    	double borewellprice=tenantlitre*(BorewellWaterRatio/totalRatio);
	    	
	    	bill.setCorporationWaterCost(corporationprice*1);
	    	bill.setBorewellWaterCost(borewellprice*1.5);
	    	
	    	return (corporationprice*1)+(borewellprice*1.5);
	    }

}
