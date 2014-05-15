package com.aviastore.services.impl;

import java.util.*;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviastore.entitys.Flights;
import com.aviastore.services.*;


@WebService(endpointInterface = "com.aviastore.services.FlightsWebServices")
@Component

public class FlightsWebServicesImpl implements FlightsWebServices {
	@Autowired
	FlightsServices flightsServices;

	@Override
	public List<String> getTimetableByDates(Date start, Date end) {
		List<Flights> fligts = flightsServices.getTimetableByDates(start, end);
		List<String> rezult = new ArrayList<String>();
		for (Flights fl :fligts){
			rezult.add(fl.toString());
		}
		return rezult;
	}
}
