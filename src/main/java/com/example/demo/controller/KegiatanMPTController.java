package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<KegiatanMPT> updateKegiatanMPT(@PathVariable Long id, @RequestBody KegiatanMPT kegiatanMPT) {
        KegiatanMPT existingKegiatanMPT = kegiatanMPTService.getKegiatanMPTById(id);
        if (existingKegiatanMPT == null) {
            return ResponseEntity.notFound().build();
        }

        existingKegiatanMPT.setJenisKegiatanMPT(kegiatanMPT.getJenisKegiatanMPT());
        existingKegiatanMPT.setNamaKegiatanMPT(kegiatanMPT.getNamaKegiatanMPT());
        existingKegiatanMPT.setIdPeriodeMPT(kegiatanMPT.getIdPeriodeMPT());
        existingKegiatanMPT.setTanggalMulaiKegiatanMPT(kegiatanMPT.getTanggalMulaiKegiatanMPT());
        existingKegiatanMPT.setTanggalSelesaiKegiatanMPT(kegiatanMPT.getTanggalSelesaiKegiatanMPT());
        existingKegiatanMPT.setPointMPTDiperoleh(kegiatanMPT.getPointMPTDiperoleh());

        KegiatanMPT updatedKegiatanMPT = kegiatanMPTService.updateKegiatanMPT(id, existingKegiatanMPT);
        return ResponseEntity.ok(updatedKegiatanMPT);
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
