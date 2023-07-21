package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JenisKegiatanMpt;
import com.example.demo.repository.JenisKegiatanMptRepository;

@Service
public class JenisKegiatanMptService {
    private final JenisKegiatanMptRepository jenisKegiatanMptRepository;

    @Autowired
    public JenisKegiatanMptService(JenisKegiatanMptRepository jenisKegiatanMptRepository) {
        this.jenisKegiatanMptRepository = jenisKegiatanMptRepository;
    }

    public JenisKegiatanMpt createJenisKegiatanMpt(JenisKegiatanMpt jenisKegiatanMpt) {
        return jenisKegiatanMptRepository.save(jenisKegiatanMpt);
    }
    public List<JenisKegiatanMpt> getAllJenisKegiatanMpt() {
        return jenisKegiatanMptRepository.findAll();
    }


    public JenisKegiatanMpt getJenisKegiatanMptById(Long id) {
        return jenisKegiatanMptRepository.findById(id).orElse(null);
    }

    public JenisKegiatanMpt updateJenisKegiatanMpt(Long id, JenisKegiatanMpt updatedJenisKegiatanMpt) {
        JenisKegiatanMpt jenisKegiatanMpt = jenisKegiatanMptRepository.findById(id).orElse(null);
        if (jenisKegiatanMpt != null) {
            jenisKegiatanMpt.setNama_jenis_kegiatan_mpt(updatedJenisKegiatanMpt.getNama_jenis_kegiatan_mpt());
            jenisKegiatanMpt.setCreated_at(updatedJenisKegiatanMpt.getCreated_at());
            jenisKegiatanMpt.setCreated_by(updatedJenisKegiatanMpt.getCreated_by());
            jenisKegiatanMpt.setUpdated_at(updatedJenisKegiatanMpt.getUpdated_at());
            jenisKegiatanMpt.setUpdated_by(updatedJenisKegiatanMpt.getUpdated_by());
            // Set other updated fields
            return jenisKegiatanMptRepository.save(jenisKegiatanMpt);
        } else {
            return null;
        }
    }

    public boolean deleteJenisKegiatanMpt(Long id) {
        JenisKegiatanMpt jenisKegiatanMpt = jenisKegiatanMptRepository.findById(id).orElse(null);
        if (jenisKegiatanMpt != null) {
            jenisKegiatanMptRepository.delete(jenisKegiatanMpt);
            return true;
        } else {
            return false;
        }
    }
}
