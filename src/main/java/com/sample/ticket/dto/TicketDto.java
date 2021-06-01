package com.sample.ticket.dto;

import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sample.ticket.utils.Constants;

/**
 * Ticket
 * 
 * @author Israel I.R.E
 *
 */
@JsonInclude(Include.NON_NULL)
@Valid
public class TicketDto {

	private String itineraryID;

	@NotNull(message = "La fecha de salida es obligatoria")
	@NotBlank(message = "La fecha de salida no debe ir vacia")
	@Pattern(regexp = Constants.REGEX_DATE, message = "La fecha de salida debe de tener el formato dd/mm/yyyy")
	private String departureDate;

	@NotNull(message = "La fecha de llegada es obligatoria")
	@NotBlank(message = "La fecha de llegada no debe ir vacia")
	@Pattern(regexp = Constants.REGEX_DATE, message = "La fecha de llegada debe de tener el formato dd/mm/yyyy")
	private String arrivalDate;

	@NotNull(message = "El origen es obligatorio")
	@NotBlank(message = "El origen no debe ir vacio")
	private String origin;

	@NotNull(message = "El destino es obligatorio")
	@NotBlank(message = "El destino no debe ir vacio")
	private String destination;

	@NotNull(message = "El nombre del pasaje es obligatorio")
	@NotBlank(message = "El nombre del pasajero no debe ir vacio")
	private String passenger;

	@NotNull(message = "La edad del pasaje es obligatoria")
	private Integer passengerAge;

	@NotNull(message = "El precio del boleto es obligatorio")
	private BigDecimal price;

	@NotNull(message = "La hora de salida es obligatoria")
	@NotBlank(message = "La hora de salida  no debe ir vacia")
	@Pattern(regexp = Constants.REGEX_TIME, message = "La hora de salida debe de tener el formato HH:mm:ss")
	private String departureTime;

	@NotNull(message = "La hora de llegada es obligatoria")
	@NotBlank(message = "La hora de llegada  no debe ir vacia")
	@Pattern(regexp = Constants.REGEX_TIME, message = "La hora de llegada debe de tener el formato HH:mm:ss")
	private String arrivalTime;

	@NotNull(message = "La bodeba de equipaje es obligatoria")
	private Boolean luggageHold;

	public String getItineraryID() {
		return itineraryID;
	}

	public void setItineraryID(String itineraryID) {
		this.itineraryID = itineraryID;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
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

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Boolean isLuggageHold() {
		return luggageHold;
	}

	public void setLuggageHold(Boolean luggageHold) {
		this.luggageHold = luggageHold;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TicketDto [");
		if (itineraryID != null) {
			builder.append("itineraryID=");
			builder.append(itineraryID);
			builder.append(", ");
		}
		if (departureDate != null) {
			builder.append("departureDate=");
			builder.append(departureDate);
			builder.append(", ");
		}
		if (arrivalDate != null) {
			builder.append("arrivalDate=");
			builder.append(arrivalDate);
			builder.append(", ");
		}
		if (origin != null) {
			builder.append("origin=");
			builder.append(origin);
			builder.append(", ");
		}
		if (destination != null) {
			builder.append("destination=");
			builder.append(destination);
			builder.append(", ");
		}
		if (passenger != null) {
			builder.append("passenger=");
			builder.append(passenger);
			builder.append(", ");
		}
		if (passengerAge != null) {
			builder.append("passengerAge=");
			builder.append(passengerAge);
			builder.append(", ");
		}
		if (price != null) {
			builder.append("price=");
			builder.append(price);
			builder.append(", ");
		}
		if (departureTime != null) {
			builder.append("departureTime=");
			builder.append(departureTime);
			builder.append(", ");
		}
		if (arrivalTime != null) {
			builder.append("arrivalTime=");
			builder.append(arrivalTime);
			builder.append(", ");
		}
		if (luggageHold != null) {
			builder.append("luggageHold=");
			builder.append(luggageHold);
		}
		builder.append("]");
		return builder.toString();
	}

}
