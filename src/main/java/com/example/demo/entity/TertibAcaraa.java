package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "tertib_acara")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TertibAcaraa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tertib_acara;
    
    private String waktu_mulai;
    
    private String waktu_selesai;
    
    private String aktivitas;
    
    private String keterangan;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;
    
    // Constructors, getters, and setters
}
