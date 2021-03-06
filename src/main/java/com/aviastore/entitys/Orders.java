package com.aviastore.entitys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.*;

@Named
@Entity
public class Orders implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	public static final int BOOKED=0;
	public static final int SOLD=1;
	public static final int CANCELED=2;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="customerid", referencedColumnName = "id")
	private Customers customerId;
	@ManyToOne
	@JoinColumn(name="flightid", referencedColumnName = "id")
	private Flights flightId;
	private int amountTickets;
	private double totalPrice;
	private Timestamp bookingDate;
	private int payStatus=BOOKED;
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
	@Transient
	public Date getDateD() {		
		return new Date( this.bookingDate.getTime());
	}
	@Transient
	public void setDateD(Date dateD) {
		this.dateD = dateD;
		this.setBookingDate(new Timestamp(dateD.getTime()));
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerId=" + customerId
				+ ", flightId=" + flightId + ", amountTickets=" + amountTickets
				+ ", totalPrice=" + totalPrice + ", bookingDate=" + bookingDate
				+ ", payStatus=" + payStatus + ", dateD=" + dateD + "]";
	}
}
