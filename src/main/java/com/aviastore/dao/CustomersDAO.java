package com.aviastore.dao;

import java.util.List;
import com.aviastore.entitys.*;

public interface CustomersDAO {
	public void addCustomer(Customers customer);
	public List<Customers> getCustomers();
	public boolean checkEmail(String email);
}
