package com.intracol.basecamp.homework3;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intracol.basecamp.homework3.AllReports.CitiesReport;
import com.intracol.basecamp.homework3.AllReports.StoresReport;

@RestController
public class SalesController {

	private Sales reports;
	private CitiesReport citiesReports;
	private StoresReport storesReports;
	
	@Autowired
	public SalesController(Sales reports, CitiesReport citiesReports, StoresReport storesReports) {
		this.reports = reports;
		this.citiesReports = citiesReports;
		this.storesReports = storesReports;
	}
	
	
	@RequestMapping(path = "/sales", method = RequestMethod.GET)
	public Collection<Sale> readAllReports(
		@RequestParam(name = "pageSize", required = false) Integer pageSize,
		@RequestParam(name = "page", required = false) Integer pageNumber
		){
		return reports.read(new Page(pageNumber, pageSize));
	}
	
	@RequestMapping(path = "/cities-report", method = RequestMethod.GET)
	public Collection<CitySale> readAllCityReports(
		@RequestParam(name = "pageSize", required = false) Integer pageSize,
		@RequestParam(name = "page", required = false) Integer pageNumber
		){
		return citiesReports.read(new Page(pageNumber, pageSize));
	}
	
	@RequestMapping(path = "/stores-report", method = RequestMethod.GET)
	public Collection<StoreSale> readAllStoreReports(
		@RequestParam(name = "pageSize", required = false) Integer pageSize,
		@RequestParam(name = "page", required = false) Integer pageNumber
		){
		return storesReports.read(new Page(pageNumber, pageSize));
	}
	
	@RequestMapping(path = "/sales", method = RequestMethod.POST)
	public Sale createReport(@RequestBody Sale report) {
		reports.create(report);
		citiesReports.create(report);
		storesReports.create(report);
		return report;
	}
	
}
