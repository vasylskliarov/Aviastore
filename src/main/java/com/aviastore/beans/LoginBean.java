package com.aviastore.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.impl.UsersServicesImpl;

@Component
@Scope("session")
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO create LoginBean
	
	//TODO in LoginBean try to use interface usersServices
	@Autowired
	private UsersServicesImpl usersServices;

	
	public LoginBean() {}
	
	

}
