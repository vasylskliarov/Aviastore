package com.aviastore.test;

import java.io.*;
import java.util.*;

import javax.xml.bind.*;

import com.aviastore.dao.impl.*;
import com.aviastore.entitys.*;

public class MarshallerAirportsTest {
	public static void main(String[] args) throws JAXBException {
		List<Airport> objForMarshaling = new ArrayList<Airport>();
		AirportsDAOImpl  airportsDAOImpl = new AirportsDAOImpl();
		objForMarshaling = airportsDAOImpl.unmarshalAirports(new File("C:\\airports.xml"));
		int count = 0;
		for (Airport pr : objForMarshaling){			
			System.out.println(pr);
			count++;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n В мире всего "+count + " аэропортов");
	}
}
