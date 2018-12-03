package com.intracol.basecamp.homework3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.intracol.basecamp.homework3.AllReports.CitiesReport;

@Component
public class Sales {
	
	CitiesReport citiesReport = new CitiesReport();
	
	private Map<Integer, Sale> reports = new LinkedHashMap<>();

	public Collection<Sale> read(Page page) {
		
		if (page.isAllPages()) {
			return reports.values();
		}
		
		List<Sale> orderedReports = new ArrayList<>(reports.values());
		int fromIndex = Math.min(orderedReports.size(), (page.getPageNumber() - 1) * page.getPageSize());
        int toIndex = Math.min(orderedReports.size(), page.getPageNumber() * page.getPageSize());
        
        return orderedReports.subList(fromIndex, toIndex);
		
	}
	
	public void delete(Sale report) {
		reports.remove(report.getId());
	}

	public void create(Sale report) {
		reports.put(report.getId(), report);
	}
	
	
}
