package com.example.demo.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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

import com.example.demo.entity.Usulan;
import com.example.demo.service.UsulanService;

import org.springframework.web.bind.annotation.ResponseStatus;
@RestController
@RequestMapping("/usulan")
public class UsulanController {

    private final UsulanService usulanService;

    @Autowired
    public UsulanController(UsulanService usulanService) {
        this.usulanService = usulanService;
    }

    @PostMapping
    public Usulan createUsulan(@RequestBody Usulan usulan) {
        return usulanService.createUsulan(usulan);
    }

    @GetMapping
    public List<Usulan> getAllUsulan() {
        return usulanService.getAllUsulan();
    }

    @GetMapping("/{id}")
    public Usulan getUsulanById(@PathVariable Long id) {
        return usulanService.getUsulanById(id);
    }

    @DeleteMapping("/{id}") // Menggunakan HTTP DELETE untuk operasi delete
    public void deleteUsulan(@PathVariable Long id) {
        usulanService.deleteUsulan(id);
    }

    @PutMapping("/{id}")
    public Usulan updateUsulan(@PathVariable Long id, @RequestBody Usulan usulanData) {
        Usulan usulan = usulanService.getUsulanById(id);
        if (usulan != null) {
            // Update the fields of the existing Usulan object
            usulan.setUser(usulanData.getUser());
            usulan.setOrmawa(usulanData.getOrmawa());
            usulan.setRevisi_usulan(usulanData.getRevisi_usulan());
            usulan.setPembiayaan(usulanData.getPembiayaan());
            usulan.setNama_kegiatan(usulanData.getNama_kegiatan());
            usulan.setBentuk_kegiatan(usulanData.getBentuk_kegiatan());
            usulan.setKategori_bentuk_kegiatan(usulanData.getKategori_bentuk_kegiatan());
            usulan.setDeskripsi_kegiatan(usulanData.getDeskripsi_kegiatan());
            usulan.setTanggal_mulai_kegiatan(usulanData.getTanggal_mulai_kegiatan());
            usulan.setTanggal_selesai_kegiatan(usulanData.getTanggal_selesai_kegiatan());
            usulan.setWaktu_mulai_kegiatan(usulanData.getWaktu_mulai_kegiatan());
            usulan.setWaktu_selesai_kegiatan(usulanData.getWaktu_selesai_kegiatan());
            usulan.setTempat_kegiatan(usulanData.getTempat_kegiatan());
            usulan.setTanggal_keberangkatan(usulanData.getTanggal_keberangkatan());
            usulan.setTanggal_kepulangan(usulanData.getTanggal_kepulangan());
            usulan.setJumlah_partisipan(usulanData.getJumlah_partisipan());
            usulan.setKategori_jumlah_partisipan(usulanData.getKategori_jumlah_partisipan());
            usulan.setTarget_kegiatan(usulanData.getTarget_kegiatan());
            usulan.setTotal_pendanaan(usulanData.getTotal_pendanaan());
            usulan.setKategori_total_pendanaan(usulanData.getKategori_total_pendanaan());
            usulan.setKeterangan(usulanData.getKeterangan());
            usulan.setTanda_tangan_ormawa(usulanData.getTanda_tangan_ormawa());
            usulan.setPartisipan(usulanData.getPartisipan());
            usulan.setBiaya_kegiatan(usulanData.getBiaya_kegiatan());
            usulan.setLatar_belakang(usulanData.getLatar_belakang());
            usulan.setTujuan_kegiatan(usulanData.getTujuan_kegiatan());
            usulan.setManfaat_kegiatan(usulanData.getManfaat_kegiatan());
            usulan.setBentuk_pelaksanaan_kegiatan(usulanData.getBentuk_pelaksanaan_kegiatan());
            usulan.setTarget_pencapaian_kegiatan(usulanData.getTarget_pencapaian_kegiatan());
            usulan.setWaktu_dan_tempat_pelaksanaan(usulanData.getWaktu_dan_tempat_pelaksanaan());
            usulan.setRencana_anggaran_kegiatan(usulanData.getRencana_anggaran_kegiatan());
            usulan.setTotal_biaya(usulanData.getTotal_biaya());
            usulan.setTertib_acara(usulanData.getTertib_acara());
            usulan.setPerlengkapan_dan_peralatan(usulanData.getPerlengkapan_dan_peralatan());
            usulan.setPenutup(usulanData.getPenutup());
            usulan.setFoto_postingan_kegiatan(usulanData.getFoto_postingan_kegiatan());
            usulan.setFoto_surat_undangan_kegiatan(usulanData.getFoto_surat_undangan_kegiatan());
            usulan.setFoto_linimasa_kegiatan(usulanData.getFoto_linimasa_kegiatan());
            usulan.setFoto_tempat_kegiatan(usulanData.getFoto_tempat_kegiatan());
            usulan.setFile_usulan_kegiatan(usulanData.getFile_usulan_kegiatan());
            usulan.setValidasi_pembina(usulanData.getValidasi_pembina());
            usulan.setTanda_tangan_pembina(usulanData.getTanda_tangan_pembina());
            usulan.setStatus_usulan(usulanData.getStatus_usulan());
            usulan.setRoles(usulanData.getRoles());
            usulan.setCreated_at(usulanData.getCreated_at());
            usulan.setUpdated_at(usulanData.getUpdated_at());
            usulan.setCreated_by(usulanData.getCreated_by());
            usulan.setUpdated_by(usulanData.getUpdated_by());
            
            // Save the updated Usulan object
            return usulanService.updateUsulan(usulan);
        } else {
            return null;
        }
    }

    

}
