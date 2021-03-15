package com.projetosoftware2.resercoworking.dto;

import lombok.Data;

@Data
public class EspacoDto {
    private String nome;
    private String descicao;
    private Double metrosQuadrados;
    private Integer pontos;
    private Double nota;
    private Boolean situacao;
    private ModalidadeEspaco modalidadeEspaco;

    @Data
    public static class ModalidadeEspaco {
        private Long id;
        private String nome;
    }
}
