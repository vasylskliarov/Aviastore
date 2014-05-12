package com.aviastore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

import com.aviastore.dao.*;
import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Service
public class CustomersServicesImpl implements CustomersServices, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomersDAO customersDAO;
	
	@Override
	@Transactional
	public void addCustomer(Customers customer){
		customersDAO.addCustomer(customer);
	}
	@Override
	@Transactional
	public List<Customers> getCustomers(){
		return customersDAO.getCustomers();	
	}
	@Transactional
	public CustomersDAO getCustomersDAO() {
		return customersDAO;
	}
	@Transactional
	public void setCustomersDAO(CustomersDAO customersDAO) {
		this.customersDAO = customersDAO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
