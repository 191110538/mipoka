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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kegiatan_mpt")
public class KegiatanMPT {

    @Id
    @Column(name = "id_kegiatan_mpt")
    private Long idKegiatanMPT;

    @Column(name = "jenis_kegiatan_mpt")
    private String jenisKegiatanMPT;

    @Column(name = "nama_kegiatan_mpt")
    private String namaKegiatanMPT;

    @Column(name = "id_periode_mpt")
    private String idPeriodeMPT;

    @Column(name = "tanggal_mulai_kegiatan_mpt")
    private String tanggalMulaiKegiatanMPT;

    @Column(name = "tanggal_selesai_kegiatan_mpt")
    private String tanggalSelesaiKegiatanMPT;

    @Column(name = "point_mpt_diperoleh")
    private int pointMPTDiperoleh;

    // constructors, getters, setters, and other methods
}
