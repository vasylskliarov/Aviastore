package com.aviastore.dao;

import java.io.*;
import java.util.*;

import javax.xml.bind.JAXBException;

import com.aviastore.entitys.Airport;

public interface AirportsDAO {
	public List<Airport> unmarshalAirports(File importFile) throws JAXBException;
	public void marshalAirports(List<Airport> books, File selectedFile) throws IOException, JAXBException;
}
