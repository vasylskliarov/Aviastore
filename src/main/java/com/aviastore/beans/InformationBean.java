package com.aviastore.beans;

import java.io.*;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.*;

@Named
@Component
@Scope("singleton")
public class InformationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	FlightsServices flightsServices;
	Set<String> airportNames;
	Set<String> cityNames;
	Set<String> countryNames;

	public InformationBean() {

	}

	@PostConstruct
	public void init() {
		this.airportNames = flightsServices.airportNames();
		this.cityNames = flightsServices.cityNames();
		this.countryNames = flightsServices.countryNames();
	}

	public FlightsServices getFlightsServices() {
		return flightsServices;
	}

	public void setFlightsServices(FlightsServices flightsServices) {
		this.flightsServices = flightsServices;
	}

	public List<String> getAirportNames() {
		return new ArrayList<String>(airportNames);
	}

	public void setAirportNames(Set<String> airportNames) {
		this.airportNames = airportNames;
	}

	public List<String> getCityNames() {
		return new ArrayList<String>(cityNames);
	}

	public void setCityNames(Set<String> cityNames) {
		this.cityNames = cityNames;
	}

	public List<String> getCountryNames() {
		return new ArrayList<String>(countryNames);
	}

	public void setCountryNames(Set<String> countryNames) {
		this.countryNames = countryNames;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<String> completeAirportNames(String query) {
		List<String> suggestions = new ArrayList<String>();
		for (String p : this.airportNames) {
			
			if (p.toLowerCase().startsWith((query.toLowerCase())))
				suggestions.add(p);
		}
		return suggestions;
	}
	public List<String> completeCityNames(String query) {
		List<String> suggestions = new ArrayList<String>();
		for (String p : this.cityNames) {
			if (p.toLowerCase().startsWith((query.toLowerCase())))
				suggestions.add(p);
		}
		return suggestions;
	}
	public List<String> completeCountryNames(String query) {
		List<String> suggestions = new ArrayList<String>();
		for (String p : this.countryNames) {
			if (p.toLowerCase().startsWith((query.toLowerCase())))
				suggestions.add(p);
		}
		return suggestions;
	}
}
