package com.watermanage.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.watermanage.commands.CommandInvoker;
import com.watermanage.config.ApplicationConfig;
import com.watermanage.data.DataLoader;
import com.watermanage.entites.CostList;
import com.watermanage.execptions.NoSuchCommandException;
import com.watermanage.execptions.NoSuchDataException;



public class Main {
	
	 ApplicationConfig applicationConfig = new ApplicationConfig();
    public static void main(String[] args) throws NoSuchDataException  {
    	
    	
    	
    	new Main().executeJob();
    
         
         
         
//         
//	
//    	String allotwater = "2 3:7";
//    	Integer guests =5;
//    	String apartmenttype=allotwater.split(" ")[0];
//  
//    	String waterratio = allotwater.split(" ")[1];
//    	Integer corporationWaterRatio =  Integer.parseInt(waterratio.split(":")[0]);
//    	Integer BorewellWaterRatio =  Integer.parseInt(waterratio.split(":")[1]);
//    
//    	
//    	int tenetlitre = 0;
//    	int totallitre = 0;
//    	
//    	if(apartmenttype.equalsIgnoreCase("3")) {
//    		tenetlitre=1500;
//    	}
//    	
//    	if(apartmenttype.equalsIgnoreCase("2")) {
//    		tenetlitre=900;
//    	}
//
//    	
//    	double costForCorporationandBorewellWater = getCostForCorporationandBorewellWater
//    						(tenetlitre,corporationWaterRatio,BorewellWaterRatio);
//    	
//    	System.out.println(costForCorporationandBorewellWater);
//    	
//    	Integer tankerlitre=guests*30*10;
//    	
//    	
//    	double costForTankerWater =	getCostForTankerWater(tankerlitre);
//    	
//    	
//    	totallitre=tankerlitre+tenetlitre;
//    	
//    	System.out.println("Total Litre: "+totallitre);
//    	
//    	System.out.println("Total Cost: "+(costForTankerWater+costForCorporationandBorewellWater));
	}
    
    
    
    public void executeJob() {
   try {	
	   

       String datafilepath = "F:\\java-maven\\java-maven-starter-kit-master\\src\\main\\java\\com\\watermanage\\util\\common.txt";
      
       DataLoader dataLoader = applicationConfig.getDataLoader();
       dataLoader.executeData("INPUT_DATA", datafilepath);
    	
    	String commandpath = "F:\\java-maven\\java-maven-starter-kit-master\\src\\main\\java\\com\\watermanage\\util\\input.txt";

       
       
       readInputFile(commandpath," ");
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
   
    
    public static double getCostForCorporationandBorewellWater(double tenetlitre, Integer corporationWaterRatio,
    		Integer BorewellWaterRatio) {
			
    	
    	
    	double totalRatio = corporationWaterRatio+BorewellWaterRatio;
    	
    	double corporationprice=tenetlitre*(corporationWaterRatio/totalRatio);
    	
    	double borewellprice=tenetlitre*(BorewellWaterRatio/totalRatio);
    	
    	
    	return (corporationprice*1)+(borewellprice*1.5);
    }
    
    
    public static double getCostForTankerWater(double tankerlitre) {
		
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
    	
  
    	
    	return tankerprice;
    }
    
    
    public  void readInputFile(String dataPath, String delimiter) throws NoSuchCommandException {
    	 CommandInvoker commandinvoker=applicationConfig.getCommandInvoker();
    	try {
    	BufferedReader reader;
       

             reader = new BufferedReader(new FileReader(dataPath));

             String line = reader.readLine();
          
             while (line != null) {
                 System.out.println(line);
              
                 if(line.contains("ALLOT_WATER")) {
                	
                	commandinvoker.executeCommand("ALLOT_WATER", line);
                 }else if (line.contains("ADD_GUESTS")) {
                	
                	 
                 }else if (line.contains("BILL")) {
                	 
                 }
                 line = reader.readLine();
             }
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
/*    
    public void dataFile(String dataPath, String delimiter) {
   	 BufferedReader reader;
   	 CostList clist = new CostList();
        try {

            reader = new BufferedReader(new FileReader(dataPath));

            String line = reader.readLine();
            int i=0;
            while (line != null) {
            	if(i==0) {
            	   String normalpricelist=line.split(" ")[1];
            	   String corporationstringprice=normalpricelist.split(",")[0];	
            	   String borewellstringprice=normalpricelist.split(",")[1];
            	   
            	   Double cprice = Double.parseDouble(corporationstringprice.split(":")[1]);
            	   Double bprice = Double.parseDouble(borewellstringprice.split(":")[1]);
            	   clist.setCorporationPrice(cprice);
            	   clist.setBorewellPrice(bprice);
            	}
            	if (i ==1) {
            		HashMap<String,Double> map = new HashMap<String,Double>();
            		  String slabstring=line.split(" ")[1];
            		  String[] pricelist=slabstring.split(",");
            		  map.put("0 to 500L",Double.parseDouble(pricelist[0]));
            		  map.put("501L to 1500L",Double.parseDouble(pricelist[1]));
            		  map.put("1501 to 3000L",Double.parseDouble(pricelist[2]));
            		  map.put("3001L+",Double.parseDouble(pricelist[3]));
            		  clist.setSlabmap(map);
            	}
            	i++;
                line = reader.readLine();
            }
            System.out.println(clist.toString());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
*/    
    
    
    
    
}
