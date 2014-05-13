package com.aviastore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;
import javax.xml.bind.*;

import com.aviastore.dao.*;
import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Service
public class FlightsServicesImpl implements FlightsServices, Serializable {
	private static final long serialVersionUID = 1L;
	List<Airport> airportsList;
	@Autowired
	private FlightsDAO flightsDAO;
	@Autowired
	private AirportsDAO airportsDAO;

	public FlightsServicesImpl() {}
	public void init(){
		if(airportsList != null){
			return;
		}
		try {
			//TODO try to use claspath from the project
			airportsList = airportsDAO.unmarshalAirports(
					new File("C:/airports.xml")
							
							);
		} catch (JAXBException e) {
			System.out.println("Unmurshuling problems. Check file");
			e.printStackTrace();
		}
		System.out.println(airportsList);
	}

	@Override
	@Transactional
	public void addFlight(Flights flight) {
		flightsDAO.addFlight(flight);
	}

	@Override
	@Transactional
	public List<Flights> getTimetableByPlaces(String departure, String arrival,
			Date currDate) {
		Date fromDate = (Date) currDate.clone();
		Calendar now = Calendar.getInstance();
		now.clear(Calendar.HOUR_OF_DAY);
		now.clear(Calendar.AM_PM);
		now.clear(Calendar.MINUTE);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MILLISECOND);
		now.roll(Calendar.DAY_OF_MONTH, 3);
		Calendar curr = Calendar.getInstance();
		curr.setTimeInMillis(currDate.getTime());
		curr.clear(Calendar.HOUR_OF_DAY);
		curr.clear(Calendar.AM_PM);
		curr.clear(Calendar.MINUTE);
		curr.clear(Calendar.SECOND);
		curr.clear(Calendar.MILLISECOND);
		if (curr.before(now)) {
			fromDate.setTime(now.getTimeInMillis());
		}
		return flightsDAO.getTimetableByPlaces(departure, arrival, fromDate);
	}

	@Override
	@Transactional
	public List<Flights> getTimetableByDates(Date start, Date end) {
		return flightsDAO.getTimetableByDates(start, end);
	}

	@Override
	@Transactional
	public void update(Flights flight) {
		flightsDAO.update(flight);
	}

	@Override
	@Transactional
	public boolean deleteFlight(Flights flight) {
		return flightsDAO.deleteFlight(flight);
	}

	@Override
	@Transactional
	public Set<String> airportNames() {
		Set<String> rezult = new HashSet<String>();
		this.init();
		if (airportsList != null) {
			for (Airport airport : airportsList) {
				rezult.add(airport.getName_rus());
			}
		}
		return rezult;
	}

	@Override
	@Transactional
	public Set<String> cityNames() {
		Set<String> rezult = new HashSet<String>();
		this.init();
		if (airportsList != null) {
			for (Airport airport : airportsList) {
				rezult.add(airport.getCity_rus());
			}
		}
		return rezult;
	}

	@Override
	@Transactional
	public Set<String> countryNames() {
		Set<String> rezult = new HashSet<String>();
		this.init();
		if (airportsList != null) {
			for (Airport airport : airportsList) {
				rezult.add(airport.getCountry_rus());
			}
		}
		return rezult;
	}

	public FlightsDAO getFlightsDAO() {
		return flightsDAO;
	}

	public void setFlightsDAO(FlightsDAO flightsDAO) {
		this.flightsDAO = flightsDAO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Airport> getAirportsList() {
		return airportsList;
	}

	public void setAirportsList(List<Airport> airportsList) {
		this.airportsList = airportsList;
	}

	public AirportsDAO getAirportsDAO() {
		return airportsDAO;
	}

	public void setAirportsDAO(AirportsDAO airportsDAO) {
		this.airportsDAO = airportsDAO;
	}
	
	
}