package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entites.CostList;


public class CostListRepository  implements ICostListRepository{
	
	  private final Map<Integer, CostList> costMap;
	  
	  public CostListRepository() {
		  costMap = new HashMap<>();
	}
	

	@Override
	public CostList getCostListById(Integer id) {
	
		return costMap.get(id);
	}

	@Override
	public void saveCostList(CostList costlist) {
		
		costMap.put(costlist.getId(), costlist);
		
	}

	@Override
	public void updatCostList(CostList costlist) {
		costMap.put(costlist.getId(), costlist);
		
	}

}
