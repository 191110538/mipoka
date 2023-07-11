package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RevisiLaporan;
import com.example.demo.repository.RevisiLaporanRepository;

@Service
public class RevisiLaporanService {

    private final RevisiLaporanRepository revisiLaporanRepository;

    @Autowired
    public RevisiLaporanService(RevisiLaporanRepository revisiLaporanRepository) {
        this.revisiLaporanRepository = revisiLaporanRepository;
    }

    public RevisiLaporan createRevisiLaporan(RevisiLaporan revisiLaporan) {
        return revisiLaporanRepository.save(revisiLaporan);
    }

    public List<RevisiLaporan> getAllRevisiLaporan() {
        return revisiLaporanRepository.findAll();
    }

    public RevisiLaporan getRevisiLaporanById(Long id) {
        return revisiLaporanRepository.findById(id).orElse(null);
    }

    public RevisiLaporan updateRevisiLaporan(Long id, RevisiLaporan revisiLaporan) {
        RevisiLaporan existingRevisiLaporan = revisiLaporanRepository.findById(id).orElse(null);
        if (existingRevisiLaporan != null) {
            existingRevisiLaporan.setId_admin(revisiLaporan.getId_admin());
            existingRevisiLaporan.setId_laporan(revisiLaporan.getId_laporan());
            existingRevisiLaporan.setId_usulan(revisiLaporan.getId_usulan());
            existingRevisiLaporan.setRevisi_pencapaian(revisiLaporan.getRevisi_pencapaian());
            existingRevisiLaporan.setRevisi_id_peserta_kegiatan_laporan(revisiLaporan.getRevisi_id_peserta_kegiatan_laporan());
            existingRevisiLaporan.setRevisi_id_biaya_kegiatan(revisiLaporan.getRevisi_id_biaya_kegiatan());
            existingRevisiLaporan.setRevisi_latar_belakang(revisiLaporan.getRevisi_latar_belakang());
            existingRevisiLaporan.setRevisi_hasil_kegiatan(revisiLaporan.getRevisi_hasil_kegiatan());
            existingRevisiLaporan.setRevisi_penutup(revisiLaporan.getRevisi_penutup());
            existingRevisiLaporan.setRevisi_foto_postingan_kegiatan(revisiLaporan.getRevisi_foto_postingan_kegiatan());
            existingRevisiLaporan.setRevisi_foto_dokumentasi_kegiatan(revisiLaporan.getRevisi_foto_dokumentasi_kegiatan());
            existingRevisiLaporan.setRevisi_foto_tabulasi_hasil(revisiLaporan.getRevisi_foto_tabulasi_hasil());
            existingRevisiLaporan.setRevisi_foto_faktur_pembayaran(revisiLaporan.getRevisi_foto_faktur_pembayaran());
            existingRevisiLaporan.setCreated_at(revisiLaporan.getCreated_at());
            existingRevisiLaporan.setCreated_by(revisiLaporan.getCreated_by());
            existingRevisiLaporan.setUpdated_at(revisiLaporan.getUpdated_at());
            existingRevisiLaporan.setUpdated_by(revisiLaporan.getUpdated_by());

            return revisiLaporanRepository.save(existingRevisiLaporan);
        }
        return null;
    }

    public void deleteRevisiLaporan(Long id) {
        revisiLaporanRepository.deleteById(id);
    }
}
