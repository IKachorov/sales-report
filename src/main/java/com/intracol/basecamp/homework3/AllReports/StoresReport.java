package com.intracol.basecamp.homework3.AllReports;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.intracol.basecamp.homework3.Page;
import com.intracol.basecamp.homework3.Sale;
import com.intracol.basecamp.homework3.StoreSale;

@Component
public class StoresReport {
	
	
	private Map<String, StoreSale> storesReports = new LinkedHashMap<>();
	
	public Map<String, StoreSale> getStoresReport(){
		return storesReports;
	}
	
	public Collection<StoreSale> read(Page page) {
		
		if (page.isAllPages()) {
			return storesReports.values();
		}
		
		List<StoreSale> orderedReports = new ArrayList<>(storesReports.values());
		int fromIndex = Math.min(orderedReports.size(), (page.getPageNumber() - 1) * page.getPageSize());
        int toIndex = Math.min(orderedReports.size(), page.getPageNumber() * page.getPageSize());
        
        return orderedReports.subList(fromIndex, toIndex);
		
	}
	
	public void create(Sale report) {
		
		if(storesReports.isEmpty() || !storesReports.containsKey(report.getStore() + ", " + report.getCity())) {
			storesReports.put(report.getStore() + ", " + report.getCity(), 
				new StoreSale(
					report.getStore() + ", " + report.getCity(),
					1,
					report.getAmount()));
		} else if ((report.getStore() + ", " + report.getCity()).equals(storesReports.get(report.getStore() + ", " + report.getCity()).getStore())) {
			int numberOfPurchases = storesReports.get(report.getStore() + ", " + report.getCity()).getNumberOfPurchases() + 1;
			BigDecimal totalAmount = storesReports.get(report.getStore() + ", " + report.getCity()).getTotalAmount().add(report.getAmount());
			storesReports.put(report.getStore() + ", " + report.getCity(), 
				new StoreSale(
					report.getStore() + ", " + report.getCity(),
					numberOfPurchases,
					totalAmount));
		}
		
	}
	
	
}
