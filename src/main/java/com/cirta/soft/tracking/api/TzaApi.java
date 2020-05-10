package com.cirta.soft.tracking.api;

import com.cirta.soft.tracking.entity.Application;
import com.cirta.soft.tracking.entity.Ticket;
import com.cirta.soft.tracking.exception.ApplicationNotFoundException;
import com.cirta.soft.tracking.service.ApplicationService;
import com.cirta.soft.tracking.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TzaApi {

    private final ApplicationService applicationService;
    private final TicketService ticketService;

    public TzaApi(ApplicationService applicationService, TicketService ticketService) {
        this.applicationService = applicationService;
        this.ticketService = ticketService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications(){
        final List<Application> applications = (List<Application>) applicationService.listApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        final List<Ticket> tickets = (List<Ticket>) ticketService.listTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id){
        try {
            final Application application = applicationService.findApplication(id);
            return new ResponseEntity<>(application, HttpStatus.OK);
        }catch (ApplicationNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not Found");
        }
    }
}
