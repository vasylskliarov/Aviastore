package com.aviastore.entitys;

import javax.persistence.*;

@Entity
public class Security {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String permission;
	@Transient
	boolean editable = false;
	@Transient
	private boolean loggedIn;
		
	public Security() {}
	@Transient
	public boolean isLoggedIn() {
		return loggedIn;
	}
	@Transient
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	@Transient
	public boolean getEditable() {
		return editable;
	}
	@Transient
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Security [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", login=" + login + ", password="
				+ password + ", permission=" + permission + ", editable="
				+ editable + ", loggedIn=" + loggedIn + "]";
	}
	
	
	
}
