package com.aviastore.entitys;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Airport implements Serializable{
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private int id;
	private String name_rus;
	private String name_eng;
	private String city_rus;
	private String city_eng;
	private String country_rus;
	private String country_eng;
	private double latitude;
	private double longitude;
	
	public Airport() {}
	
	public Airport(String name_rus, String name_eng, String city_rus,
			String city_eng, String country_rus, String country_eng,
			double latitude, double longitude) {
		super();
		this.name_rus = name_rus;
		this.name_eng = name_eng;
		this.city_rus = city_rus;
		this.city_eng = city_eng;
		this.country_rus = country_rus;
		this.country_eng = country_eng;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	@XmlTransient
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_rus() {
		return name_rus;
	}
	public void setName_rus(String name_rus) {
		this.name_rus = name_rus;
	}
	public String getName_eng() {
		return name_eng;
	}
	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
	}
	public String getCity_rus() {
		return city_rus;
	}
	public void setCity_rus(String city_rus) {
		this.city_rus = city_rus;
	}
	public String getCity_eng() {
		return city_eng;
	}
	public void setCity_eng(String city_eng) {
		this.city_eng = city_eng;
	}
	public String getCountry_rus() {
		return country_rus;
	}
	public void setCountry_rus(String country_rus) {
		this.country_rus = country_rus;
	}
	public String getCountry_eng() {
		return country_eng;
	}
	public void setCountry_eng(String country_eng) {
		this.country_eng = country_eng;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", name_rus=" + name_rus + ", name_eng="
				+ name_eng + ", city_rus=" + city_rus + ", city_eng="
				+ city_eng + ", country_rus=" + country_rus + ", country_eng="
				+ country_eng + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

	
}
