package com.cirta.soft.tracking.service;

import com.cirta.soft.tracking.entity.Ticket;
import com.cirta.soft.tracking.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Iterable<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

}
