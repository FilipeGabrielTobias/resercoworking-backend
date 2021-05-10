package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.dto.ModalidadeEspacoDto;
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
@Table(name = "modalidade_espaco")
public class ModalidadeEspaco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    private Boolean situacao = Boolean.TRUE;

    public ModalidadeEspaco(ModalidadeEspacoDto dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.situacao = dto.getSituacao();
    }

    public ModalidadeEspaco updateModalidadeEspaco(ModalidadeEspaco dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.situacao = dto.getSituacao();
        return this;
    }
}
