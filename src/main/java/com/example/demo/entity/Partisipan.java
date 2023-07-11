package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partisipan")
public class Partisipan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_partisipan;

    // @ManyToOne
    // @JoinColumn(name = "id_usulan")
    // private Usulan usulan;

    @Column(name = "no_induk")
    private String no_induk;

    @Column(name = "nama_partisipan")
    private String nama_partisipan;

    @Column(name = "nik")
    private String nik;

    @Column(name = "tempat_lahir")
    private String tempat_lahir;

    @Column(name = "tgl_lahir")
    private String tgl_lahir;

    @Column(name = "peran_partisipan")
    private String peran_partisipan;

    @Column(name = "dasar_pengiriman", length = 1000)
    private String dasar_pengiriman;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    // Constructors, getters, and setters

    // ... (getters and setters for all fields)
}
