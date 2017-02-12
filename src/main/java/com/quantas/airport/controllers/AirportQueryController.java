package com.quantas.airport.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quantas.airport.domain.Airport;
import com.quantas.airport.rest.client.AirportsServiceClient;

/**
 * Main class that takes in filter requests from user to filter quantas airports
 * based on code, country and international and regional airports.
 * 
 * @author VinayBS
 *
 */
@RestController
public class AirportQueryController {

	public static final String AIRPIRTS_QUERY_BASE_URL = "/svc/v1/airports";

	@Autowired
	private AirportsServiceClient airportsService;

	/**
	 * 
	 * @param country
	 * @param code
	 * @param showInternationalAirports
	 * @param showReginoalAirports
	 * @return
	 */
	@RequestMapping(value = AIRPIRTS_QUERY_BASE_URL, method = RequestMethod.GET)
	public ResponseEntity<List<Airport>> getAirportsforQuery(
			@RequestParam(required = false, value = "country") String country,
			@RequestParam(required = false, value = "code") String code,
			@RequestParam(required = false, value = "showInternationalAirports", defaultValue = "true") Boolean showInternationalAirports,
			@RequestParam(required = false, value = "showReginoalAirports", defaultValue = "true") Boolean showReginoalAirports) {

		List<Airport> filteredAirports = new ArrayList<Airport>();
		List<Airport> airports = airportsService.getAirportsListFromQuantas();

		if (!airports.isEmpty()) {

			for (Airport airport : airports) {
				if ((!StringUtils.isEmpty(country) && !country.equalsIgnoreCase(airport.getCountry().getCode()))
						|| (!StringUtils.isEmpty(code) && !code.equalsIgnoreCase(airport.getCode()))
						|| (!showInternationalAirports && airport.getInternational_airport())
						|| (!showReginoalAirports && !airport.getRegional_airport())) {
					continue;
				}
				filteredAirports.add(airport);

			}

		}

		return new ResponseEntity<List<Airport>>(filteredAirports, HttpStatus.OK);

	}
}
