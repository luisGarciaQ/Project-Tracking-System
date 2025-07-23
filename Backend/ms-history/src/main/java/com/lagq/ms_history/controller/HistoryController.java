package com.lagq.ms_history.controller;

import com.lagq.ms_history.model.History;
import com.lagq.ms_history.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public History createHistory(@RequestBody History history) {
        return historyService.saveHistory(history);
    }

    @GetMapping
    public List<History> getAllHistories() {
        System.out.println("GET /api/histories called");
        return historyService.getAllHistories();
    }

    @GetMapping("/{id}")
    public History getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<History> getHistoriesByTicketId(@PathVariable Long ticketId) {
        return historyService.getHistoriesByTicketId(ticketId);
    }

    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }
}
