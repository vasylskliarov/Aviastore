package com.aviastore.services;

import java.util.*;
import com.aviastore.entitys.*;

public interface OrdersServices {
	public boolean addOrder(Orders order);
	public boolean deleteOrder(Orders order);
	public boolean changeOrderStatusToSold(Orders order);
	public boolean changeOrderStatusToCanceled(Orders order);
	public List<Orders> getOrders(Date startDate, Date endDate, int status);
	public List<Orders> getOrders(String departureCity, String arrivalCity, String firstName, String lastName, String email, String phoneNumber, int status);
	public List<Orders> getOrders(Date startDate, Date endDate, String departureCity, String arrivalCity, String firstName, String lastName, String email, String phoneNumber, int status);
	public List<Report> getStatByCitys(Date startDate, Date endDate);
	public List<Report> getStatByDates(Date startDate, Date endDate);

}
