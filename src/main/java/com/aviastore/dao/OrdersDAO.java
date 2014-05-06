package com.aviastore.dao;

import java.util.*;
import com.aviastore.entitys.*;

public interface OrdersDAO {
	public boolean addOrder(Orders order);
	public boolean deleteOrder(Orders order);
	public boolean changeOrderStatusToSold(Orders order);
	public boolean changeOrderStatusToCanceled(Orders order);
	public List<Orders> getOrders(Date start, Date end, int status);
	public List<Orders> getOrders(Date start, Date end, String departure, String arrival, String cust, String email, int status);
	public List<Report> getDQPResult(Date start, Date end);
	public List<Report> getPQPResult(Date start, Date end);
}
