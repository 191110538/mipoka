package com.example.demo.entity;

import javax.persistence.Column;
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
@Table(name = "revisi_usulan")
public class RevisiUsulan {

    @Id
    @Column(name = "id_revisi_usulan")
    private Long id_revisi_usulan;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin id_admin;

    @ManyToOne
    @JoinColumn(name = "id_usulan")
    private Usulan id_usulan;

    @Column(name = "revisi_pembiayaan")
    private String revisi_pembiayaan;

    @Column(name = "revisi_nama_kegiatan")
    private String revisi_nama_kegiatan;

    @Column(name = "revisi_bentuk_kegiatan")
    private String revisi_bentuk_kegiatan;

    @Column(name = "revisi_kategori_bentuk_kegiatan")
    private String revisi_kategori_bentuk_kegiatan;

    @Column(name = "revisi_tempat_kegiatan")
    private String revisi_tempat_kegiatan;

    @Column(name = "revisi_deskripsi_kegiatan")
    private String revisi_deskripsi_kegiatan;

    @Column(name = "revisi_tanggal_mulai_kegiatan")
    private String revisi_tanggal_mulai_kegiatan;

    @Column(name = "revisi_tanggal_selesai_kegiatan")
    private String revisi_tanggal_selesai_kegiatan;

    @Column(name = "revisi_waktu_mulai_kegiatan")
    private String revisi_waktu_mulai_kegiatan;

    @Column(name = "revisi_waktu_selesai_kegiatan")
    private String revisi_waktu_selesai_kegiatan;

    @Column(name = "revisi_tanggal_keberangkatan")
    private String revisi_tanggal_keberangkatan;

    @Column(name = "revisi_tanggal_kepulangan")
    private String revisi_tanggal_kepulangan;

    @Column(name = "revisi_jumlah_partisipan")
    private String revisi_jumlah_partisipan;

    @Column(name = "revisi_kategori_jumlah_partisipan")
    private String revisi_kategori_jumlah_partisipan;

    @Column(name = "revisi_target_kegiatan")
    private String revisi_target_kegiatan;

    @Column(name = "revisi_total_pendanaan")
    private String revisi_total_pendanaan;

    @Column(name = "revisi_kategori_total_pendanaan")
    private String revisi_kategori_total_pendanaan;

    @Column(name = "revisi_keterangan")
    private String revisi_keterangan;

    @Column(name = "revisi_tanda_tangan_ormawa")
    private String revisi_tanda_tangan_ormawa;

    @ElementCollection
    @Column(name = "revisi_id_partisipan")
    private List<String> revisi_id_partisipan;

    @ElementCollection
    @Column(name = "revisi_id_rincian_biaya_kegiatan")
    private List<String> revisi_id_rincian_biaya_kegiatan;

    @Column(name = "revisi_latar_belakang")
    private String revisi_latar_belakang;

    @Column(name = "revisi_tujuan_kegiatan")
    private String revisi_tujuan_kegiatan;

    @Column(name = "revisi_manfaat_kegiatan")
    private String revisi_manfaat_kegiatan;

    @Column(name = "revisi_bentuk_pelaksanaan_kegiatan")
    private String revisi_bentuk_pelaksanaan_kegiatan;

    @Column(name = "revisi_target_pencapaian_kegiatan")
    private String revisi_target_pencapaian_kegiatan;

    @Column(name = "revisi_waktu_dan_tempat_pelaksanaan")
    private String revisi_waktu_dan_tempat_pelaksanaan;

    @Column(name = "revisi_rencana_anggaran_kegiatan")
    private String revisi_rencana_anggaran_kegiatan;

    @Column(name = "revisi_tertib_acara")
    private String revisi_tertib_acara;

    @Column(name = "revisi_perlengkapan_dan_peralatan")
    private String revisi_perlengkapan_dan_peralatan;

    @Column(name = "revisi_penutup")
    private String revisi_penutup;

    @Column(name = "revisi_foto_postingan_kegiatan")
    private String revisi_foto_postingan_kegiatan;

    @Column(name = "revisi_foto_surat_undangan_kegiatan")
    private String revisi_foto_surat_undangan_kegiatan;

    @Column(name = "revisi_foto_linimasa_kegiatan")
    private String revisi_foto_linimasa_kegiatan;

    @ElementCollection
    @Column(name = "revisi_foto_tempat_kegiatan")
    private List<String> revisi_foto_tempat_kegiatan;

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
