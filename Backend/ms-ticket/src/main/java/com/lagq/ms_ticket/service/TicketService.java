package com.lagq.ms_ticket.service;

import com.lagq.ms_ticket.model.Ticket;
import com.lagq.ms_ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService
{
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setCreated(LocalDateTime.now());
        ticket.setUpdated(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicketById(id);
        ticket.setTitle(ticketDetails.getTitle());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setPriority(ticketDetails.getPriority());
        ticket.setStatus(ticketDetails.getStatus());
        ticket.setAssignedDeveloper(ticketDetails.getAssignedDeveloper());
        ticket.setProjectId(ticketDetails.getProjectId());
        ticket.setUpdated(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByAssignedDeveloper(Long developerId) {
        return ticketRepository.findByAssignedDeveloper(developerId);
    }

    public List<Ticket> getTicketsByProjectId(Long projectId) {
        return ticketRepository.findByProjectId(projectId);
    }
}
