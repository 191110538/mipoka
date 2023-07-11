package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RevisiUsulan;
import com.example.demo.service.RevisiUsulanService;

@RestController
@RequestMapping("revisi_usulan")
public class RevisiUsulanController {

    private final RevisiUsulanService revisiUsulanService;

    @Autowired
    public RevisiUsulanController(RevisiUsulanService revisiUsulanService) {
        this.revisiUsulanService = revisiUsulanService;
    }

    @PostMapping
    public ResponseEntity<RevisiUsulan> createRevisiUsulan(@RequestBody RevisiUsulan revisiUsulan) {
        RevisiUsulan createdRevisiUsulan = revisiUsulanService.createRevisiUsulan(revisiUsulan);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRevisiUsulan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevisiUsulan> getRevisiUsulanById(@PathVariable Long id) {
        RevisiUsulan revisiUsulan = revisiUsulanService.getRevisiUsulanById(id);
        if (revisiUsulan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(revisiUsulan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevisiUsulan> updateRevisiUsulan(@PathVariable Long id, @RequestBody RevisiUsulan revisiUsulan) {
        RevisiUsulan updatedRevisiUsulan = revisiUsulanService.updateRevisiUsulan(id, revisiUsulan);
        if (updatedRevisiUsulan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRevisiUsulan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevisiUsulan(@PathVariable Long id) {
        boolean deleted = revisiUsulanService.deleteRevisiUsulan(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
