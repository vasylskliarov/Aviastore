package com.aviastore.entitys;

import java.util.*;

import javax.inject.Named;

@Named
public class Report {
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
	public Report(Long quantity, double total, String origin, String destination) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.origin = origin;
		this.destination = destination;
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
}
