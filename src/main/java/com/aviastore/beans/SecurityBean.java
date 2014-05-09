package com.aviastore.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.entitys.*;
import com.aviastore.services.*;


@Named
@Component
@Scope("session")
public class SecurityBean implements Serializable {
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
	private String firstName;
	private String lastName;
	private int permission;
	private List<Users> users;

	public SecurityBean() {
	}
	public void initUsers() {
		users = usersServices.getAllUsers();
	}
	public void resetUser() {
		login = "";
		password = "";
		firstName = "";
		lastName = "";
		permission = -1;
	}
	public void addUser() {
		Users newUser = new Users(login, password, firstName, lastName,
				permission);
		if (newUser != null) {
			if (usersServices.add(newUser) == true) {
				FacesContext.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,
										"", "User " + firstName + " "
												+ lastName + ", with login "
												+ login + " created."));
				resetUser();
			}
		}
	}
	public String permissionToString(Users userRole) {
		switch (userRole.getPermission()) {
		case Users.ACCOUNTANT:
			return "Accountant";
		case Users.ADMINISTRATOR:
			return "Administrator";
		case Users.ANALYTIC:
			return "Analyst";
		case Users.BLOCKED:
			return "Blocked user";
		case Users.SECURITY_OFFICER:
			return "Security officer";
		}
		return "Without role";
	}

	public void onEdit(RowEditEvent event) {
		Users usr = (Users) event.getObject();
		usersServices.update(usr);
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
