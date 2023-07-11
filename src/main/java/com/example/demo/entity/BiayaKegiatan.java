package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "biaya_kegiatan")
public class BiayaKegiatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biaya_kegiatan")
    private Long id_biaya_kegiatan;

    @Column(name = "nama_biaya_kegiatan")
    private String nama_biaya_kegiatan;

    @Column(name = "kuantiti")
    private Integer kuantiti;

    @Column(name = "harga_satuan")
    private Integer harga_satuan;

    @Column(name = "total")
    private Integer total;

    @Column(name = "keterangan")
    private String keterangan;

    // @ManyToOne
    // @JoinColumn(name = "usulan_id")
    // private Usulan usulan;

    // Constructors, getters, and setters
}
