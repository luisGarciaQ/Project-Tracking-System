package com.lagq.ms_ticket.Controller;

import com.lagq.ms_ticket.model.Ticket;
import com.lagq.ms_ticket.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController
{

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return ticketService.updateTicket(id, ticketDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

    @GetMapping("/assigned/{developerId}")
    public List<Ticket> getTicketsByAssignedDeveloper(@PathVariable Long developerId) {
        return ticketService.getTicketsByAssignedDeveloper(developerId);
    }

    @GetMapping("/project/{projectId}")
    public List<Ticket> getTicketsByProjectId(@PathVariable Long projectId) {
        return ticketService.getTicketsByProjectId(projectId);
    }
}
