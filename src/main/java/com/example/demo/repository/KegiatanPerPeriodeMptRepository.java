package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.KegiatanPerPeriodeMpt;
import com.example.demo.entity.NamaKegiatanMpt;
import com.example.demo.entity.PeriodeMpt;


@Repository
public interface KegiatanPerPeriodeMptRepository extends JpaRepository<KegiatanPerPeriodeMpt, Long> {
    // Tambahan method khusus jika diperlukan
    // List<KegiatanPerPeriodeMpt> findByPeriodeMpt(PeriodeMpt id_periode_mpt);
    // List<KegiatanPerPeriodeMpt> findByNamaKegiatanMpt(NamaKegiatanMpt id_nama_kegiatan_mpt);
    // List<KegiatanPerPeriodeMpt> findByPeriodeMptAndNamaKegiatanMpt(PeriodeMpt id_periode_mpt, NamaKegiatanMpt id_nama_kegiatan_mpt);



}

