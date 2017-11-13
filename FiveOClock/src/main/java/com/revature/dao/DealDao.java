package com.revature.dao;

import com.revature.domain.Deal;

public interface DealDao {
	public String viewPendingDealsJSON();
	public int approveSuggestion(int id);
	public int denySuggestion(int id);
	public int addDealSuggestion(Deal d);


}
