package com.aviastore.dao.impl;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.aviastore.dao.*;
import com.aviastore.entitys.*;

import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOImpl implements UsersDAO, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;

	public UsersDAOImpl() {}

	@Override
	public boolean add(Users user) {
		List<Users> users = null;
		TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u WHERE u.login = :login", Users.class);
		query.setParameter("login", user.getLogin());
		users = query.getResultList();
		if(users.size() != 0){
			return false;
		}
		entityManager.persist(user);
		entityManager.flush();
		return true;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = null;
		TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u", Users.class);
		users = query.getResultList();
		return users;
	}

	@Override
	public void update(Users user) {
		Users usr = entityManager.find(Users.class, user.getId());
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setLogin(user.getLogin());
		usr.setPassword(user.getPassword());
		usr.setPermission(user.getPermission());
	}

	@Override
	public int isValid(String login, String password) {
		List <Users> users = null;
		TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u WHERE u.login = :log AND u.password = :pas", Users.class);
		query.setParameter("log", login);
		query.setParameter("pas", password);
		users = query.getResultList();
		if (users.size()!=0){
			return users.get(0).getPermission();
		}else {
			return -1;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
