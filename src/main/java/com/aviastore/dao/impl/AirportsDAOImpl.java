package com.aviastore.dao.impl;

import java.io.*;
import java.util.*;

import javax.xml.bind.*;

import org.springframework.stereotype.Repository;

import com.aviastore.dao.AirportsDAO;
import com.aviastore.entitys.Airport;
import com.aviastore.entitys.Airports;

@Repository
public class AirportsDAOImpl implements AirportsDAO, Serializable {
	private static final long serialVersionUID = 1L;

	public AirportsDAOImpl() {
	}

	@Override
	public void marshalAirports(List<Airport> books, File selectedFile)
			throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(Airports.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
		m.marshal(new Airports(books), writer);
		writer.close();
	}

	@Override
	public List<Airport> unmarshalAirports(File importFile)
			throws JAXBException {
		Airports rezult = new Airports();
		JAXBContext context = JAXBContext.newInstance(Airports.class);
		Unmarshaller um = context.createUnmarshaller();
		rezult = (Airports) um.unmarshal(importFile);
		return rezult.getAirports();
	}

}
