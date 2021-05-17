package com.projetosoftware2.resercoworking.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspacoDto {
    private String nome;
    private String descricao;
    private Double metrosQuadrados;
    private Integer quantidadePontos;
    private Double valorHora;
    private Double nota;
    private Boolean situacao;
    private ModalidadeEspaco modalidadeEspaco;

    @Data
    public static class ModalidadeEspaco {
        private Long id;
        private String nome;
    }
}
