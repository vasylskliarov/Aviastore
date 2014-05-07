package com.aviastore.dao.impl;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.aviastore.dao.CustomersDAO;
import com.aviastore.entitys.*;

@Repository
public class CustomersDAOImpl implements CustomersDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public CustomersDAOImpl() {}
	@Override
	public void addCustomer(Customers customer) {
		if (customer == null)
			return;
		entityManager.persist(customer);
	}
	@Override
	public List<Customers> getCustomers() {
		TypedQuery<Customers> query = entityManager.createQuery("SELECT c FROM Customers c",Customers.class);
		List<Customers> resultList = query.getResultList();
		return resultList;
	}
}
