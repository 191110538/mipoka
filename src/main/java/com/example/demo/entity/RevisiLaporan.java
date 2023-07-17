package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revisi_laporan")
public class RevisiLaporan {

    @Id
    @Column(name = "id_revisi_laporan")
    private Long id_revisi_laporan;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "revisi_pencapaian")
    private String revisi_pencapaian;

    @Column(name = "revisi_peserta_kegiatan_laporan")
    private String revisi_peserta_kegiatan_laporan;

    @Column(name = "revisi_biaya_kegiatan")
    private String revisi_biaya_kegiatan;

    @Column(name = "revisi_latar_belakang")
    private String revisi_latar_belakang;

    @Column(name = "revisi_hasil_kegiatan")
    private String revisi_hasil_kegiatan;

    @Column(name = "revisi_penutup")
    private String revisi_penutup;

    @Column(name = "revisi_foto_postingan_kegiatan")
    private String revisi_foto_postingan_kegiatan;

    @Column(name = "revisi_foto_dokumentasi_kegiatan")
    private String revisi_foto_dokumentasi_kegiatan;

    @Column(name = "revisi_foto_tabulasi_hasil")
    private String revisi_foto_tabulasi_hasil;

    @Column(name = "revisi_foto_faktur_pembayaran")
    private String revisi_foto_faktur_pembayaran;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    public RevisiLaporan(Long id_revisi_laporan) {
        this.id_revisi_laporan = id_revisi_laporan;
    }

    // Constructors, getters, and setters
}

