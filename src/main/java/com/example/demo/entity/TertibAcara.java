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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tertib_acara")
public class TertibAcara {

    @Id
    @Column(name = "id_tertib_acara")
    private Long id_tertib_acara;

    @Column(name = "waktu_mulai")
    private String waktu_mulai;

    @Column(name = "waktu_selesai")
    private String waktu_selesai;

    @Column(name = "aktivitas")
    private String aktivitas;

    @Column(name = "keterangan")
    private String keterangan;

    // @ManyToOne
    // @JoinColumn(name = "usulan_id")
    // private Usulan usulan;

    // Constructors, getters, and setters
}