package com.lagq.ms_history.service;

import com.lagq.ms_history.model.History;
import com.lagq.ms_history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryService
{
    private final HistoryRepository historyRepository;


    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    // Create or update a history record
    public History saveHistory(History history) {
        if (history.getChangedAt() == null) {
            history.setChangedAt(LocalDateTime.now());
        }
        return historyRepository.save(history);
    }

    // Get all history records
    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }

    // Get a single history record by ID
    public History getHistoryById(Long id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History record not found with ID: " + id));
    }

    // Get all history entries for a specific ticket
    public List<History> getHistoriesByTicketId(Long ticketId) {
        return historyRepository.findByTicketId(ticketId);
    }

    // Delete a history record
    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }
}
