package com.example.demo.controller;

import com.example.demo.entity.Ormawa;
import com.example.demo.service.OrmawaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/ormawa")
public class OrmawaController {

    private final OrmawaService ormawaService;

    @Autowired
    public OrmawaController(OrmawaService ormawaService) {
        this.ormawaService = ormawaService;
    }
    
    @PostMapping
    public ResponseEntity<Ormawa> createOrmawa(@RequestBody Ormawa ormawa) {
        Ormawa createdOrmawa = ormawaService.createOrmawa(ormawa);
        return ResponseEntity.ok(createdOrmawa);
    }

    // @PostMapping
    // public ResponseEntity<Ormawa> createOrmawa(@RequestBody Ormawa ormawa) {
    //     Ormawa createdOrmawa = ormawaService.saveOrmawa(ormawa);
    //     return new ResponseEntity<>(createdOrmawa, HttpStatus.CREATED);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<Ormawa> getOrmawaById(@PathVariable int id) {
    //     Ormawa ormawa = ormawaService.getOrmawaById(id);
    //     if (ormawa != null) {
    //         return ResponseEntity.ok(ormawa);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Ormawa> updateOrmawa(@PathVariable Integer id, @RequestBody Ormawa ormawa) {
        Ormawa updatedOrmawa = ormawaService.updateOrmawa(id, ormawa);
        return ResponseEntity.ok(updatedOrmawa);
    }

    @GetMapping
    public ResponseEntity<List<Ormawa>> getAllOrmawa() {
        List<Ormawa> ormawaList = ormawaService.getAllOrmawa();
        return ResponseEntity.ok(ormawaList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrmawa(@PathVariable int id) {
        ormawaService.deleteOrmawa(id);
        return ResponseEntity.noContent().build();
    }
     @GetMapping("/{id}")
    public ResponseEntity<Ormawa> getOrmawaById(@PathVariable int id) {
        Ormawa ormawa = ormawaService.getOrmawaById(id);
        return ResponseEntity.ok(ormawa);
    }
    
}

