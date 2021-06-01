package com.sample.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.ticket.entity.Ticket;

@Repository
public interface TicketsRepository  extends JpaRepository<Ticket, String>{

}
