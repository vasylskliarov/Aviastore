package com.aviastore.entitys;

import java.util.*;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@ManyToMany
	Collection<Flights> flights;
	@OneToMany(mappedBy = "customerId")
	private Collection<Orders> orders;
	public Customer() {}
	public Customer(String firstName, String lastName, String email,
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
	
	
	
	

}
