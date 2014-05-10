package com.aviastore.tests;



import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aviastore.dao.FlightsDAO;
import com.aviastore.entitys.Flights;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/application-config.xml"})
@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class FlightDAOJUnitTest {
 
    @Autowired
    FlightsDAO flightsDAO;
 
    
    
    @Test
    public void testCreateUser() {
        Flights flights1 = new Flights();
		flights1.setFlight("2222");
		flights1.setAirCompany("Тестовый бин");
		flights1.setPlainModel("Тестовый бин");
		flights1.setDepartureCountry("Тестовый бин");
		flights1.setDepartureCity("London");
		flights1.setDepartureAirport("Тестовый бин");
		Timestamp depTime1 = new Timestamp(new GregorianCalendar(2014,5,10,14,40).getTimeInMillis());
		flights1.setDepartureTime(depTime1);
		flights1.setArrivalCountry("Тестовый бин");
		flights1.setArrivalCity("London");
		flights1.setArrivalAirport("Тестовый бин");
		Timestamp arrTime1 = new Timestamp(new GregorianCalendar(2014,5,11,14,40).getTimeInMillis());
		flights1.setArrivalTime(arrTime1);
		flights1.setTicketsPrice(222.32);
		flights1.setAvailableCount(1111);
		
        Flights flights2 = new Flights();
		flights2.setFlight("2222");
		flights2.setAirCompany("Тестовый бин");
		flights2.setPlainModel("Тестовый бин");
		flights2.setDepartureCountry("Тестовый бин");
		flights2.setDepartureCity("London");
		flights2.setDepartureAirport("Тестовый бин");
		Timestamp depTime2 = new Timestamp(new GregorianCalendar(2014,5,10,14,40).getTimeInMillis());
		flights2.setDepartureTime(depTime2);
		flights2.setArrivalCountry("Тестовый бин");
		flights2.setArrivalCity("London");
		flights2.setArrivalAirport("Тестовый бин");
		Timestamp arrTime2 = new Timestamp(new GregorianCalendar(2014,5,11,14,40).getTimeInMillis());
		flights2.setArrivalTime(arrTime2);
		flights2.setTicketsPrice(222.32);
		flights2.setAvailableCount(1111);
		
		
		assertTrue(flights1.getId()==0);
        flightsDAO.addFlight(flights1);
        assertNotNull(flights1);
        assertTrue(flights1.getId() >= 0);
        
		assertTrue(flights2.getId()==0);
        flightsDAO.addFlight(flights2);
        assertNotNull(flights2);
        assertTrue(flights2.getId() >= 0);
    }
}