package com.lagq.ms_ticket.repository;

import com.lagq.ms_ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long>
{
    List<Ticket> findByAssignedDeveloper(Long developerId);
    List<Ticket> findByProjectId(Long projectId);
}
