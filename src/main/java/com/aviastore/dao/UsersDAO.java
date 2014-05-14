package com.aviastore.dao;

import java.util.*;

import com.aviastore.entitys.*;

public interface UsersDAO {
	public boolean add(Users user);
	public List<Users> getAllUsers();
	public void update(Users user);
	public Users isValid(String login, String password);
}
