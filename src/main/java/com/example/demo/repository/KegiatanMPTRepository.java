package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.KegiatanMPT;

@Repository
public interface KegiatanMPTRepository extends JpaRepository<KegiatanMPT, Long> {
    // Tambahan method khusus jika diperlukan
}