package com.aviastore.entitys;

import java.sql.Timestamp;
import javax.persistence.*;
import java.util.*;

@Entity
public class Flights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String flight;
	private String airCompany;
	private String plainModel;
	private String departureCountry;
	private String departureCity;
	private String departureAirport;
	private Timestamp departureTime;
	private String arrivalCountry;
	private String arrivalCity;
	private String arrivalAirport;
	private Timestamp arrivalTime;
	private double TicketsPrice;
	private int availableCount;
	private int bookedCount=0;
	private int soldCount=0;
	
	@OneToMany(mappedBy = "flightId")
	private Collection<Orders> orders;
	
	@ManyToMany
	@JoinTable(name="orders",
	joinColumns=@JoinColumn(name="flightId"),
	inverseJoinColumns = @JoinColumn(name="customerId"))
	private Collection<Customers> customers;
	
	//TODO разобраться дя чего создал переменную dtimeD
	@Transient
	private Date dtimeD;

	public Flights() {}
	public Flights(String flight, String airCompany, String plainModel,
			String departureCountry, String departureCity,
			String departureAirport, Timestamp departureTime,
			String arrivalCountry, String arrivalCity, String arrivalAirport,
			Timestamp arrivalTime, double ticketsPrice, int availableCount) {
		super();
		this.flight = flight;
		this.airCompany = airCompany;
		this.plainModel = plainModel;
		this.departureCountry = departureCountry;
		this.departureCity = departureCity;
		this.departureAirport = departureAirport;
		this.departureTime = departureTime;
		this.arrivalCountry = arrivalCountry;
		this.arrivalCity = arrivalCity;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		TicketsPrice = ticketsPrice;
		this.availableCount = availableCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Timestamp getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Timestamp departureTime) {
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
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getTicketsPrice() {
		return TicketsPrice;
	}
	public void setTicketsPrice(double ticketsPrice) {
		TicketsPrice = ticketsPrice;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getBookedCount() {
		return bookedCount;
	}
	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	public int getSoldCount() {
		return soldCount;
	}
	public void setSoldCount(int soldCount) {
		this.soldCount = soldCount;
	}
	public Collection<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}
	public Collection<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(Collection<Customers> customers) {
		this.customers = customers;
	}
	
	public GregorianCalendar getDepartureTimeCal() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(this.getDepartureTime());
		return (GregorianCalendar)calendar;
	}
	public GregorianCalendar getArrivalTimeCal() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(this.getArrivalTime());
		return (GregorianCalendar)calendar;
	}
	
	//TODO разобраться используется ли getDtimeD() и setDtimeD(Date dtimeD)
	public Date getDtimeD() {
		return dtimeD;
	}
	public void setDtimeD(Date dtimeD) {
		this.dtimeD = dtimeD;
	}
	public static Timestamp convertTime( GregorianCalendar cal) {
		return new Timestamp(cal.getTimeInMillis());	
	}
	
	
	

}
