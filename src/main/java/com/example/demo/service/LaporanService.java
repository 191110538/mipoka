package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Laporan;
import com.example.demo.repository.LaporanRepository;

@Service
public class LaporanService {
    private final LaporanRepository laporanRepository;

    @Autowired
    public LaporanService(LaporanRepository laporanRepository) {
        this.laporanRepository = laporanRepository;
    }

    public Laporan createLaporan(Laporan laporan) {
        return laporanRepository.save(laporan);
    }

    public Laporan getLaporanById(Long id) {
        return laporanRepository.findById(id).orElse(null);
    }

    public Laporan updateLaporan(Long id, Laporan updatedLaporan) {
        Laporan laporan = laporanRepository.findById(id).orElse(null);
        if (laporan != null) {
            laporan.setId_user(updatedLaporan.getId_user());
            laporan.setId_ormawa(updatedLaporan.getId_ormawa());
            laporan.setId_usulan(updatedLaporan.getId_usulan());
            laporan.setPencapaian(updatedLaporan.getPencapaian());
            laporan.setPeserta_kegiatan_laporan(updatedLaporan.getPeserta_kegiatan_laporan());
            laporan.setRincian_biaya_kegiatan(updatedLaporan.getRincian_biaya_kegiatan());
            laporan.setTotal_usulan(updatedLaporan.getTotal_usulan());
            laporan.setTotal_realisasi(updatedLaporan.getTotal_realisasi());
            laporan.setTotal_selisih(updatedLaporan.getTotal_selisih());
            laporan.setLatar_belakang(updatedLaporan.getLatar_belakang());
            laporan.setHasil_kegiatan(updatedLaporan.getHasil_kegiatan());
            laporan.setPenutup(updatedLaporan.getPenutup());
            laporan.setFoto_postingan_kegiatan(updatedLaporan.getFoto_postingan_kegiatan());
            laporan.setFoto_dokumentasi_kegiatan(updatedLaporan.getFoto_dokumentasi_kegiatan());
            laporan.setFoto_tabulasi_hasil(updatedLaporan.getFoto_tabulasi_hasil());
            laporan.setFoto_faktur_pembayaran(updatedLaporan.getFoto_faktur_pembayaran());
            laporan.setFile_laporan_kegiatan(updatedLaporan.getFile_laporan_kegiatan());
            laporan.setValidasi_pembina(updatedLaporan.getValidasi_pembina());
            laporan.setStatus_laporan(updatedLaporan.getStatus_laporan());
            laporan.setCreated_at(updatedLaporan.getCreated_at());
            laporan.setCreated_by(updatedLaporan.getCreated_by());
            laporan.setUpdated_at(updatedLaporan.getUpdated_at());
            laporan.setUpdated_by(updatedLaporan.getUpdated_by());

            return laporanRepository.save(laporan);
        } else {
            return null;
        }
    }

    public boolean deleteLaporan(Long id) {
        Laporan laporan = laporanRepository.findById(id).orElse(null);
        if (laporan != null) {
            laporanRepository.delete(laporan);
            return true;
        } else {
            return false;
        }
    }
    public List<Laporan> getAllLaporan() {
        return laporanRepository.findAll();
    }
}
