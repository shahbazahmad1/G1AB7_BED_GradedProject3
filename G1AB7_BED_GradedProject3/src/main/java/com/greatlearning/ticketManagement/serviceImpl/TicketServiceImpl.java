package com.greatlearning.ticketManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticketManagement.entity.Ticket;
import com.greatlearning.ticketManagement.repository.TicketRepository;
import com.greatlearning.ticketManagement.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		List<Ticket> theTicket = ticketRepository.findAll();
		return theTicket;
	}

	@Override
	public void save(Ticket theTicket) {

		ticketRepository.save(theTicket);
	}

	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);
	}

	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = ticketRepository.findById(theId);
		Ticket theTicket = null;
		if (result.isPresent()) {
			theTicket = result.get();
		} else {
			throw new RuntimeException("Did not find ticket id - " + theId);
		}
		return theTicket;
	}

	@Override
	public List<Ticket> findByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

}
