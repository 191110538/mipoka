package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Notifikasi;
import com.example.demo.repository.NotifikasiRepository;
import com.example.demo.service.NotifikasiService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/notifikasi")
public class NotifikasiController {
    private final NotifikasiService notifikasiService;

    @Autowired
    public NotifikasiController(NotifikasiService notifikasiService) {
        this.notifikasiService = notifikasiService;
    }
    // public NotifikasiController(NotifikasiRepository notifikasiRepository) {
    //     this.notifikasiRepository = notifikasiRepository;
    // }

    @PostMapping
    public Notifikasi createNotifikasi(@RequestBody Notifikasi notifikasi) {
        return notifikasiService.createNotifikasi(notifikasi);
    }

    @GetMapping("/{id}")
    public Notifikasi getNotifikasiById(@PathVariable Long id) {
        return notifikasiService.getNotifikasiById(id);
    }

    @GetMapping("/all")
    public List<Notifikasi> getAllNotifikasi() {
        return notifikasiService.getAllNotifikasi();
    }

    @PutMapping("/{id}")
    public Notifikasi updateNotifikasi(@PathVariable Long id, @RequestBody Notifikasi updatedNotifikasi) {
        return notifikasiService.updateNotifikasi(id, updatedNotifikasi);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNotifikasi(@PathVariable Long id) {
        return notifikasiService.deleteNotifikasi(id);
    }
    @GetMapping
    public List<Notifikasi> getAllNotifikasiOrderByCreatedAtDesc() {
        return notifikasiService.getAllNotifikasiOrderByCreatedAtDesc();
    }
}