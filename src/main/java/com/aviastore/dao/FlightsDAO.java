package com.aviastore.dao;

import java.util.*;
import com.aviastore.entitys.*;

public interface FlightsDAO {
	public void addFlight(Flights flight);
	public boolean deleteFlight(Flights flight);
	public boolean updateTime(Flights flight, GregorianCalendar date);
	public boolean updateFreeTickets(Flights flight, int quantity);
	public boolean updatePrice(Flights flight, double price);
	public boolean updateBookedTickets(Flights flight, int quantity);
	public boolean updateSoldTickets(Flights flight, int quantity);
	public void update(Flights flight);
	public List<Flights> getTimetableByPlaces(String departure, String arrival, Date date);
	public List<Flights> getTimetableByDates(Date start, Date end);

}
