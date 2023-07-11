package com.example.demo.controller;

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

import com.example.demo.entity.RiwayatMPT;
import com.example.demo.service.RiwayatMPTService;

import java.util.List;

@RestController
@RequestMapping("/riwayat_mpt")
public class RiwayatMPTController {

    @Autowired
    private RiwayatMPTService riwayatMPTService;

    @GetMapping
    public ResponseEntity<List<RiwayatMPT>> getAllRiwayatMPT() {
        List<RiwayatMPT> riwayatMPTList = riwayatMPTService.getAllRiwayatMPT();
        return new ResponseEntity<>(riwayatMPTList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiwayatMPT> getRiwayatMPTById(@PathVariable Long id) {
        RiwayatMPT riwayatMPT = riwayatMPTService.getRiwayatMPTById(id);
        if (riwayatMPT != null) {
            return new ResponseEntity<>(riwayatMPT, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RiwayatMPT> createRiwayatMPT(@RequestBody RiwayatMPT riwayatMPT) {
        RiwayatMPT savedRiwayatMPT = riwayatMPTService.saveRiwayatMPT(riwayatMPT);
        return new ResponseEntity<>(savedRiwayatMPT, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiwayatMPT> updateRiwayatMPT(@PathVariable Long id,
            @RequestBody RiwayatMPT updatedRiwayatMPT) {
        RiwayatMPT riwayatMPT = riwayatMPTService.updateRiwayatMPT(id, updatedRiwayatMPT);
        if (riwayatMPT != null) {
            return new ResponseEntity<>(riwayatMPT, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRiwayatMPT(@PathVariable Long id) {
        riwayatMPTService.deleteRiwayatMPT(id);
        return new ResponseEntity<>("Riwayat MPT with ID: " + id + " has been deleted.", HttpStatus.OK);
    }
}
