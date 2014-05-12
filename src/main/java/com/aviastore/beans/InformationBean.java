package com.aviastore.beans;

import java.io.*;
import java.util.*;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.aviastore.services.*;

@Named
@Component
@Scope("singleton")
public class InformationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	FlightsServices flightsServices;
	Set <String> airportNames;
	Set <String> cityNames;
	Set <String> countryNames;
	public InformationBean() {
		this.airportNames = flightsServices.airportNames();
		this.cityNames = flightsServices.cityNames();
		this.countryNames = flightsServices.countryNames();	
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Set<String> getAirportNames() {
		return airportNames;
	}
	public void setAirportNames(Set<String> airportNames) {
		this.airportNames = airportNames;
	}
	public Set<String> getCityNames() {
		return cityNames;
	}
	public void setCityNames(Set<String> cityNames) {
		this.cityNames = cityNames;
	}
	public Set<String> getCountryNames() {
		return countryNames;
	}
	public void setCountryNames(Set<String> countryNames) {
		this.countryNames = countryNames;
	}
}
