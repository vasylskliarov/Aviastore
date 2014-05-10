package com.aviastore.tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javassist.tools.framedump;

import com.aviastore.dao.FlightsDAO;
import com.aviastore.entitys.Flights;

public class FlightsDAOImplTEST {
	private FlightsDAO flightsDAO;
	private Flights flForDelite;
	

	public FlightsDAOImplTEST() {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		    BeanFactory factory = context;
		   flightsDAO = (FlightsDAO) factory
		        .getBean("flightsDAOImpl");
		    
		  }
	

	public static void main(String[] args) {
		FlightsDAOImplTEST main = new FlightsDAOImplTEST();
		main.startAllTests();

		
		/*
		main.addFlight(Flights flight);	
		main.getTimetableByDates(Date start, Date end);
		
		
	
		
		
		*/
		
		
		
		/*
		
		
	
		main.updateDepartureTime(Flights flight, GregorianCalendar date);
		main.updateArrivalTime(Flights flight, GregorianCalendar date);
		main.updateFreeTickets(Flights flight, int quantity);
		main.updatePrice(Flights flight, double price);
		main.updateAvailableTickets(Flights flight, int quantity);
		main.updateBookedTickets(Flights flight, int quantity);
		main.updateSoldTickets(Flights flight, int quantity);
		main.update(Flights flight);
		main.deleteFlight(Flights flight);
		
		*/
		
		
		
		
	}
	public void startAllTests(){
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~this.addFlight();~~~~~~~~~~~~~~~~~~~~~");
		this.addFlight();
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~this.getTimetableByDatesDateDate();~~~~~~~~~~~~~~~~~~~~~");
		this.getTimetableByDatesDateDate();
		
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~this.deleteFlight();~~~~~~~~~~~~~~~~~~~~~");
		this.deleteFlight();
		System.out.println("Все тесты FlightsDAO прошел успешно");
	}
	

	public void addFlight(){
		Flights flights = new Flights();
		flights.setFlight("2222");
		flights.setAirCompany("Тестовый бин");
		flights.setPlainModel("Тестовый бин");
		flights.setDepartureCountry("Тестовый бин");
		flights.setDepartureCity("London");
		flights.setDepartureAirport("Тестовый бин");
		Timestamp depTime = new Timestamp(new GregorianCalendar(2014,5,10,14,40).getTimeInMillis());
		flights.setDepartureTime(depTime);
		flights.setArrivalCountry("Тестовый бин");
		flights.setArrivalCity("London");
		flights.setArrivalAirport("Тестовый бин");
		Timestamp arrTime = new Timestamp(new GregorianCalendar(2014,5,11,14,40).getTimeInMillis());
		flights.setArrivalTime(arrTime);
		flights.setTicketsPrice(222.32);
		flights.setAvailableCount(1111);
		flightsDAO.addFlight(flights);
		System.out.println("Полет:\n"+flights + "\n был успешно добавлен");
		flForDelite = flights;
	}
	
	
	
	public void getTimetableByDatesDateDate(){
		//TODO метод не работает!!!
		System.out.println("Печать всех в таблице:");
		List <Flights> list = flightsDAO.getTimetableByDates(new GregorianCalendar(2013,5,11,14,40).getGregorianChange(), new GregorianCalendar(2015,5,11,14,40).getGregorianChange());
		for (Flights pr : list){
			if(pr!=null)
				System.out.println(pr);
		}
	}
	
	public void deleteFlight(){
		System.out.println("Удаляю:    "+flightsDAO);
		flightsDAO.deleteFlight(flForDelite);
	}
	

}
