package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id_admin")
    private String id_admin;
    
    @Column(name = "email")
    private String email;

    @Column(name = "nama_lengkap")
    private String nama_lengkap;

    @Column(name = "nip")
    private String nip;

    @Column(name = "image")
    private String image;

    @Column(name = "no_hp")
    private String no_hp;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    
    public Admin(String id_admin) {
        this.id_admin =  id_admin;
    }
}