package com.aviastore.beans;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.services.*;
import com.aviastore.entitys.*;


@Named
@Component
@Scope("session")
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsersServices usersServices;
	public UsersServices getUsersServices() {
		return usersServices;
	}
	public void setUsersServices(UsersServices usersServices) {
		this.usersServices = usersServices;
	}
	
	private String login;
	private String password;
	
	public LoginBean() {}
	public String getLink() {
		int role = usersServices.isValid(login, password);
		if (role != -1) {
			switch (role) {
			case Users.ACCOUNTANT: return "accountant?faces-redirect=true";
			case Users.ADMINISTRATOR: return "administrator?faces-redirect=true";
			case Users.ANALYTIC: return "analytic?faces-redirect=true";
			case Users.BLOCKED:	return "blocked?faces-redirect=true";
			case Users.SECURITY_OFFICER: return "security?faces-redirect=true";
			}
		}
		return "login";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}