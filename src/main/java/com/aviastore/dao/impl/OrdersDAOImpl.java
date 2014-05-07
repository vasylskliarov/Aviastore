package com.aviastore.dao.impl;

import java.util.*;
import javax.persistence.*;
import com.aviastore.entitys.*;
import com.aviastore.dao.*;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
	@PersistenceContext
	private EntityManager entityManager;
	//TODO try to use interface flightsDAO not implementation
	@Autowired
	private FlightsDAOImpl flightsDAO;
	//TODO try to use interface customersDAO not implementation 
	@Autowired
	private CustomersDAOImpl customersDAO;
	
	public OrdersDAOImpl() {}

	@Override
	public boolean addOrder(Orders order) {
		Flights flight = null;
		flight = entityManager.find(Flights.class, order.getFlightId().getId());
		TypedQuery<Customers> query = entityManager.createQuery(
				"SELECT c FROM Customers c "+
				"WHERE (LOCATE(:fName,c.firstName)<>0 "+
				"AND LOCATE(:lName,c.lastName)<>0)"+
				"AND LOCATE(:email,c.email)<>0)"+
				"AND LOCATE(:phone,c.phoneNumber)<>0)", Customers.class);
		query.setParameter("fName",  order.getCustomerId().getFirstName());
		query.setParameter("lName",  order.getCustomerId().getLastName());
		query.setParameter("email", order.getCustomerId().getEmail());
		query.setParameter("phone",  order.getCustomerId().getPhoneNumber());
		Customers cust = null;
		try {
			cust = query.getSingleResult(); 
		} catch(Exception ex) {}
		if (order == null || order.getAmountTickets() <= 0 || flight == null || order.getAmountTickets() > flight.getAvailableCount()) {
			return false;
		}
		if (cust != null)
			order.setCustomerId(cust);
		else {
			customersDAO.addCustomer(order.getCustomerId());
		}	
		entityManager.persist(order);
		flightsDAO.updateBookedTickets(flight, flight.getBookedCount() + order.getAmountTickets());
		flightsDAO.updateFreeTickets(flight, flight.getAvailableCount() - order.getAmountTickets());
		return true;
	}

	@Override
	public boolean deleteOrder(Orders order) {
		order = entityManager.find(Orders.class, order.getId());
		if (order == null || order.getPayStatus() != Orders.BOOKED ) {
			return false;
		}
		order.getFlightId().setBookedCount(order.getFlightId().getBookedCount() - order.getAmountTickets());
		order.getFlightId().setAvailableCount(order.getFlightId().getBookedCount() + order.getAmountTickets());
		entityManager.remove(order);
		return true;
	}

	@Override
	public boolean changeOrderStatusToSold(Orders order) {
		order = entityManager.find(Orders.class, order.getId());
		if( order == null) {
			return false;
		}else if (order.getPayStatus() == Orders.SOLD) {
			return true;
		}else {
			order.setPayStatus(Orders.SOLD);
			flightsDAO.updateBookedTickets(order.getFlightId(), order.getFlightId().getBookedCount() - order.getAmountTickets());
			flightsDAO.updateSoldTickets(order.getFlightId(), order.getFlightId().getSoldCount() + order.getAmountTickets());
			return true;
		}	
	}

	@Override
	public boolean changeOrderStatusToCanceled(Orders order) {
		order = entityManager.find(Orders.class, order.getId());
		if( order == null) {
			return false;
		}else if (order.getPayStatus() == Orders.CANCELED) {
			return false;
		}else{
			order.setPayStatus(Orders.CANCELED);
			flightsDAO.updateBookedTickets( order.getFlightId(), order.getFlightId().getBookedCount() - order.getAmountTickets());
			flightsDAO.updateFreeTickets( order.getFlightId(), order.getFlightId().getAvailableCount() + order.getAmountTickets());
			return true;
		}
	}

	@Override
	public List<Orders> getOrders(Date startDate, Date endDate, int status) {
		TypedQuery<Orders> query = entityManager.createQuery(
				"SELECT o FROM Orders o "+
				"WHERE o.bookingDate BETWEEN :startDate AND :endDate "
				+ "AND o.payStatus = :STATUS  "
				+ "ORDER BY o.bookingDate",Orders.class);
		query.setParameter("startDate", new Timestamp(startDate.getTime()), TemporalType.TIMESTAMP);
		query.setParameter("endDate", new Timestamp(endDate.getTime()),	TemporalType.TIMESTAMP);
		query.setParameter("STATUS", status);
		List<Orders> orders = null;
		orders = query.getResultList();
		return orders;
	}

	@Override
	public List<Orders> getOrders(Date startDate, Date endDate, String departureCity, String arrivalCity, String firstName, String lastName, String email, String phoneNumber, int status) {
		TypedQuery<Orders> query = entityManager.createQuery(
				"SELECT o FROM Orders o WHERE o.bookingDate BETWEEN :startDate AND :endDate "+ 
				"AND o.flights.departureTime > CURRENT_TIMESTAMP "+
				"AND LOCATE( lower(:depCity), lower(o.flights.departureCity) )<>0 "+
				"AND LOCATE( lower(:arCity), lower(o.flights.arrivalCity) )<>0 "+
				"AND LOCATE( lower(:firstNCust), lower(o.customers.firstName) )<>0 "+
				"AND LOCATE( lower(:lastNCust), lower(o.customers.lastName) )<>0 "+
				"AND LOCATE( lower(:emailCust), lower(o.customers.email) )<>0 "+
				"AND LOCATE( lower(:phoneCust), lower(o.customers.phoneNumber) )<>0 "+
				"AND o.payStatus = :STATUS "+
				"ORDER BY o.bookingDate DESC",Orders.class);
		query.setParameter("startDate",new Timestamp(startDate.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("endDate", new Timestamp(endDate.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("depCity", departureCity);
		query.setParameter("arCity", arrivalCity);
		query.setParameter("firstNCust", firstName);
		query.setParameter("lastNCust", lastName);
		query.setParameter("emailCust", email);
		query.setParameter("phoneCust", phoneNumber);
		query.setParameter("STATUS", status);
		List<Orders> orders = null;
		orders = query.getResultList();
		return orders;
	}
	@Override
	public List<Report> getStatByCitys(Date startDate, Date endDate) {
		TypedQuery<Report> query = entityManager.createQuery(
				"SELECT NEW com.aviastore.entitys.Report( FUNC('Date',o.flights.departureTime), SUM(o.amountTickets),SUM(o.TicketsPrice)) "+
				"FROM Orders o WHERE ( o.flights.departureTime BETWEEN :startDate AND :endDate AND o.payStatus = :STATUS ) "+
				"GROUP BY FUNC('Date',o.flights.departureTime)",
				Report.class);
		query.setParameter("startDate", new Timestamp(startDate.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("endDate", new Timestamp(endDate.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("STATUS", Orders.SOLD);
		List<Report> result = null;
		result = query.getResultList();
		return result;
	}
	@Override
	public List<Report> getStatByDates(Date start, Date end) {
		TypedQuery<Report> query = entityManager.createQuery(
				"SELECT NEW com.aviastore.entitys.Report(o.flights.departureCity, o.flights.arrivalCity, SUM(o.amountTickets),SUM(o.TicketsPrice)) "+
				"FROM Orders o WHERE ( o.flights.departureTime BETWEEN :startDate AND :endDate AND o.status = :STATUS ) "+
				"GROUP BY o.flights.departureCity, o.flights.arrivalCity", Report.class);
		query.setParameter("startDate",new Timestamp(start.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("endDate", new Timestamp(end.getTime()),TemporalType.TIMESTAMP);
		query.setParameter("STATUS", Orders.SOLD);
		List<Report> result = null;
		result = query.getResultList();
		return result;
	}
}
