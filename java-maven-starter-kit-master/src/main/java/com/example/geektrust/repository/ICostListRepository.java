package com.example.geektrust.repository;

import com.example.geektrust.entites.CostList;

public interface ICostListRepository {

	
	CostList getCostListById(Integer id);

	void saveCostList(CostList supply);

	void updatCostList(CostList supply);
}
