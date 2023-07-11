package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "id_session")
    private Long id_session;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_ormawa")
    private Ormawa id_ormawa;

    @Column(name = "tanggal_mulai")
    private String tanggal_mulai;

    @Column(name = "tanggal_selesai")
    private String tanggal_selesai;

    private String ruangan;
    private String gedung;

    @Column(name = "waktu_mulai_penggunaan")
    private String waktu_mulai_penggunaan;

    @Column(name = "waktu_selesai_penggunaan")
    private String waktu_selesai_penggunaan;

    private String kegiatan;
    private int proyektor;
    private int laptop;
    private int mikrofon;
    private int speaker;
    private int meja;
    private int kursi;

    @Column(name = "papan_tulis")
    private int papan_tulis;

    private int spidol;

    @Column(name = "lain_lain")
    private String lain_lain;

    private String status;
    private String keterangan;

    @Column(name = "file_session ")
    private String file_session;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "created_by")
    private String created_by;

    // Constructors, getters, setters, and other methods
}

