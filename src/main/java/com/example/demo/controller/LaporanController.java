package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Laporan;
import com.example.demo.service.LaporanService;

@RestController
@RequestMapping("/laporan")
public class LaporanController {
    private final LaporanService laporanService;

    @Autowired
    public LaporanController(LaporanService laporanService) {
        this.laporanService = laporanService;
    }

    @PostMapping
    public ResponseEntity<Laporan> createLaporan(@RequestBody Laporan laporan) {
        Laporan createdLaporan = laporanService.createLaporan(laporan);
        return new ResponseEntity<>(createdLaporan, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Laporan> getAllLaporan() {
        return laporanService.getAllLaporan();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Laporan> getLaporanById(@PathVariable("id") Long id) {
        Laporan laporan = laporanService.getLaporanById(id);
        if (laporan != null) {
            return new ResponseEntity<>(laporan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laporan> updateLaporan(@PathVariable("id") Long id, @RequestBody Laporan laporan) {
        Laporan updatedLaporan = laporanService.updateLaporan(id, laporan);
        if (updatedLaporan != null) {
            return new ResponseEntity<>(updatedLaporan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLaporan(@PathVariable("id") Long id) {
        boolean deleted = laporanService.deleteLaporan(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}