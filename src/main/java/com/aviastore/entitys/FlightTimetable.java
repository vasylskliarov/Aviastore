package com.aviastore.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class FlightTimetable {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int id;
	private String flight;
	private String airCompany;
	private String plainModel;
	private String departureCountry;
	private String departureCity;
	private String departureAirport;
	private Timestamp departureDate;
	private String arrivalCountry;
	private String arrivalCity;
	private String arrivalAirport;
	private Timestamp arrivalDate;
	private	int amountTickets;
	private double costTicket;
	private	int avaibleCount;
	@OneToMany(mappedBy="flightTimetable")
	private Collection<UserBooking> userBooking;
	
	public FlightTimetable() {}
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
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
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
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public int getAmountTickets() {
		return amountTickets;
	}
	public void setAmountTickets(int amountTickets) {
		this.amountTickets = amountTickets;
	}
	public double getCostTicket() {
		return costTicket;
	}
	public void setCostTicket(double costTicket) {
		this.costTicket = costTicket;
	}
	public int getAvaibleCount() {
		return avaibleCount;
	}
	public void setAvaibleCount(int avaibleCount) {
		this.avaibleCount = avaibleCount;
	}
	public Collection<UserBooking> getUserBooking() {
		return userBooking;
	}
	public void setUserBooking(Collection<UserBooking> userBooking) {
		this.userBooking = userBooking;
	}
	@Override
	public String toString() {
		return "FlightTimetable [id=" + id + ", flight=" + flight
				+ ", airCompany=" + airCompany + ", plainModel=" + plainModel
				+ ", departureCountry=" + departureCountry + ", departureCity="
				+ departureCity + ", departureAirport=" + departureAirport
				+ ", departureDate=" + departureDate + ", arrivalCountry="
				+ arrivalCountry + ", arrivalCity=" + arrivalCity
				+ ", arrivalAirport=" + arrivalAirport + ", arrivalDate="
				+ arrivalDate + ", amountTickets=" + amountTickets
				+ ", costTicket=" + costTicket + ", avaibleCount="
				+ avaibleCount + ", userBooking=" + userBooking + "]";
	}
		
	
	


}
