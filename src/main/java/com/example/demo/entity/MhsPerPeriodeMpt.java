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
@Table(name = "mhs_per_periode_mpt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MhsPerPeriodeMpt {

    @Id
    @Column(name = "id_mhs_per_periode_mpt")
    private Long id_mhs_per_periode_mpt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_periode_mpt")
    private PeriodeMpt id_periode_mpt;

    @ManyToOne
    @JoinColumn(name = "id_kegiatan_per_periode_mpt")
    private KegiatanPerPeriodeMpt id_kegiatan_per_periode_mpt;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    public MhsPerPeriodeMpt(Long id_mhs_per_periode_mpt) {
        this.id_mhs_per_periode_mpt = id_mhs_per_periode_mpt;
    }
    // Constructors, getters, setters, and other methods
}