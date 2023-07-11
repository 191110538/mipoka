package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.KegiatanPerPeriodeMpt;
import com.example.demo.service.KegiatanPerPeriodeMptService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kegiatan_per_periode_mpt")

public class KegiatanPerPeriodeMptController {

    private final KegiatanPerPeriodeMptService kegiatanPerPeriodeMptService;

    @Autowired
    public KegiatanPerPeriodeMptController(KegiatanPerPeriodeMptService kegiatanPerPeriodeMptService) {
        this.kegiatanPerPeriodeMptService = kegiatanPerPeriodeMptService;
    }

    @GetMapping("/{id}")
    public KegiatanPerPeriodeMpt getKegiatanPerPeriodeMptById(@PathVariable("id") Long id) {
        return kegiatanPerPeriodeMptService.getKegiatanPerPeriodeMptById(id);
    }

    @GetMapping
    public List<KegiatanPerPeriodeMpt> getAllKegiatanPerPeriodeMpt() {
        return kegiatanPerPeriodeMptService.getAllKegiatanPerPeriodeMpt();
    }

    @PostMapping
    public KegiatanPerPeriodeMpt createKegiatanPerPeriodeMpt(@RequestBody KegiatanPerPeriodeMpt kegiatanPerPeriodeMpt) {
        return kegiatanPerPeriodeMptService.createKegiatanPerPeriodeMpt(kegiatanPerPeriodeMpt);
    }

    @PutMapping("/{id}")
    public KegiatanPerPeriodeMpt updateKegiatanPerPeriodeMpt(@PathVariable("id") Long id,
            @RequestBody KegiatanPerPeriodeMpt updatedKegiatanPerPeriodeMpt) {
        return kegiatanPerPeriodeMptService.updateKegiatanPerPeriodeMpt(id, updatedKegiatanPerPeriodeMpt);
    }

    @DeleteMapping("/{id}")
    public boolean deleteKegiatanPerPeriodeMpt(@PathVariable("id") Long id) {
        return kegiatanPerPeriodeMptService.deleteKegiatanPerPeriodeMpt(id);
    }

    // @GetMapping("/filter-id-periode-id-nama-kegiatan/{idPeriode}/{idNamaKegiatan}")
    // public List<KegiatanPerPeriodeMpt> getKegiatanPerPeriodeMptByIdPeriodeAndIdNamaKegiatan(
    //         @PathVariable("idPeriode") Long idPeriode, @PathVariable("idNamaKegiatan") Long idNamaKegiatan) {
    //     return kegiatanPerPeriodeMptService.filterKegiatanPerPeriodeMptByIdPeriodeAndIdNamaKegiatan(idPeriode,
    //             idNamaKegiatan);
    // }
    

}
