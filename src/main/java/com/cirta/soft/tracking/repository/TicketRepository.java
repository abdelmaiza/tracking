package com.cirta.soft.tracking.repository;

import com.cirta.soft.tracking.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
