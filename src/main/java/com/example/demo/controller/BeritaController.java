package com.example.demo.controller;

import java.io.IOException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.entity.Berita;
import com.example.demo.service.BeritaService;

@RestController
@RequestMapping("/berita")
public class BeritaController {
    private final BeritaService beritaService;

    public BeritaController(BeritaService beritaService) {
        this.beritaService = beritaService;
    }

    @PostMapping
    public Berita createBerita(@RequestBody Berita berita) {
        return beritaService.createBerita(berita);
    }

    @PutMapping("/{id}")
    public Berita updateBerita(@PathVariable Long id, @RequestBody Berita updatedBerita) {
        return beritaService.updateBerita(id, updatedBerita);
    }

    @GetMapping
    public List<Berita> getAllBerita() {
        return beritaService.getAllBerita();
    }

    @GetMapping("/{id}")
    public Berita getBeritaById(@PathVariable Long id) {
        return beritaService.getBeritaById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBerita(@PathVariable Long id) {
        beritaService.deleteBerita(id);
    }
}

    

