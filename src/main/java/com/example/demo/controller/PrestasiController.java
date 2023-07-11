package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Prestasi;
import com.example.demo.service.PrestasiService;

import java.util.List;

@RestController
@RequestMapping("/prestasi")
public class PrestasiController {

    private final PrestasiService prestasiService;

    @Autowired
    public PrestasiController(PrestasiService prestasiService) {
        this.prestasiService = prestasiService;
    }

    @PostMapping
    public ResponseEntity<Prestasi> createPrestasi(@RequestBody Prestasi prestasi) {
        Prestasi createdPrestasi = prestasiService.createPrestasi(prestasi);
        return new ResponseEntity<>(createdPrestasi, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Prestasi>> getAllPrestasi() {
        List<Prestasi> prestasiList = prestasiService.getAllPrestasi();
        return new ResponseEntity<>(prestasiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestasi> getPrestasiById(@PathVariable Long id) {
        Prestasi prestasi = prestasiService.getPrestasiById(id);
        if (prestasi != null) {
            return new ResponseEntity<>(prestasi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestasi> updatePrestasi(@PathVariable Long id, @RequestBody Prestasi prestasi) {
        Prestasi existingPrestasi = prestasiService.getPrestasiById(id);
        if (existingPrestasi != null) {
            prestasi.setId_prestasi(id);
            Prestasi updatedPrestasi = prestasiService.updatePrestasi(prestasi);
            return new ResponseEntity<>(updatedPrestasi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestasi(@PathVariable Long id) {
        Prestasi existingPrestasi = prestasiService.getPrestasiById(id);
        if (existingPrestasi != null) {
            prestasiService.deletePrestasi(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}