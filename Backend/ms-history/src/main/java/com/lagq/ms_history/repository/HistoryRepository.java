package com.lagq.ms_history.repository;

import com.lagq.ms_history.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>
{
    List<History> findByTicketId(Long ticketId);
}
