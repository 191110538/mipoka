package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.JenisKegiatanMpt;
import com.example.demo.service.JenisKegiatanMptService;

@RestController
@RequestMapping("/jenis_kegiatan_mpt")
public class JenisKegiatanMptController {
    private final JenisKegiatanMptService jenisKegiatanMptService;

    @Autowired
    public JenisKegiatanMptController(JenisKegiatanMptService jenisKegiatanMptService) {
        this.jenisKegiatanMptService = jenisKegiatanMptService;
    }

    @PostMapping
    public JenisKegiatanMpt createJenisKegiatanMpt(@RequestBody JenisKegiatanMpt jenisKegiatanMpt) {
        return jenisKegiatanMptService.createJenisKegiatanMpt(jenisKegiatanMpt);
    }

    @GetMapping("/{id}")
    public JenisKegiatanMpt getJenisKegiatanMptById(@PathVariable Long id) {
        return jenisKegiatanMptService.getJenisKegiatanMptById(id);
    }

    @PutMapping("/{id}")
    public JenisKegiatanMpt updateJenisKegiatanMpt(@PathVariable Long id, @RequestBody JenisKegiatanMpt updatedJenisKegiatanMpt) {
        return jenisKegiatanMptService.updateJenisKegiatanMpt(id, updatedJenisKegiatanMpt);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJenisKegiatanMpt(@PathVariable Long id) {
        return jenisKegiatanMptService.deleteJenisKegiatanMpt(id);
    }
}
