package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.KegiatanPerPeriodeMpt;
import com.example.demo.entity.NamaKegiatanMpt;
import com.example.demo.entity.PeriodeMpt;
import com.example.demo.repository.KegiatanPerPeriodeMptRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KegiatanPerPeriodeMptService {

    private final KegiatanPerPeriodeMptRepository kegiatanPerPeriodeMptRepository;

    @Autowired
    public KegiatanPerPeriodeMptService(KegiatanPerPeriodeMptRepository kegiatanPerPeriodeMptRepository) {
        this.kegiatanPerPeriodeMptRepository = kegiatanPerPeriodeMptRepository;
    }

    public KegiatanPerPeriodeMpt getKegiatanPerPeriodeMptById(Long id) {
        return kegiatanPerPeriodeMptRepository.findById(id).orElse(null);
    }

    public List<KegiatanPerPeriodeMpt> getAllKegiatanPerPeriodeMpt() {
        return kegiatanPerPeriodeMptRepository.findAll();
    }

    public KegiatanPerPeriodeMpt createKegiatanPerPeriodeMpt(KegiatanPerPeriodeMpt kegiatanPerPeriodeMpt) {
        return kegiatanPerPeriodeMptRepository.save(kegiatanPerPeriodeMpt);
    }

    public KegiatanPerPeriodeMpt updateKegiatanPerPeriodeMpt(Long id,
            KegiatanPerPeriodeMpt updatedKegiatanPerPeriodeMpt) {
        Optional<KegiatanPerPeriodeMpt> kegiatanPerPeriodeMptOptional = kegiatanPerPeriodeMptRepository.findById(id);
        if (kegiatanPerPeriodeMptOptional.isPresent()) {
            KegiatanPerPeriodeMpt kegiatanPerPeriodeMpt = kegiatanPerPeriodeMptOptional.get();
            kegiatanPerPeriodeMpt.setTanggal_mulai_kegiatan_per_periode_mpt(
                    updatedKegiatanPerPeriodeMpt.getTanggal_mulai_kegiatan_per_periode_mpt());
            kegiatanPerPeriodeMpt.setTanggal_selesai_kegiatan_per_periode_mpt(
                    updatedKegiatanPerPeriodeMpt.getTanggal_selesai_kegiatan_per_periode_mpt());
            kegiatanPerPeriodeMpt.setPoint_mpt_diperoleh(updatedKegiatanPerPeriodeMpt.getPoint_mpt_diperoleh());
            // Set other updated fields
            kegiatanPerPeriodeMpt.setCreated_at(updatedKegiatanPerPeriodeMpt.getCreated_at());
            kegiatanPerPeriodeMpt.setCreated_by(updatedKegiatanPerPeriodeMpt.getCreated_by());
            kegiatanPerPeriodeMpt.setUpdated_at(updatedKegiatanPerPeriodeMpt.getUpdated_at());
            kegiatanPerPeriodeMpt.setUpdated_by(updatedKegiatanPerPeriodeMpt.getUpdated_by());
            // Set additional fields

            return kegiatanPerPeriodeMptRepository.save(kegiatanPerPeriodeMpt);
        } else {
            throw new IllegalArgumentException("Kegiatan Per Periode MPT with ID " + id + " does not exist");
        }
    }

    public boolean deleteKegiatanPerPeriodeMpt(Long id) {
        KegiatanPerPeriodeMpt kegiatanPerPeriodeMpt = kegiatanPerPeriodeMptRepository.findById(id).orElse(null);
        if (kegiatanPerPeriodeMpt != null) {
            kegiatanPerPeriodeMptRepository.delete(kegiatanPerPeriodeMpt);
            return true;
        } else {
            return false;
        }
    }

    // public List<KegiatanPerPeriodeMpt> filterKegiatanPerPeriodeMptByIdPeriodeAndIdNamaKegiatan(Long idPeriode,
    //         Long idNamaKegiatan) {
    //     if (idPeriode == 0 && idNamaKegiatan == 0) {
    //         return kegiatanPerPeriodeMptRepository.findAll();
    //     } else if (idPeriode == 0) {
    //         return kegiatanPerPeriodeMptRepository.findByNamaKegiatanMpt(new NamaKegiatanMpt(idNamaKegiatan));
    //     } else if (idNamaKegiatan == 0) {
    //         return kegiatanPerPeriodeMptRepository.findByPeriodeMpt(new PeriodeMpt(idPeriode));
    //     } else {
    //         return kegiatanPerPeriodeMptRepository.findByPeriodeMptAndNamaKegiatanMpt(
    //                 new PeriodeMpt(idPeriode), new NamaKegiatanMpt(idNamaKegiatan));
    //     }
    // }
}
