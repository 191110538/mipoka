package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RiwayatMPT;
import com.example.demo.entity.Usulan;

@Repository
public interface UsulanRepository extends JpaRepository<Usulan, Long> {
    // Tambahkan kueri khusus jika diperlukan
    
}
