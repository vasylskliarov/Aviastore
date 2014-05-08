package com.aviastore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.aviastore.dao.impl.*;
import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Service
public class CustomersServicesImpl implements CustomersServices {
	//TODO try to use from interface CustomersDAO, not from class CustomersDAOImpl
	@Autowired
	private CustomersDAOImpl customersDAO;
	
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
}
