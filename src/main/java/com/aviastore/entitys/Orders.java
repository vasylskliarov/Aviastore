package com.aviastore.entitys;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.*;

@Named
@Entity
public class Orders {
	public static final int BOOKED=0;
	public static final int SOLD=1;
	public static final int CANCELED=2;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="customerId_id")
	private Customers customerId;
	@ManyToOne
	@JoinColumn(name="flightId_id")
	private Flights flightId;
	private int amountTickets;
	private double totalPrice;
	private Timestamp bookingDate;
	private int payStatus=BOOKED;
	
	//TODO разобраться для чего использую dateD
	@Transient
	private Date dateD;

	public Orders() {}
	public Orders(Customers customerId, Flights flightId, int amountTickets, Date time) {
		super();
		this.customerId = customerId;
		this.flightId = flightId;
		this.amountTickets = amountTickets;
		this.totalPrice = this.calculateTotal();
		this.bookingDate = new Timestamp(time.getTime());
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customers getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}
	public Flights getFlightId() {
		return flightId;
	}
	public void setFlightId(Flights flightId) {
		this.flightId = flightId;
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
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	
	//TODO разобраться используется ли getDtimeD() и setDtimeD(Date dtimeD)
	@Transient
	public Date getDateD() {
		return dateD;
	}
	@Transient
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public static int getBooked() {
		return BOOKED;
	}
	public static int getSold() {
		return SOLD;
	}
	public static int getCanceled() {
		return CANCELED;
	}
	
	private double calculateTotal() {
		return flightId.getTicketsPrice()*this.getAmountTickets();
	}
}
