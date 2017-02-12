package com.quantas.airport.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.quantas.airport.QuantasAirportQueryServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuantasAirportQueryServiceApplication.class)
public class AirportsQueryControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockmvc = null;

	@Before
	public void setup() {

		this.mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void airportsControllerReturnsPositiveResponseAndCorrectContentType() throws Exception {
		String url = new StringBuilder().append(AirportQueryController.AIRPIRTS_QUERY_BASE_URL).toString();

		mockmvc.perform(get(url)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
	}

	@Test
	public void airportsQueryWithBlankCodeIgnoresInputAndReturnsAll() throws Exception {
		String url = new StringBuilder().append(AirportQueryController.AIRPIRTS_QUERY_BASE_URL).append("?")
				.append("code=").toString();

		mockmvc.perform(get(url)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
	}

	@Test
	public void airportsQueryReturnsPositiveResponseForCodeAndCountry() throws Exception {
		String url = new StringBuilder().append(AirportQueryController.AIRPIRTS_QUERY_BASE_URL).append("?")
				.append("code=GTN").append("?country=NZ").toString();

		mockmvc.perform(get(url)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
	}

}
