package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "berita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Berita {
    @Id
    @Column(name = "id_berita")
    private Long id_berita;
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "judul")
    private String judul;

    @Column(name = "penulis")
    private String penulis;

    @Column(name = "gambar")
    private String gambar;

    @Column(name = "teks" , length = 4096)
    private String teks;

    @Column(name = "tgl_terbit")
    private String tgl_terbit;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    // Constructors, getters, setters, and other methods
}