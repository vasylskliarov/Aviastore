package com.aviastore.dao.impl;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.aviastore.dao.FlightsDAO;

@Repository
public class FlightsDAOImpl implements FlightsDAO {
	//TODO implements interface OrdersDAO
	@PersistenceContext
	private EntityManager entityManager;

	public FlightsDAOImpl() {}
	
}
