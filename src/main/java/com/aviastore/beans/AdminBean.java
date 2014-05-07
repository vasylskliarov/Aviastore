package com.aviastore.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.impl.*;

@Component
@Scope("session")
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO create AdminBean
	
	//TODO in AdminBean try to use interfaces OrdersServices and FlightsServices
	@Autowired 
	OrdersServicesImpl ordersServices;
	@Autowired
	FlightsServicesImpl flightsServices;
	
	
	public AdminBean() {}
	
	
	


}
