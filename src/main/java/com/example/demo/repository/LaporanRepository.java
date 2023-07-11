package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Laporan;

public interface LaporanRepository extends JpaRepository<Laporan, Long> {
}
