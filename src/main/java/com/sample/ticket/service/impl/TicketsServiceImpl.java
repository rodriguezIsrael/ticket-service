package com.sample.ticket.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.ticket.dto.TicketDto;
import com.sample.ticket.entity.Ticket;
import com.sample.ticket.repository.TicketsRepository;
import com.sample.ticket.service.TicketsService;
import com.sample.ticket.utils.Constants;

import org.slf4j.Logger;

/**
 * 
 * @author Israel I.R:E
 *
 */
@Service
public class TicketsServiceImpl implements TicketsService {

	private static final Logger LOG = LoggerFactory.getLogger(TicketsServiceImpl.class);

	@Autowired
	private TicketsRepository ticketsRepository;

	@Override
	public TicketDto find(String id) {

		Ticket ticket = ticketsRepository.findById(id).orElse(null);

		if (ticket == null) {
			return new TicketDto();
		}
		TicketDto ticketDto = new TicketDto();
		ticketDto.setArrivalDate(ticket.getArrivalDate().toLocalDate().toString());
		ticketDto.setArrivalTime(ticket.getArrivalDate().toLocalTime().toString());
		ticketDto.setDepartureDate(ticket.getDepartureDate().toLocalDate().toString());
		ticketDto.setDepartureTime(ticket.getDepartureDate().toLocalTime().toString());
		ticketDto.setDestination(ticket.getDestination());
		ticketDto.setLuggageHold(ticket.isLuggageHold());
		ticketDto.setOrigin(ticket.getOrigin());
		ticketDto.setPassenger(ticket.getPassenger());
		ticketDto.setPassengerAge(ticket.getPassengerAge());
		ticketDto.setPrice(ticket.getPrice());
		ticketDto.setItineraryID(ticket.getId());

		return ticketDto;
	}

	@Override
	public TicketDto save(TicketDto ticketDto) {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
		LOG.info("-- Guardado registro: {}", ticketDto);
		Ticket ticket = new Ticket();
		LocalDateTime arrivalDate = LocalDateTime.of(LocalDate.parse(ticketDto.getArrivalDate(),formatter),
				LocalTime.parse(ticketDto.getArrivalTime()));
		ticket.setArrivalDate(arrivalDate);
		LocalDateTime departureDate = LocalDateTime.of(LocalDate.parse(ticketDto.getDepartureDate(),formatter),
				LocalTime.parse(ticketDto.getDepartureTime()));
		ticket.setDepartureDate(departureDate);
		ticket.setDestination(ticketDto.getDestination());
		ticket.setLuggageHold(ticketDto.isLuggageHold());
		ticket.setOrigin(ticketDto.getOrigin());
		ticket.setPassenger(ticketDto.getPassenger());
		ticket.setPassengerAge(ticketDto.getPassengerAge());
		ticket.setPrice(ticketDto.getPrice());
		ticketDto.setItineraryID(UUID.randomUUID().toString());
		ticket.setId(ticketDto.getItineraryID());

		ticketsRepository.save(ticket);
		LOG.info("-- Registro guardado con Id: {}", ticketDto.getItineraryID());

		return ticketDto;
	}

}
