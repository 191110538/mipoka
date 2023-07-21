package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.NamaKegiatanMpt;
import com.example.demo.service.NamaKegiatanMptService;

@RestController
@RequestMapping("/nama_kegiatan_mpt")
public class NamaKegiatanMptController {

    private final NamaKegiatanMptService namaKegiatanMptService;

    @Autowired
    public NamaKegiatanMptController(NamaKegiatanMptService namaKegiatanMptService) {
        this.namaKegiatanMptService = namaKegiatanMptService;
    }
    @GetMapping
    public ResponseEntity<List<NamaKegiatanMpt>> getAllNamaKegiatanMpt() {
        List<NamaKegiatanMpt> allNamaKegiatanMpt = namaKegiatanMptService.getAllNamaKegiatanMpt();
        if (!allNamaKegiatanMpt.isEmpty()) {
            return ResponseEntity.ok(allNamaKegiatanMpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NamaKegiatanMpt> getNamaKegiatanMpt(@PathVariable Long id) {
        NamaKegiatanMpt namaKegiatanMpt = namaKegiatanMptService.getNamaKegiatanMpt(id);
        if (namaKegiatanMpt != null) {
            return ResponseEntity.ok(namaKegiatanMpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<NamaKegiatanMpt> createNamaKegiatanMpt(@RequestBody NamaKegiatanMpt namaKegiatanMpt) {
        NamaKegiatanMpt createdNamaKegiatanMpt = namaKegiatanMptService.createNamaKegiatanMpt(namaKegiatanMpt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNamaKegiatanMpt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NamaKegiatanMpt> updateNamaKegiatanMpt(
            @PathVariable Long id, @RequestBody NamaKegiatanMpt updatedNamaKegiatanMpt) {
        NamaKegiatanMpt namaKegiatanMpt = namaKegiatanMptService.updateNamaKegiatanMpt(id, updatedNamaKegiatanMpt);
        if (namaKegiatanMpt != null) {
            return ResponseEntity.ok(namaKegiatanMpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNamaKegiatanMpt(@PathVariable Long id) {
        namaKegiatanMptService.deleteNamaKegiatanMpt(id);
        return ResponseEntity.noContent().build();
    }
}
