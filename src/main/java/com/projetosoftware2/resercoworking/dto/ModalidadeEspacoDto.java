package com.projetosoftware2.resercoworking.dto;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.domain.Premiacao;
import lombok.Data;

import java.io.Serializable;

@Data
public class ModalidadeEspacoDto implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;

    public ModalidadeEspacoDto(ModalidadeEspaco modalidadeEspaco) {
        this.id = modalidadeEspaco.getId();
        this.nome = modalidadeEspaco.getNome();
        this.descricao = modalidadeEspaco.getDescricao();
    }
}
