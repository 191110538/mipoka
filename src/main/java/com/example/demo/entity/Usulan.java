package com.example.demo.entity;

import java.sql.Time;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usulan")
public class Usulan {

    @Id
    @Column(name = "id_usulan")
    private Long id_usulan;


    @ManyToOne
    @JoinColumn(name = "id_revisi_usulan")
    private RevisiUsulan revisi_usulan;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_ormawa")
    private Ormawa ormawa;

    @Column(name = "pembiayaan")
    private String pembiayaan;

    @Column(name = "nama_kegiatan")
    private String nama_kegiatan;

    @Column(name = "bentuk_kegiatan")
    private String bentuk_kegiatan;

    @Column(name = "kategori_bentuk_kegiatan")
    private String kategori_bentuk_kegiatan;

    @Column(name = "deskripsi_kegiatan")
    private String deskripsi_kegiatan;

    @Column(name = "tanggal_mulai_kegiatan")
    private String tanggal_mulai_kegiatan;

    @Column(name = "tanggal_selesai_kegiatan")
    private String tanggal_selesai_kegiatan;

    @Column(name = "waktu_mulai_kegiatan")
    private String waktu_mulai_kegiatan;

    @Column(name = "waktu_selesai_kegiatan")
    private String waktu_selesai_kegiatan;

    @Column(name = "tempat_kegiatan")
    private String tempat_kegiatan;

    @Column(name = "tanggal_keberangkatan")
    private String tanggal_keberangkatan;

    @Column(name = "tanggal_kepulangan")
    private String tanggal_kepulangan;

    @Column(name = "jumlah_partisipan")
    private String jumlah_partisipan;

    @Column(name = "kategori_jumlah_partisipan")
    private String kategori_jumlah_partisipan;

    @Column(name = "target_kegiatan")
    private String target_kegiatan;

    @Column(name = "total_pendanaan")
    private String total_pendanaan;

    @Column(name = "kategori_total_pendanaan")
    private String kategori_total_pendanaan;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "tanda_tangan_ormawa")
    private String tanda_tangan_ormawa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usulan_id")
    private List<Partisipan> partisipan;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usulan_id")
    private List<BiayaKegiatan> biaya_kegiatan;

    @Column(name = "latar_belakang" , length = 4096)
    private String latar_belakang;

    @Column(name = "tujuan_kegiatan", length = 1024)
    private String tujuan_kegiatan;

    @Column(name = "manfaat_kegiatan", length = 1024)
    private String manfaat_kegiatan;

    @Column(name = "bentuk_pelaksanaan_kegiatan" , length = 1024)
    private String bentuk_pelaksanaan_kegiatan;

    @Column(name = "target_pencapaian_kegiatan", length = 1024)
    private String target_pencapaian_kegiatan;

    @Column(name = "waktu_dan_tempat_pelaksanaan", length = 1024)
    private String waktu_dan_tempat_pelaksanaan;

    @Column(name = "rencana_anggaran_kegiatan", length = 2048)
    private String rencana_anggaran_kegiatan;

    @Column(name = "total_biaya")
    private Integer total_biaya;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usulan_id")
    private List<TertibAcaraa> tertib_acara;

    @Column(name = "perlengkapan_dan_peralatan" , length = 2048)
    private String perlengkapan_dan_peralatan;

    @Column(name = "penutup" , length = 1048)
    private String penutup;

    @Column(name = "foto_postingan_kegiatan")
    private String foto_postingan_kegiatan;

    @Column(name = "foto_surat_undangan_kegiatan")
    private String foto_surat_undangan_kegiatan;

    @Column(name = "foto_linimasa_kegiatan")
    private String foto_linimasa_kegiatan;

    @Column(name = "foto_tempat_kegiatan")
    private String foto_tempat_kegiatan;

    @Column(name = "file_usulan_kegiatan")
    private String file_usulan_kegiatan;

    @Column(name = "validasi_pembina")
    private String validasi_pembina;

    @Column(name = "tanda_tangan_pembina")
    private String tanda_tangan_pembina;

    @Column(name = "status_usulan")
    private String status_usulan;

    @Column(name = "roles")
    private String roles;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_by")
    private String updated_by;

    public Usulan(Long id_usulan) {
        this.id_usulan = id_usulan;
    }

    // @OneToMany(mappedBy = "usulan", cascade = CascadeType.ALL)
    // private List<BiayaKegiatan> biayaKegiatan;
    // Constructors, getters, and setters
}

