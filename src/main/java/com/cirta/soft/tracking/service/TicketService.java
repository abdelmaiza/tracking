package com.cirta.soft.tracking.service;

import com.cirta.soft.tracking.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}


