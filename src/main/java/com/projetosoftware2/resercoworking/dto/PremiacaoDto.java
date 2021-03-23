package com.projetosoftware2.resercoworking.dto;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import lombok.Data;

@Data
public class PremiacaoDto {
    private Long id;
    private String nome;
    private String descricao;
    private Integer pontosNecessarios;
    private Boolean situacao;

    public PremiacaoDto(Premiacao premiacao) {
        this.id = premiacao.getId();
        this.nome = premiacao.getNome();
        this.descricao = premiacao.getDescricao();
        this.pontosNecessarios = premiacao.getPontosNecessarios();
        this.situacao = premiacao.getSituacao();
    }
}
