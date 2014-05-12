package com.aviastore.services;

import com.aviastore.entitys.Flights;
import java.util.*;

public interface FlightsServices {
	public void addFlight(Flights flight);
	public List<Flights> getTimetableByPlaces(String departure, String arrival, Date currDate);
	public List<Flights> getTimetableByDates(Date start, Date end);
	public void update(Flights flight);
	public boolean deleteFlight(Flights flight);
	public Set <String> airportNames();
	public Set <String> cityNames();
	public Set <String> countryNames();
}
