package com.example.geektrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.config.ApplicationConfig;
import com.example.geektrust.data.DataLoader;
import com.example.geektrust.execptions.NoSuchCommandException;
import com.example.geektrust.execptions.NoSuchDataException;





public class Main {
	
	 ApplicationConfig applicationConfig = new ApplicationConfig();
    public static void main(String[] args) throws NoSuchDataException  {
    	
    	String path =args[0];
       //	String path = "F:\\java-maven\\java-maven-starter-kit-master\\src\\main\\java\\com\\watermanage\\util\\input.txt";
    	
    	new Main().executeJob(path);
    
	}
    
    
    
    public void executeJob(String path) {
   try {	
	   

       //String datafilepath = "F:\\java-maven\\java-maven-starter-kit-master\\src\\main\\java\\com\\watermanage\\util\\common.txt";
     
	   
	   
       DataLoader dataLoader = applicationConfig.getDataLoader();
       dataLoader.executeData("INPUT_DATA");
    	
 

       
       
       readInputFile(path," ");
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
   
    
  
    
    
    
    public  void readInputFile(String dataPath, String delimiter) throws NoSuchCommandException {
    	 CommandInvoker commandinvoker=applicationConfig.getCommandInvoker();
    	try {
    	BufferedReader reader;
       

             reader = new BufferedReader(new FileReader(dataPath));

             String line = reader.readLine();
          
             while (line != null) {
          
              
                 if(line.contains("ALLOT_WATER")) {
                	
                	commandinvoker.executeCommand("ALLOT_WATER", line);
                 }else if (line.contains("ADD_GUESTS")) {
                	 commandinvoker.executeCommand("ADD_GUESTS", line);
                	 
                 }else if (line.contains("BILL")) {
                	 commandinvoker.executeCommand("BILL", line);
                 }
                 line = reader.readLine();
             }
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
  
    
    
    
    
}
