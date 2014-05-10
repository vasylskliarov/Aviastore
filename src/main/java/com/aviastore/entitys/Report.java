package com.aviastore.entitys;

import java.io.Serializable;
import java.util.*;

import javax.inject.Named;
import javax.persistence.Transient;

@Named
public class Report implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	private Date date;
	private Long quantity;
	private double total;
	private String origin = "";
	private String destination = "";

	public Report() {}
	public Report(Date date, Long quantity, double total) {
		super();
		this.date = date;
		this.quantity = quantity;
		this.total = total;
	}
	
	public Report(String origin, String destination, Long quantity, Double total){
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.total = total;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Report [date=" + date + ", quantity=" + quantity + ", total="
				+ total + ", origin=" + origin + ", destination=" + destination
				+ "]";
	}
}
