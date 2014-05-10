package com.aviastore.entitys;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

@Named
@Entity
public class Users implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	public static final int SECURITY_OFFICER=0;
	public static final int ADMINISTRATOR=1;
	public static final int ACCOUNTANT=2;
	public static final int ANALYTIC=3;
	public static final int BLOCKED=4;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private int permission;

	public Users() {}
	public Users(String login, String password, String firstName,
			String lastName, int permission) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.permission = permission;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static int getSecurityOfficer() {
		return SECURITY_OFFICER;
	}
	public static int getAdministrator() {
		return ADMINISTRATOR;
	}
	public static int getAccountant() {
		return ACCOUNTANT;
	}
	public static int getAnalytic() {
		return ANALYTIC;
	}
	public static int getBlocked() {
		return BLOCKED;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", permission=" + permission + "]";
	}
	
}
