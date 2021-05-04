package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.dto.EspacoDto;
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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descicao;

    @Column(name = "metros_quadrados", nullable = false)
    private Double metrosQuadrados;

    @Column(name = "pontos", nullable = false)
    private Integer qtPontos;
    
    @Column(name = "vl_hora", nullable = false)
    private Double vlHora;
    
    @Column(name = "nota")
    private Double nota;

    @Column(name = "situacao", nullable = false)
    private Boolean situacao = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_modalidade_espaco", nullable = false)
    private ModalidadeEspaco modalidadeEspaco;

    public Espaco(EspacoDto dto, ModalidadeEspaco modalidadeEspaco) {
        this.nome = dto.getNome();
        this.descicao = dto.getDescicao();
        this.metrosQuadrados = dto.getMetrosQuadrados();
        this.qtPontos = dto.getQtPontos();
        this.vlHora = dto.getVlHora();
        this.nota = dto.getNota();
        this.situacao = dto.getSituacao();
        this.modalidadeEspaco = modalidadeEspaco;
    }

    public Espaco updateEspaco(EspacoDto dto, ModalidadeEspaco modalidadeEspaco) {
        this.nome = dto.getNome();
        this.descicao = dto.getDescicao();
        this.metrosQuadrados = dto.getMetrosQuadrados();
        this.qtPontos = dto.getQtPontos();
        this.vlHora = dto.getVlHora();
        this.nota = dto.getNota();        
        this.situacao = dto.getSituacao();
        this.modalidadeEspaco = modalidadeEspaco;

        return this;
    }
}
