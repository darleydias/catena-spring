package com.github.darleydias.domain.entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_comarca")
public class Comarca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="coma_id")
    private Integer id;
    @Column(name="coma_nome",length = 100,nullable = false)
    private String nome;
    @Column(name="coma_tipo",length = 100,nullable = false)
    private String tipo;
    @OneToMany(mappedBy = "comarca")
    private Set<Promotor> promotores;

    public Comarca() {
    }
    public Comarca(String nome, String tipo,Integer id) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    public Comarca(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Comarca{" +
                "id='" + id + '\'' +
                ",nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

    public String getTipo() { return tipo;}
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id;}

    public Set<Promotor> getPromotores() { return promotores; }
    public void setPromotores(Set<Promotor> promotores) { this.promotores = promotores; }
}
