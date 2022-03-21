package com.watermanage.services;

import com.watermanage.entites.Apartment;
import com.watermanage.entites.WaterBill;
import com.watermanage.repository.IApartmentRepository;

public class AllotWaterService implements IAllotWaterService{
	
	
	private final IApartmentRepository iapartmentRepository;
	public AllotWaterService(IApartmentRepository iapartmentRepository) {
		this.iapartmentRepository=iapartmentRepository;
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
    	apartment.setApartmenttype(waterratio);
      	
    	bill.setId(1);
    	bill.setApartmentid(apartment.getId());
    	
    	int tenetlitre = 0;
    	int totallitre = 0;
    	
    	if(apartmenttype.equalsIgnoreCase("3")) {
    	
    		tenetlitre=1500;
    	}
    	
    	if(apartmenttype.equalsIgnoreCase("2")) {
    		
    		tenetlitre=900;
    	}

    	
    	double costForCorporationandBorewellWater = getCostForCorporationandBorewellWater
    						(tenetlitre,corporationWaterRatio,BorewellWaterRatio,bill);			
		
    	System.out.println(bill.toString());
    	System.out.println(apartment.toString());
    	iapartmentRepository.addApartment(apartment);
    	System.out.println(costForCorporationandBorewellWater);
	}
	
	
	  public static double getCostForCorporationandBorewellWater(double tenetlitre, Integer corporationWaterRatio,
	    		Integer BorewellWaterRatio,WaterBill bill) {
				
	    	
	    	
	    	double totalRatio = corporationWaterRatio+BorewellWaterRatio;
	    	
	    	double corporationprice=tenetlitre*(corporationWaterRatio/totalRatio);
	    	
	    	double borewellprice=tenetlitre*(BorewellWaterRatio/totalRatio);
	    	
	    	bill.setCorporationWaterCost(corporationprice*1);
	    	bill.setBorewellWaterCost(borewellprice*1.5);
	    	
	    	return (corporationprice*1)+(borewellprice*1.5);
	    }

}
