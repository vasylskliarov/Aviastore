package com.aviastore.beans;

import java.io.Serializable;
import java.util.*;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.primefaces.event.RowEditEvent;

import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Named
@Component
@Scope("session")
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired 
	OrdersServices ordersServices;
	@Autowired
	FlightsServices flightsServices;
	private Date startDate;
	private Date endDate;
	
	private String flight;
	private String airCompany;
	private String plainModel;
	private String departureCountry;
	private String departureCity;
	private String departureAirport;
	private Date departureTime;
	private String arrivalCountry;
	private String arrivalCity;
	private String arrivalAirport;
	private Date arrivalTime;
	private double ticketsPrice;
	private int availableCount;
	
	boolean showTimeTable = false;
	boolean showCanceledOrders = false;
	private List<Flights> flightsTimeTable = null;
	
	public AdminBean() {
		showTimeTable = false;
		showCanceledOrders = false;
	}
	public void cancelAllOrders(){
		showCanceledOrders = true;
	}
	public List<Orders> getCancelOrders() {
		GregorianCalendar before3Days = new GregorianCalendar();
		before3Days.add(GregorianCalendar.DAY_OF_YEAR, -3);
		GregorianCalendar startDate = new GregorianCalendar(2000, 1, 1);
		List<Orders> orders = ordersServices.getOrders(startDate.getTime(), new Date(before3Days.getTimeInMillis()),Orders.BOOKED );
		for(Orders ord: orders){
			ordersServices.changeOrderStatusToCanceled(ord);
		}
		showCanceledOrders = true;
		return orders;
	}
	public void hideCanceledOrders(){
		showCanceledOrders =false;
		
	}
	
	
	public void addNewFlight(){
		System.out.println("adding new flight");
		Flights newFlight = new Flights(
				flight, 
				airCompany,
				plainModel, 
				departureCountry, 
				departureCity, 
				departureAirport,
				departureTime, 
				arrivalCountry, 
				arrivalCity, 
				arrivalAirport, 
				arrivalTime, 
				ticketsPrice, 
				availableCount);

		flightsServices.addFlight(newFlight);
		
		this.clearFields();
		flightsTimeTable = null;
	}
	public void clearFields(){
		flight=null; 
		airCompany=null;
		plainModel =null;
		departureCountry=null;
		departureCity=null;
		departureAirport =null;
		departureTime=null;
		arrivalCountry=null;
		arrivalCity=null;
		arrivalAirport=null;
		arrivalTime=null;
		ticketsPrice=0.0;
		availableCount=0;
		
	}
	
	
	public void  updateTimetable() {
		System.out.println("update Timetable");
		if(startDate != null && endDate != null) {
			flightsTimeTable = flightsServices.getTimetableByDates(startDate, endDate);
			
			this.showTimeTable = true;
			this.showCanceledOrders = false;
			
		}
	}
	public void onEdit(RowEditEvent event) {
		Flights flight = (Flights)event.getObject();
		flightsServices.update(flight);
	}
	public OrdersServices getOrdersServices() {
		return ordersServices;
	}
	public void setOrdersServices(OrdersServices ordersServices) {
		this.ordersServices = ordersServices;
	}
	public FlightsServices getFlightsServices() {
		return flightsServices;
	}
	public void setFlightsServices(FlightsServices flightsServices) {
		this.flightsServices = flightsServices;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getAirCompany() {
		return airCompany;
	}
	public void setAirCompany(String airCompany) {
		this.airCompany = airCompany;
	}
	public String getPlainModel() {
		return plainModel;
	}
	public void setPlainModel(String plainModel) {
		this.plainModel = plainModel;
	}
	public String getDepartureCountry() {
		return departureCountry;
	}
	public void setDepartureCountry(String departureCountry) {
		this.departureCountry = departureCountry;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalCountry() {
		return arrivalCountry;
	}
	public void setArrivalCountry(String arrivalCountry) {
		this.arrivalCountry = arrivalCountry;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getTicketsPrice() {
		return ticketsPrice;
	}
	public void setTicketsPrice(double ticketsPrice) {
		this.ticketsPrice = ticketsPrice;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public boolean isShowTimeTable() {
		return showTimeTable;
	}
	public void setShowTimeTable(boolean showTimeTable) {
		this.showTimeTable = showTimeTable;
	}
	public boolean isShowCanceledOrders() {
		return showCanceledOrders;
	}
	public void setShowCanceledOrders(boolean showCanceledOrders) {
		this.showCanceledOrders = showCanceledOrders;
	}
	public List<Flights> getFlightsTimeTable() {
		return flightsTimeTable;
	}
	public void setFlightsTimeTable(List<Flights> flightsTimeTable) {
		this.flightsTimeTable = flightsTimeTable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
