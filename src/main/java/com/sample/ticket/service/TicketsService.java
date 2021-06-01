package com.sample.ticket.service;

import com.sample.ticket.dto.TicketDto;

/**
 * 
 * @author Israel I. R. E.
 * 
 */
public interface TicketsService {

	public TicketDto find(String id);

	public TicketDto save(TicketDto ticket);

}
