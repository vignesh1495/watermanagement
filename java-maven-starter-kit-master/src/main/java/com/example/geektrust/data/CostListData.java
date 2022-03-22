package com.example.geektrust.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.example.geektrust.entites.CostList;
import com.example.geektrust.repository.ICostListRepository;




public class CostListData implements IData {
	
	private final ICostListRepository iCostListRepository;
	
	public CostListData(ICostListRepository iCostListRepository) {
		this.iCostListRepository =iCostListRepository;
	}

//	
//	  @Override
//	    public void loadData(String dataPath, String delimiter) {
//		  
//		   	 BufferedReader reader;
//		   	 CostList clist = new CostList();
//		        try {
//
//		            reader = new BufferedReader(new FileReader(dataPath));
//
//		            String line = reader.readLine();
//		            int i=0;
//		            while (line != null) {
//		            	if(i==0) {
//		            	   String normalpricelist=line.split(" ")[1];
//		            	   String corporationstringprice=normalpricelist.split(",")[0];	
//		            	   String borewellstringprice=normalpricelist.split(",")[1];
//		            	   
//		            	   Double cprice = Double.parseDouble(corporationstringprice.split(":")[1]);
//		            	   Double bprice = Double.parseDouble(borewellstringprice.split(":")[1]);
//		            	   clist.setId(1);
//		            	   clist.setCorporationPrice(cprice);
//		            	   clist.setBorewellPrice(bprice);
//		            	}
//		            	if (i ==1) {
//		            		HashMap<String,Double> map = new HashMap<String,Double>();
//		            		  String slabstring=line.split(" ")[1];
//		            		  String[] pricelist=slabstring.split(",");
//		            		  map.put("0 to 500L",Double.parseDouble(pricelist[0]));
//		            		  map.put("501L to 1500L",Double.parseDouble(pricelist[1]));
//		            		  map.put("1501 to 3000L",Double.parseDouble(pricelist[2]));
//		            		  map.put("3001L+",Double.parseDouble(pricelist[3]));
//		            		  clist.setSlabmap(map);
//		            	}
//		            	i++;
//		                line = reader.readLine();
//		            }
//		            iCostListRepository.saveCostList(clist);
//		            reader.close();
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//		   
//	  }
	  
	  
	  @Override
	    public void loadData() {
		  
	
		   	 CostList clist = new CostList();
		        try {

		       
		           
		            	   clist.setId(1);
		            	   clist.setCorporationPrice(1.0);
		            	   clist.setBorewellPrice(1.5);
		            	
		            
		            		HashMap<String,Double> map = new HashMap<String,Double>();
		            		 
		            		  map.put("0 to 500L",Double.parseDouble("2"));
		            		  map.put("501L to 1500L",Double.parseDouble("3"));
		            		  map.put("1501 to 3000L",Double.parseDouble("5"));
		            		  map.put("3001L+",Double.parseDouble("8"));
		            		  clist.setSlabmap(map);
		            		  iCostListRepository.saveCostList(clist);
		            }
		           
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		   
	  }

}
