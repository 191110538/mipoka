package com.example.demo.service;

import com.example.demo.entity.Ormawa;
import com.example.demo.repository.OrmawaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class OrmawaService {

    private final OrmawaRepository ormawaRepository;

    @Autowired
    public OrmawaService(OrmawaRepository ormawaRepository) {
        this.ormawaRepository = ormawaRepository;
    }

    public Ormawa saveOrmawa(Ormawa ormawa) {
        return ormawaRepository.save(ormawa);
    }

    // public Ormawa getOrmawaById(int id) {
    //     return ormawaRepository.findById(id).orElse(null);
    // }

    public List<Ormawa> getAllOrmawa() {
        return ormawaRepository.findAll();
    }

    public void deleteOrmawa(int id) {
        ormawaRepository.deleteById(id);
    }
     public Ormawa createOrmawa(Ormawa ormawa) {
        return ormawaRepository.save(ormawa);
    }


    public Ormawa getOrmawaById(int id) {
        return ormawaRepository.findById(id).orElse(null);
    }

    public Ormawa updateOrmawa(Integer id, Ormawa updatedOrmawa) {
    Optional<Ormawa> ormawaOptional = ormawaRepository.findById(id);
    if (ormawaOptional.isPresent()) {
        Ormawa ormawa = ormawaOptional.get();
        ormawa.setNama_ormawa(updatedOrmawa.getNama_ormawa());
        ormawa.setNama_singkatan_ormawa(updatedOrmawa.getNama_singkatan_ormawa());
        ormawa.setLogo_ormawa(updatedOrmawa.getLogo_ormawa());
        ormawa.setList_anggota(updatedOrmawa.getList_anggota());
        ormawa.setPembina(updatedOrmawa.getPembina());
        ormawa.setKetua(updatedOrmawa.getKetua());
        ormawa.setWakil(updatedOrmawa.getWakil());
        ormawa.setSekretaris(updatedOrmawa.getSekretaris());
        ormawa.setBendahara(updatedOrmawa.getBendahara());
        ormawa.setJumlah_anggota(updatedOrmawa.getJumlah_anggota());
        ormawa.setFoto_pembina(updatedOrmawa.getFoto_pembina());
        ormawa.setFoto_ketua(updatedOrmawa.getFoto_ketua());
        ormawa.setFoto_wakil(updatedOrmawa.getFoto_wakil());
        ormawa.setFoto_sekretaris(updatedOrmawa.getFoto_sekretaris());
        ormawa.setFoto_bendahara(updatedOrmawa.getFoto_bendahara());
        ormawa.setUpdated_at(updatedOrmawa.getUpdated_at());
        ormawa.setUpdated_by(updatedOrmawa.getUpdated_by());

        return ormawaRepository.save(ormawa);
    } else {
        throw new EntityNotFoundException("Ormawa with id " + id + " not found");
    }
}
}
