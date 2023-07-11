package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PeriodeMpt;
import com.example.demo.service.PeriodeMptService;

@RestController
@RequestMapping("/periode_mpt")
public class PeriodeMptController {
    private final PeriodeMptService periodeMptService;

    public PeriodeMptController(PeriodeMptService periodeMptService) {
        this.periodeMptService = periodeMptService;
    }

    @PostMapping
    public ResponseEntity<PeriodeMpt> createPeriodeMpt(@RequestBody PeriodeMpt periodeMpt) {
        PeriodeMpt createdPeriodeMpt = periodeMptService.createPeriodeMpt(periodeMpt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPeriodeMpt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodeMpt> updatePeriodeMpt(@PathVariable Long id, @RequestBody PeriodeMpt updatedPeriodeMpt) {
        PeriodeMpt updated = periodeMptService.updatePeriodeMpt(id, updatedPeriodeMpt);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeriodeMpt(@PathVariable Long id) {
        periodeMptService.deletePeriodeMpt(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodeMpt> getPeriodeMptById(@PathVariable Long id) {
        PeriodeMpt periodeMpt = periodeMptService.getPeriodeMptById(id);
        return ResponseEntity.ok(periodeMpt);
    }

    @GetMapping
    public ResponseEntity<List<PeriodeMpt>> getAllPeriodeMpt() {
        List<PeriodeMpt> periodeMpts = periodeMptService.getAllPeriodeMpt();
        return ResponseEntity.ok(periodeMpts);
    }
}