package com.aviastore.tests;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aviastore.services.FlightsServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/src/main/resources/spring/application-config.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UnmarshalAirportsTest {

	@Autowired
	FlightsServices flightsServices;

	@Test
	public void testUnmarshalAirports() {
		
//		Set <String> airportNames = flightsServices.airportNames();
//		Set <String> cityNames = flightsServices.cityNames();
//		Set <String> countryNames = flightsServices.countryNames();
//		for(String print : airportNames){
//			System.out.println(print);
//		}
		// assertTrue(flights1.getId()==0);
		// flightsDAO.addFlight(flights1);
		// assertNotNull(flights1);
		// assertTrue(flights1.getId() >= 0);
		//
		// assertTrue(flights2.getId()==0);
		// flightsDAO.addFlight(flights2);
		// assertNotNull(flights2);
		// assertTrue(flights2.getId() >= 0);
	}
}
