package com.quantas.airport.rest.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.quantas.airport.domain.Airports;
import com.quantas.airport.domain.Airport;

/**
 * Consumes the webservice exposed by quantas to get Airport details.
 * 
 * @author VinayBS
 *
 */
@Component
public class AirportsServiceClient {

	private static String QUANTAS_AIRPORTS_URL = "https://www.qantas.com.au/api/airports";

	public List<Airport> getAirportsListFromQuantas() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.ALL));

		HttpEntity<Airports> entity = new HttpEntity<Airports>(headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Airports> airports = restTemplate.exchange(QUANTAS_AIRPORTS_URL, HttpMethod.GET, entity,
				Airports.class);

		return airports.getBody().getAirports();
	}

	public static void main(String[] args) {
		List<Airport> airports = new AirportsServiceClient().getAirportsListFromQuantas();

		for (Airport airport : airports) {
			System.out.println(airport);
		}
	}
}
