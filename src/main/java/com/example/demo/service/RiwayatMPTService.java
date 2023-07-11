package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RiwayatMPT;
import com.example.demo.repository.RiwayatMPTRepository;
import java.lang.RuntimeException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RiwayatMPTService {

    @Autowired
    private RiwayatMPTRepository riwayatMPTRepository;

    public List<RiwayatMPT> getAllRiwayatMPT() {
        return riwayatMPTRepository.findAll();
    }

    public RiwayatMPT getRiwayatMPTById(Long id) {
        return riwayatMPTRepository.findById(id).orElse(null);
    }

    public RiwayatMPT saveRiwayatMPT(RiwayatMPT riwayatMPT) {
        return riwayatMPTRepository.save(riwayatMPT);
    }

    public RiwayatMPT updateRiwayatMPT(Long id, RiwayatMPT updatedRiwayatMPT) {
        RiwayatMPT riwayatMPT = getRiwayatMPTById(id);
        if (riwayatMPT != null) {
            riwayatMPT.setId_kegiatan_per_periode_mpt(updatedRiwayatMPT.getId_kegiatan_per_periode_mpt());
            // riwayatMPT.setId_user(updatedRiwayatMPT.getId_user());
            riwayatMPT.setStatus_mpt(updatedRiwayatMPT.getStatus_mpt());
            riwayatMPT.setFile_sertifikat_mpt(updatedRiwayatMPT.getFile_sertifikat_mpt());
            riwayatMPT.setHash(updatedRiwayatMPT.getHash());
            riwayatMPT.setKeterangan_mhs(updatedRiwayatMPT.getKeterangan_mhs());
            riwayatMPT.setKeterangan_sa(updatedRiwayatMPT.getKeterangan_sa());
            riwayatMPT.setCreated_at(updatedRiwayatMPT.getCreated_at());
            riwayatMPT.setCreated_by(updatedRiwayatMPT.getCreated_by());
            riwayatMPT.setUpdated_at(updatedRiwayatMPT.getUpdated_at());
            riwayatMPT.setUpdated_by(updatedRiwayatMPT.getUpdated_by());

            return riwayatMPTRepository.save(riwayatMPT);
        }
        return null;
    }

    public void deleteRiwayatMPT(Long id) {
        riwayatMPTRepository.deleteById(id);
    }
}