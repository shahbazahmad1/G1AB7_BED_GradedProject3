package com.greatlearning.ticketManagement.service;

import java.util.List;
import com.greatlearning.ticketManagement.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public Ticket findById(int theId);

	public void save(Ticket theTicket);

	public void deleteById(int theId);

	public List<Ticket> findByKeyword(String keyword);

}
