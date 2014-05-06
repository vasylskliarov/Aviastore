package com.aviastore.dao.impl;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.aviastore.dao.UsersDAO;

@Repository
public class UsersDAOImpl implements UsersDAO{
	//TODO implements interface UsersDAO
	@PersistenceContext
	private EntityManager entityManager;

	public UsersDAOImpl() {}
	
}
