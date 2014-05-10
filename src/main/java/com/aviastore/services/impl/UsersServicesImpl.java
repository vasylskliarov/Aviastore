package com.aviastore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

import com.aviastore.dao.UsersDAO;
import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Service
public class UsersServicesImpl implements UsersServices, Serializable{
	private static final long serialVersionUID = 1L;
	//TODO try to use from interface UsersDAO, not from class UsersDAOImpl
	@Autowired
	private UsersDAO usersDAO;

	@Override
	@Transactional
	public boolean add(Users user){
		return usersDAO.add(user);
	}
	@Override
	@Transactional
	public List<Users> getAllUsers(){
		return usersDAO.getAllUsers();
	}
	@Override
	@Transactional
	public void update(Users user){
		usersDAO.update(user);
	}
	@Override
	@Transactional
	public int isValid(String login, String password){
		return usersDAO.isValid(login, password);
	}
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
