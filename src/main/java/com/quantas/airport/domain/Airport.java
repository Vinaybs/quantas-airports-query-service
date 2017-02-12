package com.quantas.airport.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "code", "display_name", "international_airport", "regional_airport", "location", "currency_code",
		"timezone", "country" })
public class Airport {

	@JsonProperty("code")
	private String code;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("international_airport")
	private boolean internationalAirport;
	@JsonProperty("regional_airport")
	private boolean regionalAirport;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("currency_code")
	private String currencyCode;
	@JsonProperty("timezone")
	private String timezone;
	@JsonProperty("country")
	private Country country;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplay_name() {
		return displayName;
	}

	public void setDisplay_name(String display_name) {
		this.displayName = display_name;
	}

	public Boolean getInternational_airport() {
		return internationalAirport;
	}

	public void setInternational_airport(Boolean international_airport) {
		this.internationalAirport = international_airport;
	}

	public Boolean getRegional_airport() {
		return regionalAirport;
	}

	public void setRegional_airport(Boolean regional_airport) {
		this.regionalAirport = regional_airport;
	}

	public String getCurrency_code() {
		return currencyCode;
	}

	public void setCurrency_code(String currency_code) {
		this.currencyCode = currency_code;
	}

	public String getTimeZone() {
		return timezone;
	}

	public void setTimeZone(String timeZone) {
		this.timezone = timeZone;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airport_ [code=" + code + ", displayName=" + displayName + ", internationalAirport="
				+ internationalAirport + ", regionalAirport=" + regionalAirport + ", location=" + location
				+ ", currencyCode=" + currencyCode + ", timezone=" + timezone + ", country=" + country + "]";
	}

}
