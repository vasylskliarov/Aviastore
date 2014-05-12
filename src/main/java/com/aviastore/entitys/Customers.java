package com.aviastore.entitys;

import java.io.Serializable;
import java.util.*;

import javax.inject.Named;
import javax.persistence.*;

@Named
@Entity
public class Customers implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Customers_Flights")
	private Collection<Flights> flights;
	
	
	@OneToMany(mappedBy = "customerId")
	private Collection<Orders> orders;
	public Customers() {}
	public Customers(String firstName, String lastName, String email,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
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
	public Collection<Flights> getFlights() {
		return flights;
	}
	public void setFlights(Collection<Flights> flights) {
		this.flights = flights;
	}
	public Collection<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", flights=" + flights
				+ ", orders=" + orders + "]";
	}
	
	
	
	
	

}
