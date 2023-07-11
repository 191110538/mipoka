package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RevisiLaporan;
import com.example.demo.service.RevisiLaporanService;

@RestController
@RequestMapping("/revisi_laporan")
public class RevisiLaporanController {

    private final RevisiLaporanService revisiLaporanService;

    @Autowired
    public RevisiLaporanController(RevisiLaporanService revisiLaporanService) {
        this.revisiLaporanService = revisiLaporanService;
    }

    @PostMapping
    public RevisiLaporan createRevisiLaporan(@RequestBody RevisiLaporan revisiLaporan) {
        return revisiLaporanService.createRevisiLaporan(revisiLaporan);
    }

    @GetMapping
    public List<RevisiLaporan> getAllRevisiLaporan() {
        return revisiLaporanService.getAllRevisiLaporan();
    }

    @GetMapping("/{id}")
    public RevisiLaporan getRevisiLaporanById(@PathVariable Long id) {
        return revisiLaporanService.getRevisiLaporanById(id);
    }

    @PutMapping("/{id}")
    public RevisiLaporan updateRevisiLaporan(@PathVariable Long id, @RequestBody RevisiLaporan revisiLaporan) {
        return revisiLaporanService.updateRevisiLaporan(id, revisiLaporan);
    }

    @DeleteMapping("/{id}")
    public void deleteRevisiLaporan(@PathVariable Long id) {
        revisiLaporanService.deleteRevisiLaporan(id);
    }
}
