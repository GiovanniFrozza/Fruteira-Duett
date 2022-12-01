package com.duett.back.entity;

import jakarta.persistence.*;

@Entity
public class FrutaEntity {
    @Id
    @SequenceGenerator( name = "FRUTAS_SEQ", sequenceName = "FRUTAS_SEQ" )
    @GeneratedValue( generator = "FRUTAS_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer id;

    private String descricao;
    private double valorA;
    private double valorB;

    public FrutaEntity(Integer id, String descricao, double valorA, double valorB) {
        this.id = id;
        this.descricao = descricao;
        this.valorA = valorA;
        this.valorB = valorB;
    }

    public FrutaEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorA() {
        return valorA;
    }

    public void setValorA(double valorA) {
        this.valorA = valorA;
    }

    public double getValorB() {
        return valorB;
    }

    public void setValorB(double valorB) {
        this.valorB = valorB;
    }
}
