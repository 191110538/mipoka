package com.example.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifikasi")
public class Notifikasi {

    @Id
    @Column(name = "id_notifikasi")
    private Long id_notifikasi;

    @Column(name = "teks_notifikasi")
    private String teks_notifikasi;

    @Column(name = "tgl_notifikasi")
    private String tgl_notifikasi;

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
