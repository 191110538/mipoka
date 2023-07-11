package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.demo.entity.PeriodeMpt;
import com.example.demo.entity.NamaKegiatanMpt;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kegiatan_per_periode_mpt")
public class KegiatanPerPeriodeMpt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kegiatan_per_periode_mpt")
    private Long id_kegiatan_per_periode_mpt;

    @ManyToOne
    @JoinColumn(name = "id_periode_mpt")
    private PeriodeMpt id_periode_mpt;

    @ManyToOne
    @JoinColumn(name = "id_nama_kegiatan_mpt")
    private NamaKegiatanMpt id_nama_kegiatan_mpt;

    @Column(name = "tanggal_mulai_kegiatan_per_periode_mpt")
    private String tanggal_mulai_kegiatan_per_periode_mpt;

    @Column(name = "tanggal_selesai_kegiatan_per_periode_mpt")
    private String tanggal_selesai_kegiatan_per_periode_mpt;

    @Column(name = "point_mpt_diperoleh")
    private Integer point_mpt_diperoleh;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    // public KegiatanPerPeriodeMpt(Long id_kegiatan_per_periode_mpt) {
    //     this.id_kegiatan_per_periode_mpt = id_kegiatan_per_periode_mpt;
    // }

    // Constructors, getters, setters, and other methods
}