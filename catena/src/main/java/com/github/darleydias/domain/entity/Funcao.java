package com.github.darleydias.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_funcao")
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "func_id")
    private Integer id;
    @Column(name = "func_descri",length = 100,nullable = false)
    private String descri;
    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private Orgao orgao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

}
