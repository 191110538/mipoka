package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.CascadeType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "kegiatan_mpt")
public class KegiatanMPT implements Serializable {

    @Id
    @Column(name = "id_kegiatan_mpt")
    private Long id_kegiatan_mpt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jenis_kegiatan_mpt")
    private JenisKegiatanMpt jenis_kegiatan_mpt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_periode_mpt")
    private PeriodeMpt periode_mpt;

    @Column(name = "nama_kegiatan_mpt")
    private String nama_kegiatan_mpt;

    @Column(name = "tanggal_mulai_kegiatan_mpt")
    private String tanggal_mulai_kegiatan_mpt;

    @Column(name = "tanggal_selesai_kegiatan_mpt")
    private String tanggal_selesai_kegiatan_mpt;

    @Column(name = "point_mpt_diperoleh")
    private int point_mpt_diperoleh;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;
}
