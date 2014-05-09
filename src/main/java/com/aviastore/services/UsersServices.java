package com.aviastore.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.aviastore.entitys.*;


public interface UsersServices {
	public boolean add(Users user);
	public List<Users> getAllUsers();
	public void update(Users user);
	public int isValid(String login, String password);

}
