package com.aviastore.services;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;


@WebService
public interface FlightsWebServices {
	public List<String> getTimetableByDates(Date start, Date end);
}
