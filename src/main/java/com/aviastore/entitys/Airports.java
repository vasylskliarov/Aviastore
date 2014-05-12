package com.aviastore.entitys;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "airports")
public class Airports {
	@XmlElement(name = "airport", type = Airport.class)
	private List <Airport> airports;
	public Airports() {}
	public Airports(List<Airport> airports) {
		super();
		this.airports = airports;
	}	

	public List<Airport> getAirports() {
		return airports;
	}
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
	@Override
	public String toString() {
		return "Airports [airports=" + airports + "]";
	}
}
