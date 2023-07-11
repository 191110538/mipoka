package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Berita;
import com.example.demo.repository.BeritaRepository;

@Service
public class BeritaService {
    private final BeritaRepository beritaRepository;

    public BeritaService(BeritaRepository beritaRepository) {
        this.beritaRepository = beritaRepository;
    }

    public Berita createBerita(Berita berita) {
        return beritaRepository.save(berita);
    }

    public Berita updateBerita(Long id, Berita updatedBerita) {
        Berita berita = beritaRepository.findById(id).orElse(null);
        if (berita != null) {
            berita.setJudul(updatedBerita.getJudul());
            berita.setPenulis(updatedBerita.getPenulis());
            berita.setGambar(updatedBerita.getGambar());
            berita.setTeks(updatedBerita.getTeks());
            berita.setTgl_terbit(updatedBerita.getTgl_terbit());
            berita.setCreated_at(updatedBerita.getCreated_at());
            berita.setCreated_by(updatedBerita.getCreated_by());
            berita.setUpdated_at(updatedBerita.getUpdated_at());
            berita.setUpdated_by(updatedBerita.getUpdated_by());
            return beritaRepository.save(berita);
        } else {
            return null;
        }
    }

    public List<Berita> getAllBerita() {
        return beritaRepository.findAll();
    }

    public Berita getBeritaById(Long id) {
        return beritaRepository.findById(id).orElse(null);
    }

    public void deleteBerita(Long id) {
        beritaRepository.deleteById(id);
    }
}
