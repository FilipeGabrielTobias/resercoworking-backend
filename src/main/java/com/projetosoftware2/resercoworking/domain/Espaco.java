package com.projetosoftware2.resercoworking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "espaco")
public class Espaco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descicao;

    @Column(name = "metros_quadrados")
    private Double metrosQuadrados;

    @Column(name = "pontos")
    private Integer pontos;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "situacao", nullable = false)
    private Boolean situacao = Boolean.TRUE;
}
