package com.aviastore.beans;

import java.io.Serializable;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.*;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Named
@Component
@Scope("session")
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FlightsServices flightsServices;
	@Autowired 
	OrdersServices ordersServices;

	private String departureCity;
	private String arrivalCity;
	private Date departureDate;
	private List<Flights> timeTableList;
	boolean showTimeTable = false;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private List<Orders> cartOrders = new LinkedList<>();
	private double total;
	private boolean showCart = false;
	
	private Flights selectedFlight;
	private int amountTickets = 1;
	
	public CustomerBean() {}
	public void loadTimeTable() {
		timeTableList = flightsServices.getTimetableByPlaces(departureCity, arrivalCity, departureDate);
		System.out.println(timeTableList.size());
		this.showTimeTable = true;
	}
	public void addOrderToCart(Flights flight, int amountTickets) {
		System.out.println("add to cart");
		if(flight == null || amountTickets > flight.getAvailableCount()) {
			return;
		}
		Orders order = new Orders(new Customers(), flight, amountTickets, new Date());

		if (!cartOrders.isEmpty()) {
			for (Orders or : cartOrders) {
				if (or.getFlightId().getId() == flight.getId()) {
					or.setAmountTickets(or.getAmountTickets() + amountTickets);
					this.total = this.total + flight.getTicketsPrice() * amountTickets;
					return;
				}
			}
		}
		cartOrders.add(order);
		this.total = total + flight.getTicketsPrice() * amountTickets;
		this.showCart = true;
		this.amountTickets = 1;
		this.selectedFlight = null;	
	}
	public void  removeOrderFromCart(Orders order){
		System.out.println("Remove order");
		if(order == null){
			return;
		}
		int i = cartOrders.indexOf(order);
		if (i < 0 || i > cartOrders.size()-1 ){
			return;
		}
		this.total -= order.getTotalPrice(); 
		cartOrders.remove(i);
		if(cartOrders.size() == 0){
			this.showCart = false;
		}
	}
	public void saveCartToDB() {
		System.out.println("save from cart to database");
		if (this.firstName == null || this.lastName == null || this.phoneNumber == null || this.email == null) {
			return;
		}
		Date orderingDate = new Date();
		Customers customer = new Customers(this.firstName, this.lastName, this.email, this.phoneNumber);
		for (Orders or : cartOrders) {
			 if (!ordersServices.addOrder(new Orders(customer, or.getFlightId(), or.getAmountTickets(), orderingDate))){
				 String errMes = "Error: not enough tickets on flight number "+ or.getFlightId().getFlight() +
			 " from " + or.getFlightId().getDepartureCity() + " to " + or.getFlightId().getArrivalCity();
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, errMes,""));
			 }		
		}
		this.departureCity=null;
		this.arrivalCity=null;
		this.departureDate=null;
		this.timeTableList=null;
		this.showTimeTable=false;
		this.firstName=null;
		this.lastName=null;
		this.email=null;
		this.phoneNumber=null;
		this.cartOrders.clear();
		this.total=0.0;
		this.showCart=false;
	}
	public int ticketsInCartOnFlight(int flightId){
		if(this.cartOrders.isEmpty()){
			return 0;
		}

		for(Orders order : cartOrders){
			if(order.getFlightId().getId() == flightId){
				return order.getAmountTickets();
			}
		}
		return 0;
	}
	public FlightsServices getFlightsServices() {
		return flightsServices;
	}
	public void setFlightsServices(FlightsServices flightsServices) {
		this.flightsServices = flightsServices;
	}
	public OrdersServices getOrdersServices() {
		return ordersServices;
	}
	public void setOrdersServices(OrdersServices ordersServices) {
		this.ordersServices = ordersServices;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public List<Flights> getTimeTableList() {
		return timeTableList;
	}
	public void setTimeTableList(List<Flights> timeTableList) {
		this.timeTableList = timeTableList;
	}
	public boolean isShowTimeTable() {
		return showTimeTable;
	}
	public void setShowTimeTable(boolean showTimeTable) {
		this.showTimeTable = showTimeTable;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Orders> getCartOrders() {
		return cartOrders;
	}
	public void setCartOrders(List<Orders> cartOrders) {
		this.cartOrders = cartOrders;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isShowCart() {
		return showCart;
	}
	public void setShowCart(boolean showCart) {
		this.showCart = showCart;
	}
	public Flights getSelectedFlight() {
		return selectedFlight;
	}
	public void setSelectedFlight(Flights selectedFlight) {
		this.selectedFlight = selectedFlight;
	}
	public int getAmountTickets() {
		return amountTickets;
	}
	public void setAmountTickets(int amountTickets) {
		this.amountTickets = amountTickets;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
