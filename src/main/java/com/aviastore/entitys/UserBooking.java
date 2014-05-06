package com.aviastore.entitys;

import java.sql.Timestamp;

import javax.persistence.*;



@Entity
public class UserBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private Timestamp bookingDate;
	private int flightId;
	private String email;
	private String phoneNumber;
	private int amountTickets;
	private double totalPrice;
	private String payStatus;
	@ManyToOne
	@JoinColumn(name = "flightId", referencedColumnName = "id")
	private FlightTimetable flightTimetable;

	public UserBooking() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
	public int getAmountTickets() {
		return amountTickets;
	}
	public void setAmountTickets(int amountTickets) {
		this.amountTickets = amountTickets;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public FlightTimetable getFlightTimetable() {
		return flightTimetable;
	}
	public void setFlightTimetable(FlightTimetable flightTimetable) {
		this.flightTimetable = flightTimetable;
	}
	@Override
	public String toString() {
		return "UserBooking [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", bookingDate=" + bookingDate
				+ ", flightId=" + flightId + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", amountTickets="
				+ amountTickets + ", totalPrice=" + totalPrice + ", payStatus="
				+ payStatus + ", flightTimetable=" + flightTimetable + "]";
	}
}
