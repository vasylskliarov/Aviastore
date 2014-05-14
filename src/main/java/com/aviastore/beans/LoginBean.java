package com.aviastore.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
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
	private Users users;

	private boolean loggedIn = false;

	public LoginBean() {
	}

	public String getLink() {
		users = usersServices.isValid(login, password);
		int role = (users == null) ? -1 : users.getPermission();
		if (role != -1) {
			loggedIn = true;
			switch (role) {
			case Users.ACCOUNTANT:
				return "accountant.xhtml?faces-redirect=true";
			case Users.ADMINISTRATOR:
				return "administrator.xhtml?faces-redirect=true";
			case Users.ANALYTIC:
				return "analytic.xhtml?faces-redirect=true";

			case Users.SECURITY_OFFICER:
				return "security.xhtml?faces-redirect=true";
			case Users.BLOCKED: {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Доступ запрещен",
						"Ваш аккаунт был заблокирован администратором");
				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);
				return "login.xhtml?faces-redirect=true";
			}
			}
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Отказано в доступе", "Неправильный логин или пароль");
		RequestContext.getCurrentInstance().showMessageInDialog(message);

		return "login.xhtml?faces-redirect=true";
	}

	public void logOut() {
		loggedIn = false;
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		try {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.redirect(
							FacesContext.getCurrentInstance()
									.getExternalContext()
									.getRequestContextPath()
									+ "/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String generateLink(){
		int role = (users == null) ? -1 : users.getPermission();
		if (role != -1) {
			loggedIn = true;
			switch (role) {
			case Users.ACCOUNTANT:
				return "/secured/accountant.xhtml";
			case Users.ADMINISTRATOR:
				return "/secured/administrator.xhtml";
			case Users.ANALYTIC:
				return "/secured/analytic.xhtml";
			case Users.BLOCKED:
				return "blocked.xhtml";
			case Users.SECURITY_OFFICER:
				return "/secured/security.xhtml";
			}
		}
		return "login.xhtml";
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}