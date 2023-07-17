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

import com.example.demo.entity.KegiatanMPT;
import com.example.demo.service.KegiatanMPTService;

@RestController
@RequestMapping("/kegiatan_mpt")
public class KegiatanMPTController {

    private final KegiatanMPTService kegiatanMPTService;

    @Autowired
    public KegiatanMPTController(KegiatanMPTService kegiatanMPTService) {
        this.kegiatanMPTService = kegiatanMPTService;
    }

    @PostMapping
    public ResponseEntity<KegiatanMPT> createKegiatanMPT(@RequestBody KegiatanMPT kegiatanMPT) {
        KegiatanMPT savedKegiatanMPT = kegiatanMPTService.saveKegiatanMPT(kegiatanMPT);
        return ResponseEntity.ok(savedKegiatanMPT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KegiatanMPT> getKegiatanMPTById(@PathVariable Long id) {
        KegiatanMPT kegiatanMPT = kegiatanMPTService.getKegiatanMPTById(id);
        if (kegiatanMPT == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(kegiatanMPT);
    }

    @GetMapping
    public ResponseEntity<List<KegiatanMPT>> getAllKegiatanMPT() {
        List<KegiatanMPT> kegiatanMPTList = kegiatanMPTService.getAllKegiatanMPT();
        if (kegiatanMPTList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(kegiatanMPTList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KegiatanMPT> updateKegiatanMPT(@PathVariable Long id,
            @RequestBody KegiatanMPT updatedKegiatanMPT) {
        KegiatanMPT existingKegiatanMPT = kegiatanMPTService.getKegiatanMPTById(id);
        if (existingKegiatanMPT == null) {
            return ResponseEntity.notFound().build();
        }

        existingKegiatanMPT.setJenis_kegiatan_mpt(updatedKegiatanMPT.getJenis_kegiatan_mpt());
        existingKegiatanMPT.setNama_kegiatan_mpt(updatedKegiatanMPT.getNama_kegiatan_mpt());
        existingKegiatanMPT.setPeriode_mpt(updatedKegiatanMPT.getPeriode_mpt());
        existingKegiatanMPT.setTanggal_mulai_kegiatan_mpt(updatedKegiatanMPT.getTanggal_mulai_kegiatan_mpt());
        existingKegiatanMPT.setTanggal_selesai_kegiatan_mpt(updatedKegiatanMPT.getTanggal_selesai_kegiatan_mpt());
        existingKegiatanMPT.setPoint_mpt_diperoleh(updatedKegiatanMPT.getPoint_mpt_diperoleh());

        KegiatanMPT updatedKegiatanMPTResult = kegiatanMPTService.updateKegiatanMPT(id, existingKegiatanMPT);
        if (updatedKegiatanMPTResult == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(updatedKegiatanMPTResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKegiatanMPT(@PathVariable Long id) {
        KegiatanMPT kegiatanMPT = kegiatanMPTService.getKegiatanMPTById(id);
        if (kegiatanMPT == null) {
            return ResponseEntity.notFound().build();
        }
        kegiatanMPTService.deleteKegiatanMPT(id);
        return ResponseEntity.noContent().build();
    }
}
