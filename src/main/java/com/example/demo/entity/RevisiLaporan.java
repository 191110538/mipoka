package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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
    @JoinColumn(name = "id_admin")
    private Admin id_admin;

    @ManyToOne
    @JoinColumn(name = "id_laporan")
    private Laporan id_laporan;

    @ManyToOne
    @JoinColumn(name = "id_usulan")
    private Usulan id_usulan;

    @Column(name = "revisi_pencapaian")
    private String revisi_pencapaian;

    @ElementCollection
    @CollectionTable(name = "revisi_id_peserta_kegiatan_laporan", joinColumns = @JoinColumn(name = "revisi_laporan_id"))
    @Column(name = "id_peserta_kegiatan_laporan")
    private List<String> revisi_id_peserta_kegiatan_laporan;

    @ElementCollection
    @CollectionTable(name = "revisi_id_biaya_kegiatan", joinColumns = @JoinColumn(name = "revisi_laporan_id"))
    @Column(name = "id_biaya_kegiatan")
    private List<String> revisi_id_biaya_kegiatan;

    @Column(name = "revisi_latar_belakang", length = 4096)
    private String revisi_latar_belakang;

    @Column(name = "revisi_hasil_kegiatan", length = 4096)
    private String revisi_hasil_kegiatan;

    @Column(name = "revisi_penutup", length = 4096)
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

    // Constructors, getters, and setters
}

