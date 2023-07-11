package com.example.demo.entity;

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
    private Long id_tertib_acara;
    
    private String waktu_mulai;
    
    private String waktu_selesai;
    
    private String aktivitas;
    
    private String keterangan;
    
    // Constructors, getters, and setters
}
