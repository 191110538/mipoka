package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.KegiatanMPT;
import com.example.demo.repository.KegiatanMPTRepository;

@Service
public class KegiatanMPTService {

    private final KegiatanMPTRepository kegiatanMPTRepository;

    @Autowired
    public KegiatanMPTService(KegiatanMPTRepository kegiatanMPTRepository) {
        this.kegiatanMPTRepository = kegiatanMPTRepository;
    }

    public KegiatanMPT saveKegiatanMPT(KegiatanMPT kegiatanMPT) {
        return kegiatanMPTRepository.save(kegiatanMPT);
    }

    public KegiatanMPT getKegiatanMPTById(Long id) {
        return kegiatanMPTRepository.findById(id).orElse(null);
    }

    public List<KegiatanMPT> getAllKegiatanMPT() {
        return kegiatanMPTRepository.findAll();
    }

    public void deleteKegiatanMPT(Long id) {
        kegiatanMPTRepository.deleteById(id);
    }

    public KegiatanMPT updateKegiatanMPT(Long id, KegiatanMPT updatedKegiatanMPT) {
        Optional<KegiatanMPT> kegiatanMPTOptional = kegiatanMPTRepository.findById(id);
        if (kegiatanMPTOptional.isPresent()) {
            KegiatanMPT kegiatanMPT = kegiatanMPTOptional.get();
            kegiatanMPT.setJenisKegiatanMPT(updatedKegiatanMPT.getJenisKegiatanMPT());
            kegiatanMPT.setNamaKegiatanMPT(updatedKegiatanMPT.getNamaKegiatanMPT());
            kegiatanMPT.setIdPeriodeMPT(updatedKegiatanMPT.getIdPeriodeMPT());
            kegiatanMPT.setTanggalMulaiKegiatanMPT(updatedKegiatanMPT.getTanggalMulaiKegiatanMPT());
            kegiatanMPT.setTanggalSelesaiKegiatanMPT(updatedKegiatanMPT.getTanggalSelesaiKegiatanMPT());
            kegiatanMPT.setPointMPTDiperoleh(updatedKegiatanMPT.getPointMPTDiperoleh());
            return kegiatanMPTRepository.save(kegiatanMPT);
        } else {
            throw new RuntimeException("Kegiatan MPT not found with id: " + id);
        }
    }
}
