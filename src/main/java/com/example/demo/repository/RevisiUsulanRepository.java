package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RevisiUsulan;

@Repository
public interface RevisiUsulanRepository extends JpaRepository<RevisiUsulan, Long> {
}
