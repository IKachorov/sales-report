package com.intracol.basecamp.homework3.AllReports;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.intracol.basecamp.homework3.CitySale;
import com.intracol.basecamp.homework3.Page;
import com.intracol.basecamp.homework3.Sale;

@Component
public class CitiesReport {
	
	private Map<String, CitySale> citiesReports = new LinkedHashMap<>();
	
	public Map<String, CitySale> getCitiesReport(){
		return citiesReports;
	}
	
	public Collection<CitySale> read(Page page) {
		
		if (page.isAllPages()) {
			return citiesReports.values();
		}
		
		List<CitySale> orderedReports = new ArrayList<>(citiesReports.values());
		int fromIndex = Math.min(orderedReports.size(), (page.getPageNumber() - 1) * page.getPageSize());
        int toIndex = Math.min(orderedReports.size(), page.getPageNumber() * page.getPageSize());
        
        return orderedReports.subList(fromIndex, toIndex);
		
	}


	public void create(Sale report) {
		
		if(citiesReports.isEmpty() || !citiesReports.containsKey(report.getCity())) {
			citiesReports.put(report.getCity(), new CitySale(report.getCity(), 1, report.getAmount()));
		} else if (report.getCity().equals(citiesReports.get(report.getCity()).getCity())) {
			int numberOfPurchases = citiesReports.get(report.getCity()).getNumberOfPurchases() + 1;
			BigDecimal totalAmount = citiesReports.get(report.getCity()).getTotalAmount().add(report.getAmount());
			citiesReports.put(report.getCity(), 
				new CitySale(
					report.getCity(), 
					numberOfPurchases,
					totalAmount));
		}
		
		
	}

}
