package com.aviastore.dao.impl;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.aviastore.dao.OrdersDAO;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
	//TODO implements interface OrdersDAO
	@PersistenceContext
	private EntityManager entityManager;

	public OrdersDAOImpl() {}
	
}
