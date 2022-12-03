package com.duett.back.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FruitEntity {
    @Id
    @SequenceGenerator( name = "FRUTAS_SEQ", sequenceName = "FRUTAS_SEQ" )
    @GeneratedValue( generator = "FRUTAS_SEQ", strategy = GenerationType.SEQUENCE)
    public Integer id;

    @Column(name = "descricao")
    private String descricao;
    private double valorA;
    private double valorB;
}
