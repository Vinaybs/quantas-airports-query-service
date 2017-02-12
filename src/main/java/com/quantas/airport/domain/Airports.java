package com.quantas.airport.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airports {

	@JsonProperty("airports")
	private List<Airport> airports = null;

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
}
