package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RiwayatMPT;


@Repository
public interface RiwayatMPTRepository extends JpaRepository<RiwayatMPT, Long> {
    // Anda dapat menambahkan method khusus sesuai kebutuhan query Anda di sini
}
