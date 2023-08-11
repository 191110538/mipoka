package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Notifikasi;

public interface NotifikasiRepository extends JpaRepository<Notifikasi, Long> {
    List<Notifikasi> findAll();
}
