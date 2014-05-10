package com.aviastore.dao.impl;

import java.util.*;

import javax.persistence.*;

import com.aviastore.dao.*;
import com.aviastore.entitys.*;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FlightsDAOImpl implements FlightsDAO, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;

	public FlightsDAOImpl() {}
	@Override
	public void addFlight(Flights flight) {
		entityManager.persist(flight);	
//		entityManager.flush();
	}
	@Override
	public List<Flights> getTimetableByPlaces(String departure, String arrival,	Date currDate) {
			GregorianCalendar date = new GregorianCalendar();
			date.setTimeInMillis(currDate.getTime());
			GregorianCalendar startDate = new GregorianCalendar(
					date.get(Calendar.YEAR),
					date.get(Calendar.MONTH),
					date.get(Calendar.DAY_OF_MONTH) - 2);
			GregorianCalendar endDate = new GregorianCalendar(
					date.get(Calendar.YEAR),
					date.get(Calendar.MONTH),
					date.get(Calendar.DAY_OF_MONTH) + 2);
			TypedQuery<Flights> query = entityManager.createQuery(
					/*		"SELECT f FROM Flights f WHERE f.departureTime "+
							"BETWEEN :startDate AND :endDate" +
							"AND (LOCATE(LOWER(:depCit),LOWER(f.departureCity))<>0 "+
							"OR LOCATE(LOWER(:arivCit),LOWER(f.arrivalCity))<>0) "+
							"AND f.availableCount > 0 "+
							"ORDER BY f.departureTime", */
							
							"SELECT f FROM Flights f ORDER BY f.departureTime", 
							
							Flights.class);
			query.setParameter("startDate",	new Timestamp(startDate.getTimeInMillis()), TemporalType.TIMESTAMP);
			query.setParameter("endDate", new Timestamp(endDate.getTimeInMillis()), TemporalType.TIMESTAMP);
			query.setParameter("depCit", departure);
			query.setParameter("arivCit", arrival);
			List<Flights> flights = query.getResultList();
			return flights;
	}
	@Override
	public List<Flights> getTimetableByDates(Date start, Date end) {
		TypedQuery<Flights> query = entityManager.createQuery(
				"SELECT f FROM Flights f "+
				"WHERE f.departureTime BETWEEN :startDate AND :endDate "+
				"ORDER BY f.departureTime",Flights.class);
		query.setParameter("startDate", new Timestamp(start.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("endDate", new Timestamp(end.getTime()),TemporalType.TIMESTAMP);
		List<Flights> flights = query.getResultList();
		return flights;
	}
	@Override
	public boolean updateDepartureTime(Flights flight, GregorianCalendar depDate) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setDepartureTime(new Timestamp(depDate.getTimeInMillis()));
		return true;
	}
	
	@Override
	public boolean updateArrivalTime(Flights flight, GregorianCalendar arrDate){
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setArrivalTime(new Timestamp(arrDate.getTimeInMillis()));
		return true;
	}

	@Override
	public boolean updateFreeTickets(Flights flight, int quantity) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setAvailableCount(quantity);
		return true;
	}

	@Override
	public boolean updatePrice(Flights flight, double price) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setTicketsPrice(price);
		return true;
	}
	@Override
	public boolean updateAvailableTickets(Flights flight, int quantity) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setAvailableCount(quantity);
		return true;
	}
	@Override
	public boolean updateBookedTickets(Flights flight, int quantity) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setBookedCount(quantity);
		return true;
	}
	@Override
	public boolean updateSoldTickets(Flights flight, int quantity) {
		flight = entityManager.find(Flights.class, flight.getId());
		flight.setSoldCount(quantity);
		return true;
	}
	@Override
	public void update(Flights flight) {
		Flights flt = null;
		flt = entityManager.find(Flights.class, flight.getId());
		flt.setFlight(flight.getFlight());
		flt.setAirCompany(flight.getAirCompany());
		flt.setPlainModel(flight.getPlainModel());
		flt.setDepartureCountry(flight.getDepartureCountry());
		flt.setDepartureCity(flight.getDepartureCity());
		flt.setDepartureAirport(flight.getDepartureAirport());
		flt.setDepartureTime((Timestamp)flight.getDepartureTime().clone());
		flt.setArrivalCountry(flight.getArrivalCountry());
		flt.setArrivalCity(flight.getArrivalCity());
		flt.setArrivalAirport(flight.getArrivalAirport());
		flt.setArrivalTime((Timestamp)flight.getArrivalTime().clone());
		flt.setTicketsPrice(flight.getTicketsPrice());
		flt.setAvailableCount(flight.getAvailableCount());
		flt.setBookedCount(flight.getBookedCount());
		flt.setSoldCount(flight.getSoldCount());
	}
	@Override
	public boolean deleteFlight(Flights flight) {
		flight = entityManager.find(Flights.class, flight);
		if (flight==null || flight.getAvailableCount()!=0 || flight.getSoldCount()!=0){
			return false;			
		}else{
			entityManager.remove(flight);
			return true;
		}
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
