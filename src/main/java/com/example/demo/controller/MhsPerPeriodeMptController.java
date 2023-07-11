package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MhsPerPeriodeMpt;
import com.example.demo.service.MhsPerPeriodeMptService;

@RestController
@RequestMapping("/mhs_per_periode_mpt")
public class MhsPerPeriodeMptController {

    private MhsPerPeriodeMptService mhsPerPeriodeMptService;

    public MhsPerPeriodeMptController(MhsPerPeriodeMptService mhsPerPeriodeMptService) {
        this.mhsPerPeriodeMptService = mhsPerPeriodeMptService;
    }

    @PostMapping
    public MhsPerPeriodeMpt createMhsPerPeriodeMpt(@RequestBody MhsPerPeriodeMpt mhsPerPeriodeMpt) {
        return mhsPerPeriodeMptService.createMhsPerPeriodeMpt(mhsPerPeriodeMpt);
    }

    @PutMapping("/{id}")
    public MhsPerPeriodeMpt updateMhsPerPeriodeMpt(@PathVariable("id") Long id, @RequestBody MhsPerPeriodeMpt updatedMhsPerPeriodeMpt) {
        return mhsPerPeriodeMptService.updateMhsPerPeriodeMpt(id, updatedMhsPerPeriodeMpt);
    }

    @DeleteMapping("/{id}")
    public void deleteMhsPerPeriodeMpt(@PathVariable("id") Long id) {
        mhsPerPeriodeMptService.deleteMhsPerPeriodeMpt(id);
    }

    @GetMapping("/{id}")
    public MhsPerPeriodeMpt getMhsPerPeriodeMptById(@PathVariable("id") Long id) {
        return mhsPerPeriodeMptService.getMhsPerPeriodeMptById(id);
    }

    @GetMapping
    public List<MhsPerPeriodeMpt> getAllMhsPerPeriodeMpt() {
        return mhsPerPeriodeMptService.getAllMhsPerPeriodeMpt();
    }
}
