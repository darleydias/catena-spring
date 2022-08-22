package com.github.darleydias.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_orgao")
public class Orgao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="orgao_id")
    private Integer id;
    @Column(name="orgao_descri")
    private String descri;
    @OneToMany(mappedBy = "orgao")
    private Set<Funcao> funcoes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
}
