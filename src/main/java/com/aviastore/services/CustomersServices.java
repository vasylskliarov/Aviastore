package com.aviastore.services;

import java.util.*;
import com.aviastore.entitys.*;

public interface CustomersServices {
	public void addCustomer(Customers customer);
	public List<Customers> getCustomers();
}
