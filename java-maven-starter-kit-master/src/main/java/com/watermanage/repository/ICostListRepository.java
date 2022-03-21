package com.watermanage.repository;

import com.watermanage.entites.CostList;

public interface ICostListRepository {

	
	CostList getCostListById(Integer id);

	void saveCostList(CostList supply);

	void updatCostList(CostList supply);
}
