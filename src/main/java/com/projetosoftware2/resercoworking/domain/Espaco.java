package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.dto.EspacoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "metros_quadrados", nullable = false)
    private Double metrosQuadrados;

    @Column(name = "quantidade_pontos", nullable = false)
    private Integer quantidadePontos;
    
    @Column(name = "valor_hora", nullable = false)
    private Double valorHora;
    
    @Column(name = "nota")
    private Double nota;

    @Column(name = "situacao", nullable = false)
    private Boolean situacao = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_modalidade_espaco", nullable = false)
    private ModalidadeEspaco modalidadeEspaco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagem")
    private Arquivo imagemEspaco;
}
