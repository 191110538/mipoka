package com.example.demo.entity;

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

import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "laporan")
public class Laporan {
    
    @Id
    @Column(name = "id_laporan")
    private Long id_laporan;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_ormawa")
    private Ormawa id_ormawa;

    @ManyToOne
    @JoinColumn(name = "id_usulan")
    private Usulan id_usulan;

    private String pencapaian;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_laporan")
    private List<PesertaKegiatanLaporan> peserta_kegiatan_laporan;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_laporan")
    private List<RincianBiayaKegiatan> rincian_biaya_kegiatan;

    @Column(name = "total_usulan")
    private Long total_usulan;

    @Column(name = "total_realisasi")
    private Long total_realisasi;

    @Column(name = "total_selisih")
    private Long total_selisih;

    @Column(name = "latar_belakang" ,length = 4096)
    private String latar_belakang;

    @Column(name = "hasil_kegiatan" , length = 4096)
    private String hasil_kegiatan;
   
    @Column(name = "penutup" , length = 1024)
    private String penutup;

    @Column(name = "foto_postingan_kegiatan")
    private String foto_postingan_kegiatan;

    
    @Column(name = "foto_dokumentasi_kegiatan")
    private String foto_dokumentasi_kegiatan;

    @Column(name = "foto_tabulasi_hasil")
    private String foto_tabulasi_hasil;

    @Column(name = "foto_faktur_pembayaran")
    private String foto_faktur_pembayaran;

    @Column(name = "file_laporan_kegiatan")
    private String file_laporan_kegiatan;

    @Column(name = "validasi_pembina")
    private Boolean validasi_pembina;

    @Column(name = "status_laporan")
    private String status_laporan;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    public Laporan(Long id_laporan) {
        this.id_laporan = id_laporan;
    }

}
