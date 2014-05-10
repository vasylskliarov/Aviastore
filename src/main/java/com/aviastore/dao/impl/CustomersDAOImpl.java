package com.aviastore.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.aviastore.dao.CustomersDAO;
import com.aviastore.entitys.*;

@Repository
public class CustomersDAOImpl implements CustomersDAO, Serializable {

	private static final long serialVersionUID = 1L;
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
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
