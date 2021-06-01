package com.sample.ticket.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Israel I.R:E
 *
 */
@Entity(name = "TICKETS")
public class Ticket {

	@Id
	private String id;

	@Column(name = "departure_date")
	private LocalDateTime departureDate;

	@Column(name = "arrival_date")
	private LocalDateTime arrivalDate;

	@Column(name = "origin")
	private String origin;

	@Column(name = "destination")
	private String destination;

	@Column(name = "passenger")

	private String passenger;

	@Column(name = "passenger_age")
	private int passengerAge;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "luggage_hold")
	private boolean luggageHold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isLuggageHold() {
		return luggageHold;
	}

	public void setLuggageHold(boolean luggageHold) {
		this.luggageHold = luggageHold;
	}

}
