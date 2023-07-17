package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nama_kegiatan_mpt")
public class NamaKegiatanMpt {
    @Id
    @Column(name = "id_nama_kegiatan_mpt")
    private Long id_nama_kegiatan_mpt;


    @ManyToOne
    @JoinColumn(name = "id_jenis_kegiatan_mpt")
    private JenisKegiatanMpt jenis_kegiatan_mpt;

    @Column(name = "nama_kegiatan")
    private String nama_kegiatan;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    public NamaKegiatanMpt(Long id_nama_kegiatan_mpt) {
        this.id_nama_kegiatan_mpt = id_nama_kegiatan_mpt;
    }
}