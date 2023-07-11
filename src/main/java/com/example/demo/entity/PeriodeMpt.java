package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "periode_mpt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodeMpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periode_mpt")
    private Long id_periode_mpt;

    @Column(name = "tahun_periode_mpt")
    private String tahun_periode_mpt;

    @Column(name = "periode_mengulang_mpt")
    private boolean periode_mengulang_mpt;

    @Column(name = "tanggal_mulai_periode_mpt")
    private String tanggal_mulai_periode_mpt;

    @Column(name = "tanggal_berakhir_periode_mpt")
    private String tanggal_berakhir_periode_mpt;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "updated_by")
    private String updated_by;

    // Constructors, getters, setters, and other methods

    public PeriodeMpt(Long id_periode_mpt) {
        this.id_periode_mpt = id_periode_mpt;
    }
}
