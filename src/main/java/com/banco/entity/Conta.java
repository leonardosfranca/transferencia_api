package com.banco.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

}
