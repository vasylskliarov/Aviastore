package com.aviastore.entitys;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.inject.Named;
import javax.persistence.*;

import java.util.*;

@Named
@Entity
public class Flights implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
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
	private double ticketsPrice;
	private int availableCount;
	private int bookedCount=0;
	private int soldCount=0;
	
	@OneToMany(mappedBy = "flightId")
	private Collection<Orders> orders;
	//TODO разобраться с @ManyToMany
	@ManyToMany
	@JoinTable(name="Customers_Flights", joinColumns=@JoinColumn(name="Flights_id"), inverseJoinColumns = @JoinColumn(name="Customers_id"))
	private Collection<Customers> customers;
	
	//TODO разобраться дя чего создал переменную dtimeD
	@Transient
	private Date departureTimeDate;
	@Transient
	private Date arrivalTimeDate;

	public Flights() {}
	
	@Transient
	public Date getDepartureTimeDate() {
		return new Date(this.departureTime.getTime());
	}
	@Transient
	public void setDepartureTimeDate(Date departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
		this.departureTime.setTime(departureTimeDate.getTime());
	}
	@Transient
	public Date getArrivalTimeDate() {
		return new Date(this.arrivalTime.getTime());
	}
	@Transient
	public void setArrivalTimeDate(Date arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
		this.arrivalTime.setTime(arrivalTimeDate.getTime());
	}
	
	
	public Flights(String flight, String airCompany, String plainModel,
			String departureCountry, String departureCity,
			String departureAirport, Date departureTimeDate,
			String arrivalCountry, String arrivalCity, String arrivalAirport,
			Date arrivalTimeDate, double ticketsPrice, int availableCount) {
		super();
		this.flight = flight;
		this.airCompany = airCompany;
		this.plainModel = plainModel;
		this.departureCountry = departureCountry;
		this.departureCity = departureCity;
		this.departureAirport = departureAirport;
		this.departureTime = new Timestamp(departureTimeDate.getTime());
		this.arrivalCountry = arrivalCountry;
		this.arrivalCity = arrivalCity;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = new Timestamp(arrivalTimeDate.getTime());
		this.ticketsPrice = ticketsPrice;
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
	//TODO timestamp return date
	//	public Date getStartDate() {
	//		return new java.util.Date(startDate.getTime());
	//	}
	//
	//	public void setStartDate(Date startDate) {
	//		this.startDate = new Timestamp (startDate.getTime());
	//	}
	
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
	
	public static Timestamp convertTime( GregorianCalendar cal) {
		return new Timestamp(cal.getTimeInMillis());	
	}
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Flights [id=" + id + ", flight=" + flight + ", airCompany="
				+ airCompany + ", plainModel=" + plainModel
				+ ", departureCountry=" + departureCountry + ", departureCity="
				+ departureCity + ", departureAirport=" + departureAirport
				+ ", departureTime=" + departureTime + ", arrivalCountry="
				+ arrivalCountry + ", arrivalCity=" + arrivalCity
				+ ", arrivalAirport=" + arrivalAirport + ", arrivalTime="
				+ arrivalTime + ", ticketsPrice=" + ticketsPrice
				+ ", availableCount=" + availableCount + ", bookedCount="
				+ bookedCount + ", soldCount=" + soldCount + ", orders="
				+ orders + ", customers=" + customers + ", departureTimeDate="
				+ departureTimeDate + ", arrivalTimeDate=" + arrivalTimeDate
				+ "]";
	}
	
	
	
	

}
