package com.aviastore.beans;

import java.io.Serializable;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import org.primefaces.event.RowEditEvent;
import com.aviastore.entitys.*;
import com.aviastore.services.impl.*;

@Component
@Scope("session")
public class AccountantBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//TODO in AccountantBean try to use interface OrdersServices
	@Autowired 
	OrdersServicesImpl ordersServices;
	
	private String firstNameBooked="";
	private String lastNameBooked="";
	private String emailBooked="";
	private String phoneNumberBooked="";
	private String departureCityBooked="";
	private String arrivalCityBooked="";
	
	private String firstNameSold="";
	private String lastNameSold="";
	private String emailSold="";
	private String phoneNumberSold="";
	private String departureCitySold="";
	private String arrivalCitySold="";

	private List<Orders> bookedOrders = new LinkedList<>() ;
	private List<Orders> soldOrders = new LinkedList<>();
	
	private static Date startDate = new Date(0);
	private static Date endDate;
	static{
		GregorianCalendar tmp = new GregorianCalendar();
		tmp.roll(Calendar.YEAR, 2);
		endDate = tmp.getTime();
	}
	public AccountantBean() {}
	@PostConstruct
	public void ordersInit() {
		bookedOrders = ordersServices.getOrders("","","","","","", Orders.BOOKED);
		soldOrders = ordersServices.getOrders( startDate, endDate,"","","","","","",Orders.SOLD);
	}
	
	public void searchBookedDataTable(){
		bookedOrders = ordersServices.getOrders(departureCityBooked, arrivalCityBooked, firstNameBooked, lastNameBooked, emailBooked, phoneNumberBooked, Orders.BOOKED);
	}
	
	public void searchSoldDataTable(){
		soldOrders = ordersServices.getOrders(startDate, endDate, departureCitySold, arrivalCitySold, firstNameSold, lastNameSold, emailSold, phoneNumberSold, Orders.SOLD);
	}
	
	public void onEditBooked(RowEditEvent event) {  
		System.out.println("Convert booked tickets to sold");
        Orders order = (Orders)event.getObject();
        if (order.getPayStatus() == Orders.BOOKED){
        	return;
        }
        ordersServices.changeOrderStatusToSold(order);
        this.searchBookedDataTable();
        this.searchSoldDataTable();
    }
	public void onEditSold(RowEditEvent event) {  
		System.out.println("soldTocancell");
        Orders order = (Orders)event.getObject();
        if (order.getPayStatus() == Orders.SOLD){
        	return;
        }
        ordersServices.changeOrderStatusToCanceled(order);
        this.searchBookedDataTable();
        this.searchSoldDataTable();
    }
	public OrdersServicesImpl getOrdersServices() {
		return ordersServices;
	}
	public void setOrdersServices(OrdersServicesImpl ordersServices) {
		this.ordersServices = ordersServices;
	}
	public String getFirstNameBooked() {
		return firstNameBooked;
	}
	public void setFirstNameBooked(String firstNameBooked) {
		this.firstNameBooked = firstNameBooked;
	}
	public String getLastNameBooked() {
		return lastNameBooked;
	}
	public void setLastNameBooked(String lastNameBooked) {
		this.lastNameBooked = lastNameBooked;
	}
	public String getEmailBooked() {
		return emailBooked;
	}
	public void setEmailBooked(String emailBooked) {
		this.emailBooked = emailBooked;
	}
	public String getPhoneNumberBooked() {
		return phoneNumberBooked;
	}
	public void setPhoneNumberBooked(String phoneNumberBooked) {
		this.phoneNumberBooked = phoneNumberBooked;
	}
	public String getDepartureCityBooked() {
		return departureCityBooked;
	}
	public void setDepartureCityBooked(String departureCityBooked) {
		this.departureCityBooked = departureCityBooked;
	}
	public String getArrivalCityBooked() {
		return arrivalCityBooked;
	}
	public void setArrivalCityBooked(String arrivalCityBooked) {
		this.arrivalCityBooked = arrivalCityBooked;
	}
	public String getFirstNameSold() {
		return firstNameSold;
	}
	public void setFirstNameSold(String firstNameSold) {
		this.firstNameSold = firstNameSold;
	}
	public String getLastNameSold() {
		return lastNameSold;
	}
	public void setLastNameSold(String lastNameSold) {
		this.lastNameSold = lastNameSold;
	}
	public String getEmailSold() {
		return emailSold;
	}
	public void setEmailSold(String emailSold) {
		this.emailSold = emailSold;
	}
	public String getPhoneNumberSold() {
		return phoneNumberSold;
	}
	public void setPhoneNumberSold(String phoneNumberSold) {
		this.phoneNumberSold = phoneNumberSold;
	}
	public String getDepartureCitySold() {
		return departureCitySold;
	}
	public void setDepartureCitySold(String departureCitySold) {
		this.departureCitySold = departureCitySold;
	}
	public String getArrivalCitySold() {
		return arrivalCitySold;
	}
	public void setArrivalCitySold(String arrivalCitySold) {
		this.arrivalCitySold = arrivalCitySold;
	}
	public List<Orders> getBookedOrders() {
		return bookedOrders;
	}
	public void setBookedOrders(List<Orders> bookedOrders) {
		this.bookedOrders = bookedOrders;
	}
	public List<Orders> getSoldOrders() {
		return soldOrders;
	}
	public void setSoldOrders(List<Orders> soldOrders) {
		this.soldOrders = soldOrders;
	}
	public static Date getStartDate() {
		return startDate;
	}
	public static void setStartDate(Date startDate) {
		AccountantBean.startDate = startDate;
	}
	public static Date getEndDate() {
		return endDate;
	}
	public static void setEndDate(Date endDate) {
		AccountantBean.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
