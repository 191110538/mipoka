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
@Table(name = "prestasi")
public class Prestasi {

    @Id
    @Column(name = "id_prestasi")
    private Long id_prestasi;

    @ManyToOne
    @JoinColumn(name = "id_ormawa")
    private Ormawa ormawa;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "nama_kegiatan")
    private String nama_kegiatan;

    @Column(name = "waktu_penyelenggaraan")
    private String waktu_penyelenggaraan;

    @Column(name = "tingkat")
    private String tingkat;

    @Column(name = "prestasi_dicapai")
    private String prestasi_dicapai;

    @Column(name = "unggah_sertifikat")
    private String unggah_sertifikat;

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