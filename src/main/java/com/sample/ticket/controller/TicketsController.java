package com.sample.ticket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ticket.dto.TicketDto;
import com.sample.ticket.service.TicketsService;

/**
 * 
 * @author Israel I. R. E.
 *
 */
@RequestMapping("/tickets")
@RestController
public class TicketsController {

	@Autowired
	private TicketsService ticketService;

	@GetMapping
	public ResponseEntity<Object> get(@RequestParam(name = "itineraryID", required = true) String itineraryID) {

		return new ResponseEntity<>(ticketService.find(itineraryID), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid TicketDto ticketDto) {

		return new ResponseEntity<>(ticketService.save(ticketDto), HttpStatus.OK);
	}

}
