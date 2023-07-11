package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "riwayat_mpt")
public class RiwayatMPT implements Serializable{

    @Id
    @Column(name = "id_riwayat_mpt")
    private Long id_riwayat_mpt;

    @ManyToOne
    @JoinColumn(name = "id_kegiatan_per_periode_mpt")
    private KegiatanPerPeriodeMpt id_kegiatan_per_periode_mpt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "status_mpt")
    private String status_mpt;

    @Column(name = "file_sertifikat_mpt")
    private String file_sertifikat_mpt;

    @Column(name = "hash")
    private String hash;

    @Column(name = "keterangan_mhs")
    private String keterangan_mhs;

    @Column(name = "keterangan_sa")
    private String keterangan_sa;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;
}
