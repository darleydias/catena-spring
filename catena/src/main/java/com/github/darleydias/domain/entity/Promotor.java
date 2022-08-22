package com.github.darleydias.domain.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_promotor")
public class Promotor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prom_id")
    private Integer id;
    @Column(name = "prom_nome",nullable = false,length = 100)
    private String nome;
    @Column(name = "prom_mamp",nullable = false,length = 20)
    private String mamp;
    @Column(name = "prom_sexo",nullable = false,length = 20)
    private String sexo;
    @Column(name = "prom_dtnasc",nullable = false)
    private LocalDate dtNasc;
    @ManyToOne
    @JoinColumn(name = "coma_id")
    private Comarca comarca;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMamp() {
        return mamp;
    }
    public void setMamp(String mamp) {
        this.mamp = mamp;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }
    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Comarca getComarca() { return comarca; }
    public void setComarca(Comarca comarca) { this.comarca = comarca; }


    @Override
    public String toString() {
        return "Promotor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", mamp='" + mamp + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dtNasc=" + dtNasc +
                '}';
    }
}
