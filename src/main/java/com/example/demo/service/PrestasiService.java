package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Prestasi;
import com.example.demo.repository.PrestasiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrestasiService {

    private final PrestasiRepository prestasiRepository;

    @Autowired
    public PrestasiService(PrestasiRepository prestasiRepository) {
        this.prestasiRepository = prestasiRepository;
    }

    public Prestasi createPrestasi(Prestasi prestasi) {
        return prestasiRepository.save(prestasi);
    }

    public List<Prestasi> getAllPrestasi() {
        return prestasiRepository.findAll();
    }

    public Prestasi getPrestasiById(Long id) {
        Optional<Prestasi> prestasiOptional = prestasiRepository.findById(id);
        return prestasiOptional.orElse(null);
    }

    public Prestasi updatePrestasi(Prestasi prestasi) {
        return prestasiRepository.save(prestasi);
    }

    public void deletePrestasi(Long id) {
        prestasiRepository.deleteById(id);
    }
}