package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ormawa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ormawa implements Serializable {

    @Id
    @Column(name = "id_ormawa")
    private Integer id_ormawa;

    @Column(name = "nama_ormawa")
    private String nama_ormawa;

    @Column(name = "nama_singkatan_ormawa")
    private String nama_singkatan_ormawa;

    @Column(name = "logo_ormawa")
    private String logo_ormawa;

    @ElementCollection
    @CollectionTable(name = "anggota_ormawa",
            joinColumns = @JoinColumn(name = "id_ormawa"))
    @Column(name = "list_anggota")
    private List<String> list_anggota;

    @Column(name = "pembina")
    private String pembina;

    @Column(name = "ketua")
    private String ketua;

    @Column(name = "wakil")
    private String wakil;

    @Column(name = "sekretaris")
    private String sekretaris;

    @Column(name = "bendahara")
    private String bendahara;

    @Column(name = "jumlah_anggota")
    private Integer jumlah_anggota;

    @Column(name = "foto_pembina")
    private String foto_pembina;

    @Column(name = "foto_ketua")
    private String foto_ketua;

    @Column(name = "foto_wakil")
    private String foto_wakil;

    @Column(name = "foto_sekretaris")
    private String foto_sekretaris;

    @Column(name = "foto_bendahara")
    private String foto_bendahara;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "updated_at")
    private String updated_at;

    public Ormawa(int id_ormawa) {
        this.id_ormawa = id_ormawa;
    }
}


