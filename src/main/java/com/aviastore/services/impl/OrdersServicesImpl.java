package com.aviastore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

import com.aviastore.dao.OrdersDAO;
import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Service
public class OrdersServicesImpl implements OrdersServices, Serializable {
	private static final long serialVersionUID = 1L;
	//TODO try to use from interface OrdersDAO, not from class OrdersDAOImpl
	@Autowired
	OrdersDAO ordersDAO;
	
	@Override
	@Transactional
	public boolean addOrder(Orders order){
		return ordersDAO.addOrder(order);
	}
	@Override
	@Transactional
	public boolean deleteOrder(Orders order){
		return ordersDAO.deleteOrder(order);
	}
	@Override
	@Transactional
	public boolean changeOrderStatusToSold(Orders order){
		return ordersDAO.changeOrderStatusToSold(order);
	}
	@Override
	@Transactional
	public boolean changeOrderStatusToCanceled(Orders order){
		return ordersDAO.changeOrderStatusToCanceled(order);
	}
	@Override
	@Transactional
	public List<Orders> getOrders(Date startDate, Date endDate, int status){
		return ordersDAO.getOrders(startDate, endDate, status);		
	}
	@Override
	@Transactional
	public List<Orders> getOrders(String departureCity, String arrivalCity, String firstName, String lastName, String email, String phoneNumber, int status){
		GregorianCalendar moreThan3Days = new GregorianCalendar();
		moreThan3Days.roll(Calendar.DAY_OF_MONTH, -3);
		Date startDate = new Date(moreThan3Days.getTimeInMillis());
		Date endDate = new Date();
		return ordersDAO.getOrders(startDate, endDate, departureCity, arrivalCity, firstName, lastName, email, phoneNumber, status);
	}
	
	
	@Override
	@Transactional
	public List<Orders> getOrders(Date startDate, Date endDate, String departureCity, String arrivalCity, String firstName, String lastName, String email, String phoneNumber, int status){
		return ordersDAO.getOrders(startDate, endDate, departureCity, arrivalCity, firstName, lastName, email, phoneNumber, status);
	}
	@Override
	@Transactional
	public List<Report> getStatByCitys(Date startDate, Date endDate){
		return ordersDAO.getStatByCitys(startDate, endDate);
	}
	@Override
	@Transactional
	public List<Report> getStatByDates(Date startDate, Date endDate){
		return ordersDAO.getStatByDates(startDate, endDate);
	}
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
