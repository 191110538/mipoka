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
@Table(name = "rincian_biaya_kegiatan")
public class RincianBiayaKegiatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rincian_biaya_kegiatan")
    private Long id_rincian_biaya_kegiatan;

    private String laporan;

    @Column(name = "nama_biaya")
    private String nama_biaya;

    private String keterangan;

    private Integer kuantitas;

    @Column(name = "harga_satuan")
    private Integer harga_satuan;

    @Column(name = "usulan_anggaran")
    private Long usulan_anggaran;

    @Column(name = "realisasi_anggaran")
    private Long realisasi_anggaran;

    private Long selisih;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;
}
