package com.aviastore.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.impl.*;

@Component
@Scope("session")
public class AccountantBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO create AccountantBean
	
	//TODO in AccountantBean try to use interface OrdersServices
	@Autowired 
	OrdersServicesImpl ordersServices;

	
	public AccountantBean() {}
}
