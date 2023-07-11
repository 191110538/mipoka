package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")

public class User implements Serializable {

    @Id
    @Column(name = "id_user")
    private String id_user;

    @ElementCollection
    @CollectionTable(name = "user_ormawa", joinColumns = @JoinColumn(name = "id_user"))
    @Column(name = "id_ormawa")
    private List<Long> id_ormawa;

    @Column(name = "email")
    private String email;

    @Column(name = "nama_lengkap")
    private String nama_lengkap;

    @Column(name = "nim")
    private String nim;

    @Column(name = "no_hp")
    private String no_hp;

    @Column(name = "image")
    private String image;

    @Column(name = "point_mpt")
    private Integer point_mpt;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "periode_mpt")
    private String periode_mpt;

    @Column(name = "status_mpt")
    private String status_mpt;

    @Column(name = "prodi")
    private String prodi;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_by")
    private String updated_by;

    public User(String id_user) {
        this.id_user =  id_user;
    }

}
