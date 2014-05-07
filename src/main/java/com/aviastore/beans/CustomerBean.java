package com.aviastore.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.impl.*;

@Component
@Scope("session")
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO create CustomerBean
	
	//TODO in CustomerBean try to use interfaces FlightsServices and OrdersServices
	@Autowired
	private FlightsServicesImpl flightsServices;
	@Autowired 
	OrdersServicesImpl ordersServices;
	
	
	public CustomerBean() {}
	
	
}
