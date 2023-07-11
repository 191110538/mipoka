package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jenis_kegiatan_mpt")
public class JenisKegiatanMpt {

    @Id
    @Column(name = "id_jenis_kegiatan_mpt")
    private Long id_jenis_kegiatan_mpt;

    @Column(name = "nama_jenis_kegiatan_mpt")
    private String nama_jenis_kegiatan_mpt;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    public JenisKegiatanMpt(Long id_jenis_kegiatan_mpt) {
        this.id_jenis_kegiatan_mpt =  id_jenis_kegiatan_mpt;
    }

    // Constructors, getters, setters, and other methods
}
